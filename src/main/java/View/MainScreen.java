/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Controller.ControladoresDaTarefa;
import static Controller.ControladoresDaTarefa.RemoveById;
import static Controller.ControladoresDaTarefa.getAll;
import Controller.ControladoresDoProjeto;
import static Controller.ControladoresDoProjeto.getAll;
import Model.Projetos;
import Model.Tarefas;
import Util.ButtomCollumCellRederer;
import Util.PrazoCollumCellRederer;
import Util.TaskTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


/**
 *
 * @author danie
 */
public class MainScreen extends javax.swing.JFrame {

    //Variáveis necessarias para implementar o carregamento do models Projetos.
    ControladoresDaTarefa controladoresDaTarefa;
    ControladoresDoProjeto controladoresDoProjeto;
    
    DefaultListModel ProjetosModels;
    TaskTableModel TarefasModels;
    
    public MainScreen() {
        initComponents();
       
        initDataController();
        initComponentsModel();
       
         
       
        decorateTableTask();  
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEmptyList = new javax.swing.JPanel();
        jLabelEmptyListIcon = new javax.swing.JLabel();
        jLabelEmptyListTitle = new javax.swing.JLabel();
        jLabelEmptyListSubTitle = new javax.swing.JLabel();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubTitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsAdd = new javax.swing.JLabel();
        jPanelProjectsList = new javax.swing.JPanel();
        jScrollPaneProjects = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksAdd = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPanelTasks = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();

        jPanelEmptyList.setBackground(java.awt.Color.white);
        jPanelEmptyList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelEmptyListIcon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelEmptyListIcon.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmptyListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListIcon.setText("Clique em \" + \" Para Adicionar Uma Tarefa.");

        jLabelEmptyListTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelEmptyListTitle.setForeground(new java.awt.Color(51, 0, 51));
        jLabelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListTitle.setText("Não há Nenhuma Tarefa por aqui : (");

        jLabelEmptyListSubTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmptyListSubTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        javax.swing.GroupLayout jPanelEmptyListLayout = new javax.swing.GroupLayout(jPanelEmptyList);
        jPanelEmptyList.setLayout(jPanelEmptyListLayout);
        jPanelEmptyListLayout.setHorizontalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                .addGroup(jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelEmptyListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelEmptyListLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyListLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelEmptyListSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelEmptyListLayout.setVerticalGroup(
            jPanelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEmptyListLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabelEmptyListSubTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelEmptyListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEmptyListIcon)
                .addGap(121, 121, 121))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 920));

        jPanelToolBar.setBackground(new java.awt.Color(0, 204, 102));
        jPanelToolBar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N
        jLabelToolBarTitle.setText("Meu App");

        jLabelToolBarSubTitle.setBackground(new java.awt.Color(255, 255, 255));
        jLabelToolBarSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelToolBarSubTitle.setForeground(new java.awt.Color(255, 255, 255));
        jLabelToolBarSubTitle.setText("Anote tudo, Não Esqueça Nada!");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelToolBarLayout.createSequentialGroup()
                        .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addComponent(jLabelToolBarSubTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelToolBarTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jLabelToolBarSubTitle)
                .addGap(34, 34, 34))
        );

        jPanelProjects.setBackground(java.awt.Color.white);
        jPanelProjects.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(51, 0, 51));
        jLabelProjectsTitle.setText("Projetos");

        jLabelProjectsAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectsAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectsAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelProjectsAdd)
                .addGap(23, 23, 23))
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectsTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelProjectsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelProjectsAdd)))
                .addContainerGap())
        );

        jPanelProjectsList.setBackground(java.awt.Color.white);
        jPanelProjectsList.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jListProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListProjects.setFixedCellHeight(50);
        jListProjects.setSelectionBackground(new java.awt.Color(0, 204, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPaneProjects.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectsListLayout = new javax.swing.GroupLayout(jPanelProjectsList);
        jPanelProjectsList.setLayout(jPanelProjectsListLayout);
        jPanelProjectsListLayout.setHorizontalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects)
                .addContainerGap())
        );
        jPanelProjectsListLayout.setVerticalGroup(
            jPanelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneProjects)
                .addContainerGap())
        );

        jPanelTasks.setBackground(java.awt.Color.white);
        jPanelTasks.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(51, 0, 51));
        jLabelTasksTitle.setText("Tarefas");

        jLabelTasksAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTasksAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTasksAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addGap(213, 213, 213)
                .addComponent(jLabelTasksAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTasksTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelTasksAdd))
                .addContainerGap())
        );

        jPanel5.setBackground(java.awt.Color.white);
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableTasks.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Prazo", "Tarefa Concluída"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableTasks.setGridColor(new java.awt.Color(255, 255, 255));
        jTableTasks.setRowHeight(50);
        jTableTasks.setSelectionBackground(new java.awt.Color(153, 255, 153));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.setShowVerticalLines(false);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPanelTasks.setViewportView(jTableTasks);

        jPanel5.add(jScrollPanelTasks, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
 
    
    private void jLabelProjectsAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsAddMouseClicked
        // TODO add your handling code here:
    
    // EVENTO DE ADICIONAR PROJETOS....    
    ProjectsDialogScreen projectsDialogScreen = new ProjectsDialogScreen(this,rootPaneCheckingEnabled);
    projectsDialogScreen.setVisible(true);    
    
    // AQUI ESTAMOS ADICIONANDO UM OUVINTE PARA QUANDO ACONTECER UM EVENTO DE 
    //FECHAMENTO DE JANELA, CARREGUE OS PROJETOS.
    
    // OU SEJA, QUANDO ESSA JANELA FOR FECHADA 
    projectsDialogScreen.addWindowListener(new WindowAdapter(){
        
     // EU IREI ATUALIZAR A MINHA LISTA DE PROJETOS.   
      public void windowClosed(WindowEvent e){   
      loadProjects();
        
      }
      
      });
      
    
    }//GEN-LAST:event_jLabelProjectsAddMouseClicked

    private void jLabelTasksAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksAddMouseClicked
        // TODO add your handling code here:
   // Aqui criamos aquela nova aba ao clicar no Add.     
   TasksDialogScreen tasksDialogScreen = new TasksDialogScreen(this, rootPaneCheckingEnabled);     
   //tasksDialogScreen.setProjetos(null);
   int projectIndex = jListProjects.getSelectedIndex();
   Projetos projetos = (Projetos)ProjetosModels.get(projectIndex);
   tasksDialogScreen.setProjetos(projetos);
   
   // aqui deixamos a nova aba visivel..
   tasksDialogScreen.setVisible(true);
   
   tasksDialogScreen.addWindowListener(new WindowAdapter(){
    public void windowClosed(WindowEvent e){    
     int projectIndex = jListProjects.getSelectedIndex();
      Projetos projetos = (Projetos)ProjetosModels.get(projectIndex);
       
       
    }   
       
       
    });
        
    }//GEN-LAST:event_jLabelTasksAddMouseClicked

    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTasksMouseClicked
    
       int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
       int columIndex = jTableTasks.columnAtPoint(evt.getPoint());
       Tarefas tarefas = TarefasModels.getTarefas().get(rowIndex); 
      switch(columIndex){
          case 3: 
            ControladoresDaTarefa.update(tarefas);
             break;
             
          case 4:   
                       
    String novoNome = JOptionPane.showInputDialog(rootPane, "Digite o novo nome da tarefa:");
    String novaDescricao = JOptionPane.showInputDialog(rootPane, "Digite a nova descrição da tarefa:");
 
    
    
    if (novoNome != null && novaDescricao != null) {
          tarefas.setNOME(novoNome);
          tarefas.setDESCRICAO(novaDescricao);  
         controladoresDaTarefa.update(tarefas);
    }       
              break;


          case 5:
              controladoresDaTarefa.RemoveById(tarefas.getID());
              TarefasModels.getTarefas().remove(tarefas);
              
              
              int projectIndex = jListProjects.getSelectedIndex();
              Projetos projetos = (Projetos)ProjetosModels.get(projectIndex);
              loadTarefas(projetos.getID());
              
              break;
    
          
          
      }
        
    }//GEN-LAST:event_jTableTasksMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        
        int projectIndex = jListProjects.getSelectedIndex();
        System.out.println("Clicando no indice: " + projectIndex);
       System.out.println("ProjetosModels size: " + ProjetosModels.size());
      if(projectIndex >= 0 && projectIndex < ProjetosModels.size()){  
        
       Projetos projetos = (Projetos) ProjetosModels.get(projectIndex);
       loadTarefas(projetos.getID());
      }else{  
       System.err.println("Indice de projeto invalido" + projectIndex);
      }
        
        
    }//GEN-LAST:event_jListProjectsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java Swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelEmptyListIcon;
    private javax.swing.JLabel jLabelEmptyListSubTitle;
    private javax.swing.JLabel jLabelEmptyListTitle;
    private javax.swing.JLabel jLabelProjectsAdd;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksAdd;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarSubTitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelEmptyList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelProjectsList;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPaneProjects;
    private javax.swing.JScrollPane jScrollPanelTasks;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

    
 // customizando o header da table de tarefas   
 public void decorateTableTask(){   
     
  jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
   jTableTasks.getTableHeader().setOpaque(false);
  jTableTasks.getTableHeader().setBackground(new Color(0,204,102));
  jTableTasks.getTableHeader().setForeground(new Color (255,255,255));
     
  //Criando um sorter automático para as colunas da table
  jTableTasks.setAutoCreateRowSorter(true);   
     
 //setando os renderizadores para nossa interface diretamente da classe pai 
 jTableTasks.getColumnModel().getColumn(2)
  .setCellRenderer(new PrazoCollumCellRederer());
 
 // botão excluir
  jTableTasks.getColumnModel().getColumn(4)
          .setCellRenderer(new ButtomCollumCellRederer("edit"));
          
 // botão deletar 
 jTableTasks.getColumnModel().getColumn(5)
         .setCellRenderer(new ButtomCollumCellRederer("delete"));
  
 }


