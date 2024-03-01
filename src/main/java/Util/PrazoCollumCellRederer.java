
package Util;


//Essa é a classe que tem um renderizador padrão de células de um jTable.
import Model.Tarefas;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class PrazoCollumCellRederer extends DefaultTableCellRenderer {
  
 /* esse método faz o seguinte, ele pega as células de um cellRenderer já existe   
    nte e edita uma label em nosso grade, no caso aqui vai ser a do prazo, além
    de centralizarmos  a label dele  vamos setar uma cor caso esteja fora do pra
    zo ou dentro do prazo 
    
    esse comando SUPER. ele chama um componente da classe pai.
    
    GREEN = DENTRO DO PRAZO
    RED = FORA DO PRAZO
    
    traduzindo o if(tarefas.getPRAZO().after(new date()))
    
    - ele faz uma verificação se o prazo está depois do dia atual, se estiver
    vai ser verde se não estiver vai ser vermelho.
    
 */
 @Override   
  public Component getTableCellRendererComponent(JTable table, Object value,  
      boolean isSelected, boolean hasFocus, int row , int col){    
      
      JLabel label;
      
      label = (JLabel) super.getTableCellRendererComponent(table, value,
       isSelected, hasFocus, row, col);
          
          
       label.setHorizontalAlignment(CENTER);
     
      TaskTableModel TarefasModels = (TaskTableModel) table.getModel();
      Tarefas tarefas = TarefasModels.getTarefas().get(row);
      
      if(tarefas.getPRAZO().after(new Date())){
       label.setBackground(Color.GREEN); 
      }else{
       label.setBackground(Color.RED);        
       }
      
      
      
      
      
      
      return label;
    
    
  }  
    
}
