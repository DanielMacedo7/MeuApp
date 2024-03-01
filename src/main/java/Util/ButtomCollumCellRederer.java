package Util;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ButtomCollumCellRederer extends DefaultTableCellRenderer {
    
 private String ButtonType;   
 
// construtor 
 public ButtomCollumCellRederer(String ButtonType){
 this.ButtonType = ButtonType;    
 
 }
 
 // agora vamos criar os métodos getters e setters desse botão
 
 public String getButtonType(){
  return ButtonType;   
 }
    
 public void setButtonType(String ButtonType){   
  this.ButtonType = ButtonType;   
     
 }

 // esse método é só muda a ação que ele vai exercer dentro da nossa jTable
 // porém a forma de implementar é quase igual a anterior de validar o prazo
 // com green (dentro) red (fora);
 @Override
  public Component getTableCellRendererComponent(JTable table, Object value,  
      boolean isSelected, boolean hasFocus, int row , int col){    
      
      JLabel label;
      label = (JLabel) super.getTableCellRendererComponent(table, value,
       isSelected, hasFocus, row, col);
          
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setIcon(new javax.swing.ImageIcon(getClass()
     .getResource("/" + ButtonType + ".png")));
      
 
 return label;
    
 }
}