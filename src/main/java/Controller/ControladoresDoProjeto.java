package Controller;

import Model.Projetos;
import Util.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ControladoresDoProjeto {

    public static void save(Projetos projetos) {

        String sql = "INSERT INTO projetos(NOME, DESCRICAO, DATADECRIACAO, DATADEATUALIZACAO) VALUES (? , ? ,? ,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {

            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS..
            connection = ConexaoBancoDeDados.getConnection();

            //AO PREPARAR A QUERY LEMBRAR DE UTILIZAR O connection antes.
            statement = connection.prepareStatement(sql);

            //SETANDO OS VALORES PARA O STATEMENT. 
            statement.setString(1, projetos.getNOME());
            statement.setString(2, projetos.getDESCRICAO());
            statement.setDate(3, new Date(projetos.getDATADECRIACAO().getTime()));
            statement.setDate(4, new Date(projetos.getDATADEATUALIZACAO().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Inserir Projeto", ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(connection, statement);
        }
    }

    public static void update(Projetos projetos) {

        String sql = "UPDATE projetos SET "
                + "NOME = ?, "
                + "DESCRICAO = ?, "
                + "DATADECRIACAO = ?, "
                + "DATADEATUALIZACAO = ? "
                + "WHERE ID = ?";

        Connection connection = null; // CONECTOR BANCO DE DADOS.
        PreparedStatement statement = null; // FILTRO DE BUSCA

        try {

            //ESTABELECENDO CONEXÃO   
            connection = ConexaoBancoDeDados.getConnection();

            //PREPARANDO A QUERY
            statement = connection.prepareStatement(sql);

            //SETANDO OS VALORES PARA DENTRO DO STATEMENT
            statement.setString(1, projetos.getNOME());
            statement.setString(2, projetos.getDESCRICAO());
            statement.setDate(3, new Date(projetos.getDATADECRIACAO().getTime()));
            statement.setDate(4, new Date(projetos.getDATADEATUALIZACAO().getTime()));
            statement.setInt(5, projetos.getID());
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar Projeto", ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(connection, statement);
        }
    }

    public static void removeByID(int ID) {

        String sql = "DELETE FROM projetos WHERE ID = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // ESTABELECENDO A CONEXÃO
            connection = ConexaoBancoDeDados.getConnection();

            //PREPARANDO A QUERY
            statement = connection.prepareStatement(sql);

            //SETANDO OS VALORES PARA O FILTRO DE BUSCA 
            statement.setInt(1, ID);
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao Deletar o Projeto", ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(connection, statement);

        }
    }

// LEMBRAR SEMPRE QUE O MÉTODO DE PESQUISA RECEBE COMO PARÂMETRO O ID DA FOREIGN KEY    
// LEMBRAR TAMBÉM DE STARTAR ESSE MÉTODO COMO STATIC SE NÃO A PESQUISA N FUNCIONA...
    public static List<Projetos> getAll() {

        String sql = "SELECT * FROM projetos";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Projetos> projetosList = new ArrayList<>(); // padrão da nossa lista

        try {
            // ESTABELECENDO CONEXÃO     
            connection = ConexaoBancoDeDados.getConnection();

            // PREPARANDO A QUERY
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();//VAI RETORNAR O VALOR SETADO PARA O STATEMENT

            //ENQUANTO HOUVEREM VALORES A SEREM PERCORRIDOS NO MEU RESULTSET.
            while (resultSet.next()) {

                Projetos projeto = new Projetos();

                projeto.setID(resultSet.getInt("ID"));
                projeto.setNOME(resultSet.getString("NOME"));
                projeto.setDESCRICAO(resultSet.getString("DESCRICAO"));
                projeto.setDATADECRIACAO(resultSet.getDate("DATADECRIACAO"));
                projeto.setDATADEATUALIZACAO(resultSet.getDate("DATADEATUALIZACAO"));
                projetosList.add(projeto);

            }

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fazer a Pesquisa do Projeto", ex);
        } finally {
            ConexaoBancoDeDados.closeConnection(connection, statement, resultSet);
            return projetosList;

        }

    }

}