public void initDataController(){
    
 // Método necessario que faz parte da implementacao da lista de projetos no grade   
 // obs : esse método será puxado dentro do init components..
ControladoresDoProjeto controladoresDoProjeto = new ControladoresDoProjeto();    
ControladoresDaTarefa controladoresDaTarefa = new ControladoresDaTarefa();        

}

  private void centralizeMainScreen() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

  }

public void initComponentsModel(){   

ProjetosModels = new DefaultListModel();    
loadProjects();
    
TarefasModels = new TaskTableModel();
jTableTasks.setModel(TarefasModels);
loadTarefas(5);

if (!ProjetosModels.isEmpty()) {
 jListProjects.setSelectedIndex(0);
  int projectIndex = jListProjects.getSelectedIndex();
  Projetos projetos = (Projetos) ProjetosModels.get(projectIndex);
  loadTarefas(projetos.getID());
    
    
    
}


}

public void loadTarefas(int IDPROJETO) {
    List<Tarefas> tarefas = ControladoresDaTarefa.getAll(IDPROJETO);
    System.out.println("Tarefas para o projeto " + IDPROJETO + ": " + tarefas.size());

    // Verifique se o projeto tem tarefas
    if (!tarefas.isEmpty()) {
        TarefasModels.setTarefas(tarefas);
        showJTableTasks(true);
    } else {
        System.out.println("Projeto " + IDPROJETO + " não tem tarefas.");
        // Se não houver tarefas, limpe a tabela de tarefas e oculte-a
        TarefasModels.setTarefas(new ArrayList<>());
        showJTableTasks(false);
    }
}

