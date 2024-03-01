package Util;


// PACOTES NECESSÁRIOS PARA IMPORTAR O BANCO DE DADOS...
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBancoDeDados {
    
  // 4 - ATRIBUTOS PRINCIPAIS NECESSÁRIOS PARA UMA CONEXÃO COM O BANCO DE DADOS
   public static final String DRIVER = "com.mysql.jdbc.Driver"; 
   public static final String URL = "jdbc:mysql://127.0.0.1:3306/meuapp";
   public static final String USER = "root";
   public static final String PASS = "";
   
   
   // CONEXÃO COM O BANCO DE DADOS
   public static Connection getConnection(){   
    try{   // TRATAMENTO DE ERROS
        Class.forName(DRIVER);
   return DriverManager.getConnection(URL, USER, PASS);    
    } catch (ClassNotFoundException | SQLException ex){
        throw new RuntimeException("Erro Na Conexão Com o Banco De Dados" , ex);
       
   }    
}
   
   
// FECHAMENTO DA CONEXÃO COM O BANCO DE DADOS....   
public static void closeConnection (Connection connection, PreparedStatement statement){   
 try{
   if(connection != null){  
     connection.close();
   }  
   
   if(statement != null){
     statement.close();  
   }
     
   
 } catch (SQLException ex){   
     throw new RuntimeException("", ex);
    
    
 } 
    
       
 } 

public static void closeConnection (Connection connection, PreparedStatement statement, ResultSet resultSet){   
    try {
        if (resultSet != null) {
            resultSet.close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao fechar o ResultSet", ex);
    }

    try {
        if (statement != null) {
            statement.close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao fechar o PreparedStatement", ex);
    }

    try {
        if (connection != null) {
            connection.close();
        }
    } catch (SQLException ex) {
        throw new RuntimeException("Erro ao fechar a conexão", ex);
    }
 }

}
