
package Util;

import Model.Tarefas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author danie
 */
public class TaskTableModel extends AbstractTableModel{

 //Aqui criamos um vetor de Strings Representando todas as colunas que estão no meu table.
    
  String[] Columns  = {"Nome", "Descrição", "Prazo", "Tarefa Concluída", "Editar", "Excluir"};
  
 //Aqui puxamos um arrayList para trabalhar com a nossa lista.
  List<Tarefas> tarefas = new ArrayList();  
  
  // ESSES DOIS SÃOS OS ATRIBUTOS PRINCIPAIS..  
  
  
 
    @Override
   //Esse método vai me dizer quantas tarefas eu já tenho.
    public int getRowCount() {
        
    //vai retornar a quantidade de linhas.    
    return tarefas.size();    
    }

 //Esse método vai me dizer quantas colunas eu tenho.   
    @Override
    public int getColumnCount() {
        
    //vai retornar a quantidade de columns.
       return Columns.length;
    }
    
 //Override serve para substituir um método da classe pai ou da interface.
 @Override   
 public String getColumnName(int columnIndex){
    return Columns [columnIndex];  
 }
 
 //MÉTODO PARA DIZER SE A COLUNA 3 VAI SER EDITAVEL OU NÃO.
 public boolean isCellEditable(int rowIndex, int columnIndex){
   return columnIndex == 3;  
 }
    
 //Override serve para substituir um método da classe pai ou da interface.
 @Override 
 
 //MÉTODO PARA CRIAR UMA CAIXA DE CHECK NA COLUNA DA TAREFA CONCLUÍDA.
 public Class<?> getColumnClass(int columnIndex){
  if(tarefas.isEmpty()){   
    return Object.class;  
  }
  
  //ESSE COMANDO RETORNA A CLASSE DO DADO REFERE A LINHA E COLUNA DA TABELA.
  return this.getValueAt(0, columnIndex).getClass();
  }
 

    
//Esse método vai me dizer qual é o valor em determinada linha e coluna.    
//Quando esse método for chamado ele vai receber como paramêtro qual linha e qual coluna eu quero uma informação.         
 
 
//Override serve para substituir um método da classe pai ou da interface. 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
//isso aqui é como se fosse um vetor só que melhorado        
    switch(columnIndex){    
              
//Aqui eu tenho que retornar a coluna com base na linha da tarefa.        
        case 0:
           return tarefas.get(rowIndex).getNOME(); 
        case 1: 
            return tarefas.get(rowIndex).getDESCRICAO();
        case 2:    
            // formatando a data para aparecer no padrão BRASILEIRO.
            SimpleDateFormat DateFormat = new SimpleDateFormat("   dd/MM/yyyy ");
             return DateFormat.format(tarefas.get(rowIndex).getPRAZO());
        case 3:    
             return tarefas.get(rowIndex).COMPLETED();
        case 4:    
            return "";
        case 5:    
            return "";
         
        default:     
            return "Dados nao encontrados";
     }
    }

// ESSES MÉTODOS ABAIXOS SÃO NECESSARIOS PARA SETAR PRO MODELS DA TAREFA    
// SEM ELES NOSSO GRADE NÃO SERIA CARREGADO.S    
    
    
//MÉTODO PARA MARCAR SE A CHECK DA TAREFA VAI SER TRUE OR FALSE.    
  @Override  
  public void setValueAt(Object aValue, int rowIndex, int columnIndex){
   tarefas.get(rowIndex).setCOMPLETED((boolean) aValue);
  }
  
    public String[] getColumns() {
        return Columns;
    }

    public List<Tarefas> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefas> tarefas) {
        this.tarefas = tarefas;
    }
    
    
    
}