public void loadProjects(){
  
List<Projetos> projetos = ControladoresDoProjeto.getAll();    

ProjetosModels.clear();    


for (int i = 0; i <projetos.size(); i++){
   Projetos projeto = projetos.get(i);
   ProjetosModels.addElement(projeto);
    
 }

jListProjects.setModel(ProjetosModels);
      
}




private void showJTableTasks(boolean hasTarefas){
// Método para amostrar as tarefas conforme o clique.    
    
    
  if(hasTarefas){  
   if(jPanelEmptyList.isVisible()){   
      jPanelEmptyList.setVisible(false);
      jPanel5.remove(jScrollPanelTasks);
   }
   
   jPanel5.add(jScrollPanelTasks);
   jScrollPanelTasks.setVisible(true);
   jScrollPanelTasks.setSize(jPanel5.getWidth(), jPanel5.getHeight());
  }else{
      if(jScrollPanelTasks.isVisible()){
      jScrollPanelTasks.setVisible(false);
      jPanel5.remove(jScrollPanelTasks);
       
  }
   jPanel5.add(jPanelEmptyList);   
   jPanelEmptyList.setVisible(true);
   jPanelEmptyList.setSize(jPanel5.getWidth(), jPanel5.getHeight());
          
      
  }
  
  
    
 }  
}


    
    
  
    
