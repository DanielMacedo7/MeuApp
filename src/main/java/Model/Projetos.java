package Model;


import java.util.Date;
import java.util.List;

public class Projetos {

 
   public static void add(List<Projetos> projeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
          
 //ATRIBUTOS    
 private int ID;   
 private String NOME;   
 private String DESCRICAO;
 private Date DATADECRIACAO;
 private Date DATADEATUALIZACAO;       

    // MÉTODO CONSTRUTOR
   public Projetos(int ID, String Nome, String Descricao, Date DataCriacao, Date DataAtualizacao) {
        this.ID = ID;
        this.NOME = Nome;
        this.DESCRICAO = Descricao;
        this.DATADECRIACAO = DataCriacao;
        this.DATADEATUALIZACAO = DataAtualizacao;
    }

    
    public Projetos(){
     this.DATADECRIACAO = new Date();   
    }
   
    
   
    // MÉTODOS ACESSORES ( GETTERS E SETTER)

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public Date getDATADECRIACAO() {
        return DATADECRIACAO;
    }

    public void setDATADECRIACAO(Date DATADECRIACAO) {
        this.DATADECRIACAO = DATADECRIACAO;
    }

    public Date getDATADEATUALIZACAO() {
        if (DATADEATUALIZACAO != null) {
           return DATADEATUALIZACAO;
            } else {
        
        return new Date();
     }
    }
    public void setDATADEATUALIZACAO(Date DATADEATUALIZACAO) {
        this.DATADEATUALIZACAO = DATADEATUALIZACAO;
    }

    @Override
    public String toString() {
        return this.NOME;
    }
    
    
    
}
