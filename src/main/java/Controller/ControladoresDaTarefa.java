package Controller;

// DEPENDENCIA NECESSÁRIA PARA IMPLEMENTAR OS MÉTODOS NO CONTROLLER...
import Model.Tarefas;
import Util.ConexaoBancoDeDados;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ControladoresDaTarefa {
    
  //FUNÇÃO DE INSERIR NO BANCO DE DADOS..  
  public static void save(Tarefas tarefas){  
      
   String sql = "INSERT INTO tarefas (IDPROJETO, NOME, DESCRICAO, COMPLETED, NOTAS, PRAZO, DATACRIACAO, DATAATUALIZACAO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";   
        
      Connection connection = null;  
      PreparedStatement statement = null;
      
      try{
      
      //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS    
      connection = ConexaoBancoDeDados.getConnection();
      
      //PREPARANDO A QUERY
      statement = connection.prepareStatement(sql);
  
      // ESSES VALORES DE STATEMENT SERÃO SUBSTITUIDOS PELOS (?,?,?,?,?)....
      statement.setInt(1,tarefas.getIDPROJETO());
      statement.setString(2, tarefas.getNOME());
      statement.setString(3, tarefas.getDESCRICAO());
      statement.setBoolean(4, tarefas.COMPLETED());
      statement.setString(5, tarefas.getNOTAS());
      statement.setDate(6, new Date(tarefas.getPRAZO().getTime()));
      statement.setDate(7, new Date(tarefas.getDATACRIACAO().getTime()));
      statement.setDate(8, new Date(tarefas.getDATAATUALIZACAO().getTime()));
      
      //EXECUTANDO A QUERY
      statement.execute();
      
    } catch (SQLException ex){
        throw new RuntimeException("Erro ao Inserir Tarefa" + ex.getMessage(), ex);
    }finally{   
        ConexaoBancoDeDados.closeConnection(connection, statement);
          
      }
  }   
    
  // FUNÇÃO DE ATUALIZAR NO BANCO DE DADOS....
    public static void update(Tarefas tarefas){
      
     String sql = "UPDATE tarefas SET "   
             + "IDPROJETO = ?, "
             + "NOME = ?, "
             + "DESCRICAO = ?, "
             + "COMPLETED = ?, "
             + "NOTAS = ?, "
             + "PRAZO = ?, "
             + "DATACRIACAO = ?, "
             + "DataAtualizacao = ? "
             + "WHERE ID = ? ";
     
        
     Connection connection = null;   
     PreparedStatement  statement =  null;
        
    try{    
        
    //ESTABELECENDO A CONEXÃO COM O BANCO DE DADOS    
    connection = ConexaoBancoDeDados.getConnection();
    
    // PREPARANDO A QUERY
    statement = connection.prepareStatement(sql);
    
    // SETANDO OS VALORES DO STATEMENT..
    statement.setInt(1, tarefas.getIDPROJETO());
    statement.setString(2, tarefas.getNOME());
    statement.setString(3, tarefas.getDESCRICAO());
    statement.setBoolean(4, tarefas.COMPLETED());
    statement.setString(5, tarefas.getNOTAS());
    statement.setDate(6, new Date(tarefas.getPRAZO().getTime()));
    statement.setDate(7, new Date(tarefas.getDATACRIACAO().getTime()));
    statement.setDate(8, new Date(tarefas.getDATAATUALIZACAO().getTime()));   
    statement.setInt(9, tarefas.getID());
    
    
    //EXECUTANDO A QUERY
    statement.execute();
             
    } catch (SQLException ex){      
     throw new RuntimeException("Erro ao atualizar a Tarefa" + ex.getMessage(), ex);   
    }finally{
        
     ConexaoBancoDeDados.closeConnection(connection, statement);
        
        
  }
    
 } 
    
  // FUNÇÃO DELETE NO BANCO DE DADOS...
  public static void RemoveById(int TarefasID){
      
   String sql = "DELETE FROM tarefas WHERE ID = ?";  
   
   Connection connection = null;
   PreparedStatement statement = null;
      
   try{
       
    //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
    connection = ConexaoBancoDeDados.getConnection();   
    
    //PREPARANDO A QUERY
    statement = connection.prepareStatement(sql);
    
    //SETANDO OS VALORES QUE CORRESPONDE AO FILTRO DE BUSCA
    statement.setInt (1, TarefasID);
    
    //EXECUTANDO A QUERY
    statement.execute();
       
       
   } catch (Exception e){
     throw new RuntimeException ("Erro ao Deletar Tarefa", e);  
   }finally{
    ConexaoBancoDeDados.closeConnection(connection, statement);
   }
      
  }
    
  public static List<Tarefas> getAll(int IDPROJETO){
      
   String sql = "SELECT * FROM tarefas WHERE IDPROJETO = ?";
   
   Connection connection = null;
   PreparedStatement statement = null;
   ResultSet resultSet = null;
   
   // LISTA DE TAREFAS QUE SERÁ DEVOLVIDA QUANDO A CHAMADA DO MÉTODO ACONTECER.
   List<Tarefas> tarefasList = new ArrayList<Tarefas>();
   
   try{
       
   //ESTABELECENDO A CONEXÃO COM O BANCO    
   connection = ConexaoBancoDeDados.getConnection();
   
   //PREPARANDO A QUERY
   statement = connection.prepareStatement(sql);
   
   //SETANDO OS VALORES QUE CORRESPONDE AO FILTRO DE BUSCA
   statement.setInt(1, IDPROJETO);
   
   //VALOR RETORNADO PELA EXECUÇÃO DA QUERY
   resultSet = statement.executeQuery();// VAI NOS DEVOLVER O VALOR SETADO NA PESQUISA DO BANCO DE DADOS
       
 //ENQUANTO HOUVEREM VALORES A SEREM PERCORRIDOS NO MEU resultSet.  
   while(resultSet.next()){
       
       // ESSA PARTE DO CÓDIGO VAI BUSCAR AS TAREFAS NO BANCO
       Tarefas tarefa = new Tarefas();    
       
  tarefa.setID(resultSet.getInt("ID"));
  tarefa.setIDPROJETO(resultSet.getInt("IDPROJETO"));
  tarefa.setNOME(resultSet.getString("NOME"));
  tarefa.setDESCRICAO(resultSet.getString("DESCRICAO"));
  tarefa.setCOMPLETED(resultSet.getBoolean("COMPLETED"));     
  tarefa.setNOTAS(resultSet.getString("NOTAS"));     
  tarefa.setPRAZO(resultSet.getDate("PRAZO"));     
  tarefa.setDATACRIACAO(resultSet.getDate("DATACRIACAO"));    
  tarefa.setDATAATUALIZACAO(resultSet.getDate("DATAATUALIZACAO"));       
  tarefasList.add(tarefa);   
       
  // MAIS UMA OBS: EU HAVIA ESQUECIDO DE IMPLEMENTAR MEU SETNOME AQUI NA CONSULTA
  // E AI A MINHA COLUNA DE NOME NO MEU GRADE NÃO ESTAVA APARECENDO.
  
  
  //OBS: ATUALIZEI DE tarefas.add(tarefasList) para tarefasList.add(tarefa).
  //SÓ ASSIM QUE EU CONSEGUI FAZER COM QUE MEU CARREGAMENTO DE TAREFAS FUNCIONASSE.
       
   }
         
       
   } catch (SQLException ex){     
       throw new RuntimeException ("Erro ao fazer pesquisa das tarefas!" + ex.getMessage(), ex);
   }finally{    
       ConexaoBancoDeDados.closeConnection(connection, statement, resultSet);
      
    // LISTA DE TAREFAS QUE FOI CRIADA E CARREGADA DO BANCO DE DADOS...
    return tarefasList;   
  }
 }
}
