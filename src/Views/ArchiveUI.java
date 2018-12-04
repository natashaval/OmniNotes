/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Note;
import Controllers.NoteController;
import java.util.Iterator;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import Controllers.NoteEditor;

/**
 *
 * @author Hwie
 */
public class ArchiveUI extends javax.swing.JFrame {

    /**
     * Creates new form ArchieveUI
     */
    public ArchiveUI() {
        initComponents();
        //        hide table columns other than title
        TableColumnModel tcm = archiveNotesTable.getColumnModel();
        tcm.removeColumn( tcm.getColumn(0) ); //hide id column
        tcm.removeColumn( tcm.getColumn(1) ); //hide content column
        tcm.removeColumn( tcm.getColumn(1) ); //hide is_active column
        tcm.removeColumn( tcm.getColumn(1) ); //hide tag column
        tcm.removeColumn( tcm.getColumn(1) ); //hide location column
        this.getNotes();
    }
    
    public void getNotes(){
        NoteController nc = new NoteController();        
        LinkedList<Note> myNotes = new LinkedList<Note>();
        myNotes = nc.getArchive();        

        Iterator<Note> itr=myNotes.iterator();  
        if (myNotes.size() > 0)  {            
            ((DefaultTableModel)archiveNotesTable.getModel()).setRowCount(0);    //clear table

            DefaultTableModel model = (DefaultTableModel) archiveNotesTable.getModel();
            //add data to notes table
            while(itr.hasNext()) {                        
                Note current = itr.next();
                int id = current.getNoteId();
                String title = current.getTitle();
                String content = current.getContent();
                int isArchive = current.getIsArchived();
                String tag = current.getTag();
                String location = current.getLocation();
                
                if (tag == null) {
                    tag = "None";
                }
                
                if (location == null) {
                    location = "None";
                }
                
                Object[] row = { id, title, content, isArchive, tag, location };
                model.addRow(row);
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Archieve = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        archiveNotesTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Archieve.setText("Archive");
        Archieve.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        archiveNotesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Title", "content", "is_archive", "tag", "location"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        archiveNotesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archiveNotesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(archiveNotesTable);

        jMenu1.setText("File");

        jMenuItem1.setText("Main Menu");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Archieve, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(Archieve, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        NoteController nc = new NoteController();
        nc.openMainMenu();
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
     
    }//GEN-LAST:event_jMenuItem1MouseClicked

//    get note details on click
    private void archiveNotesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archiveNotesTableMouseClicked
        try{
            int noteId = Integer.parseInt(archiveNotesTable.getModel().getValueAt(archiveNotesTable.getSelectedRow(), 0).toString());
            String title = archiveNotesTable.getModel().getValueAt(archiveNotesTable.getSelectedRow(), 1).toString();        
            String content = archiveNotesTable.getModel().getValueAt(archiveNotesTable.getSelectedRow(), 2).toString();
            String tag = archiveNotesTable.getModel().getValueAt(archiveNotesTable.getSelectedRow(), 4).toString();
            String location = archiveNotesTable.getModel().getValueAt(archiveNotesTable.getSelectedRow(), 5).toString();

            
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setNoteId(noteId);
            note.setIsArchived(1);
            note.setIsDeleted(0);
            note.setIsArchived(1);
            note.setTag(tag);
            note.setLocation(location);
            
            
            NoteEditor ne = new NoteEditor();
            ne.openNoteEditorUI(note, "update");
            
        }catch(Exception e){
            System.out.println(e);   
            return;
        }        
        this.dispose();
    }//GEN-LAST:event_archiveNotesTableMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArchiveUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArchiveUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Archieve;
    private javax.swing.JTable archiveNotesTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}