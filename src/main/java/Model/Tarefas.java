package Model;

import java.util.Date;
import java.util.List;

public class Tarefas {

    public static void add(List<Tarefas> tarefa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
 // ATRIBUTOS   
  private int ID;
  private int IDPROJETO;
  private String NOME;   
  private String DESCRICAO;
  private boolean COMPLETED;
  private String NOTAS;
  private Date  PRAZO;
  private Date DATACRIACAO;       
  private Date DATAATUALIZACAO;        
         
  // MÉTODO CONSTRUTOR       

    public Tarefas(int ID, int IDPROEJTO, String NOME, String DESCRICAO, boolean COMPLETED, String NOTAS, Date PRAZO, Date DATACRIACAO, Date DATAATUALIZACAO) {
        this.ID = ID;
        this.IDPROJETO = IDPROEJTO;
        this.NOME = NOME;
        this.DESCRICAO = DESCRICAO;
        this.COMPLETED = COMPLETED;
        this.NOTAS = NOTAS;
        this.PRAZO = PRAZO;
        this.DATACRIACAO = DATACRIACAO;
        this.DATAATUALIZACAO = DATAATUALIZACAO;
    }
    
    public Tarefas(){
     this.DATACRIACAO = new Date();   
    }
  
  //MÉTODOS ACESSORES (GETTERS E SETTERS)

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPROJETO() {
        return IDPROJETO;
    }

    public void setIDPROJETO(int IDPROJETO) {
        this.IDPROJETO = IDPROJETO;
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

    public boolean COMPLETED() {
        return COMPLETED;
    }

    public void setCOMPLETED(boolean COMPLETED) {
        this.COMPLETED = COMPLETED;
    }

    public String getNOTAS() {
        return NOTAS;
    }

    public void setNOTAS(String NOTAS) {
        this.NOTAS = NOTAS;
    }

    public Date getPRAZO() {
     if(PRAZO != null){   
      return PRAZO;   
     }else{
       return new Date();
    }
  }
    
    public void setPRAZO(Date PRAZO) {
        this.PRAZO = PRAZO;
    }

    public Date getDATACRIACAO() {
        return DATACRIACAO;
    }

    public void setDATACRIACAO(Date DATACRIACAO) {
        this.DATACRIACAO = DATACRIACAO;
    }

    public Date getDATAATUALIZACAO() {
        
      if(DATAATUALIZACAO != null){  
        return DATAATUALIZACAO;
    }else{
          return new Date();
          
      }
    }   
    
    public void setDATAATUALIZACAO(Date DATAATUALIZACAO) {
        this.DATAATUALIZACAO = DATAATUALIZACAO;
    }
    
  // TOSTRING  

    @Override
    public String toString() {
        return "Tarefas{" + "ID=" + ID + ", IDPROEJTO=" + IDPROJETO + ", NOME=" + NOME + ", DESCRICAO=" + DESCRICAO + ", COMPLETED=" + COMPLETED + ", NOTAS =" + NOTAS + ", PRAZO=" + PRAZO + ", DATACRIACAO=" + DATACRIACAO + ", DATAATUALIZACAO=" + DATAATUALIZACAO + '}';
    }

    public boolean COMPLETED(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    }

 
    
  

  
         
         
         

