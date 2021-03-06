package Views;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.ResultSet;
import java.util.ArrayList;
import Models.Note;
import Controllers.NoteController;
import Controllers.NoteEditor;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import Controllers.CategoryController;
import Models.Attachment;
import Models.Category;
import Models.Reminder;
import java.awt.Dimension;
import java.sql.SQLException;
/**
 *
 * @author Natasha
 */
public class MainMenuUI extends javax.swing.JFrame {
    
    private NoteController nc = null;
    
    /**
     * Creates new form MainMenuUI
     */
    public MainMenuUI() {
        initComponents();
//        this.getNotes();
        this.getCategories();        
        this.setAlwaysOnTop(true);
        this.nc = new NoteController();
        
        JComboBox comboBox = this.sortMenu;
        comboBox.addItem(new MyComboItem(1, "Ascending: name"));
        comboBox.addItem(new MyComboItem(2, "Descending: name"));
        comboBox.addItem(new MyComboItem(3, "Newest: created"));
        comboBox.addItem(new MyComboItem(4, "Oldest: created"));
        
//        hide table columns other than title
        TableColumnModel tcm = myNotesTable.getColumnModel();
        tcm.removeColumn( tcm.getColumn(0) ); //hide id column
        tcm.removeColumn( tcm.getColumn(1) ); //hide content column
        tcm.removeColumn( tcm.getColumn(1) ); //hide is_active column
        tcm.removeColumn( tcm.getColumn(1) ); //hide tag column
        tcm.removeColumn( tcm.getColumn(1) ); //hide location column
        tcm.removeColumn( tcm.getColumn(1) ); //hide cat_id column
        tcm.removeColumn( tcm.getColumn(1) ); //hide file path column
        tcm.removeColumn( tcm.getColumn(1) ); //hide file type column
        tcm.removeColumn( tcm.getColumn(1) ); //hide reminder column
        tcm.removeColumn( tcm.getColumn(1) ); //hide reminder_repeat column
        this.getNotes();
        this.toFront();

    }
    
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myNotesTable = new javax.swing.JTable();
        sortMenu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchBar = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        archiveMenu = new javax.swing.JMenuItem();
        trashMenu = new javax.swing.JMenuItem();

        jFormattedTextField6.setText("activeNote5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Omni Notes - Main Menu");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(100, 100));
        setState(1);

        jButton1.setText("Add Note");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        myNotesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Title", "content", "is_archive", "tag", "location", "category_id", "file_path", "file_type", "reminder", "repeat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        myNotesTable.setGridColor(new java.awt.Color(204, 204, 204));
        myNotesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myNotesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(myNotesTable);

        sortMenu.setToolTipText("Sort notes");
        sortMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                sortMenuItemStateChanged(evt);
            }
        });
        sortMenu.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                sortMenuPropertyChange(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        categoryTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        categoryTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                categoryTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(categoryTree);

        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(searchBar);

        jMenu1.setText("Menu");

        archiveMenu.setText("Archive");
        archiveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archiveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(archiveMenu);

        trashMenu.setText("Trash");
        trashMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trashMenuActionPerformed(evt);
            }
        });
        jMenu1.add(trashMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sortMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(sortMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NoteEditor ne = new NoteEditor(this);
        this.dispose();
        ne.openNoteEditorUI("create");
    }//GEN-LAST:event_jButton1ActionPerformed

        //on click active notes
    private void myNotesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myNotesTableMouseClicked
        try{
            int noteId = Integer.parseInt(myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 0).toString());
            String title = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 1).toString();        
            String content = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 2).toString();            
            String tag = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 4).toString();
            String location = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 5).toString();
            String categoryId = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 6).toString();
            String filePath = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 7).toString();
            String fileType = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 8).toString();
            String reminder = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 9).toString();
            String repeat = myNotesTable.getModel().getValueAt(myNotesTable.getSelectedRow(), 10).toString();
                
            Note note = new Note();
            note.setTitle(title);
            note.setContent(content);
            note.setNoteId(noteId);
            note.setIsDeleted(0);
            note.setTag(tag);
            note.setLocation(location);
            note.setCategoryId(categoryId);
            note.setAttachment(new Attachment(filePath, filePath, fileType));
            note.setReminder(new Reminder(reminder, repeat));
            
            System.out.println("title " + title + " content " + content + " tag " + tag + " location " + location + " catid " + categoryId + " filepath " + filePath + " filetype " + fileType);
            
            NoteEditor ne = new NoteEditor();
            ne.openNoteEditorUI(note, "update");
            
        }catch(NumberFormatException e){
            System.out.println("caught " + e.getMessage());
            System.out.println(e.getMessage());   
            System.out.println(e.getCause());
//            return;
        }        
        this.dispose();
    }//GEN-LAST:event_myNotesTableMouseClicked

    private void archiveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archiveMenuActionPerformed
        nc.openArchiveUI();           
        this.dispose();

    }//GEN-LAST:event_archiveMenuActionPerformed

    private void trashMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trashMenuActionPerformed
        nc.openTrashUI();
        this.dispose();
    }//GEN-LAST:event_trashMenuActionPerformed

    private void sortMenuPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_sortMenuPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_sortMenuPropertyChange

     private void getNotes() {
        LinkedList<Note> myNotes = null;
        
                        
        try {
            myNotes = nc.sortNotes(1);
            if (myNotes.size() > 0)  {            
            ((DefaultTableModel)myNotesTable.getModel()).setRowCount(0);    //clear table

            TableColumnModel tcm = myNotesTable.getColumnModel();

            DefaultTableModel model = (DefaultTableModel) myNotesTable.getModel();
            Iterator<Note> itr = myNotes.iterator();

            //add data to notes table
            while(itr.hasNext()) {                        
                Note current = itr.next();
                int id = current.getNoteId();
                String title = current.getTitle();
                String content = current.getContent();
                int isArchive = current.getIsArchived();
                String tag = current.getTag();
                String location = current.getLocation();
                String categoryId = current.getCategoryId();
                String filePath = current.getAttachment().getLocation();
                String fileType = current.getAttachment().getFileType();
                String reminder = current.getReminder().getReminderDate();                                
                String repeat = current.getReminder().getRepeat();
                
                if (categoryId == null) {
                    System.out.println("cat is null he");
                    categoryId = "None";
                }
                
                if (tag == null || "".equals(tag)) {
                    tag = "None";
                }
                
                if (location == null || "".equals(location)) {
                    location = "None";
                }
                
                if (fileType == null || "".equals(fileType)) {
                    fileType = "None";
                    filePath = "None";
                }
                
                if (reminder == null || "".equals(reminder)) {
                    reminder = "None";
                }
                
                Object[] row = { id, title, content, isArchive, tag, location, categoryId, filePath, fileType, reminder, repeat };
                model.addRow(row);
            }
            
        } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    private void sortMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sortMenuItemStateChanged
      
        LinkedList<Note> myNotes = null;
        MyComboItem item;
        
        item = (MyComboItem)evt.getItem();
                        
        try {
            System.out.println(item.getId());
            myNotes = nc.sortNotes(item.getId());
            if (myNotes.size() > 0)  {            
            ((DefaultTableModel)myNotesTable.getModel()).setRowCount(0);    //clear table

            TableColumnModel tcm = myNotesTable.getColumnModel();

            DefaultTableModel model = (DefaultTableModel) myNotesTable.getModel();
            Iterator<Note> itr = myNotes.iterator();

            //add data to notes table
            while(itr.hasNext()) {                        
                Note current = itr.next();
                int id = current.getNoteId();
                String title = current.getTitle();
                String content = current.getContent();
                int isArchive = current.getIsArchived();
                String tag = current.getTag();
                String location = current.getLocation();
                String categoryId = current.getCategoryId();
                String filePath = current.getAttachment().getLocation();
                String fileType = current.getAttachment().getFileType();
                String reminder = current.getReminder().getReminderDate();                                
                String repeat = current.getReminder().getRepeat();
                
                if (categoryId == null) {
                    System.out.println("cat is null he");
                    categoryId = "None";
                }
                
                if (tag == null || "".equals(tag)) {
                    tag = "None";
                }
                
                if (location == null || "".equals(location)) {
                    location = "None";
                }
                
                if (fileType == null || "".equals(fileType)) {
                    fileType = "None";
                    filePath = "None";
                }
                
                if (reminder == null || "".equals(reminder)) {
                    reminder = "None";
                }
                
                Object[] row = { id, title, content, isArchive, tag, location, categoryId, filePath, fileType, reminder, repeat };
                model.addRow(row);
            }
            
        } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_sortMenuItemStateChanged

    private void categoryTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_categoryTreeValueChanged
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) categoryTree.getLastSelectedPathComponent();
        Category c = (Category) node.getUserObject();
        int catId = c.getCategoryId();
                       
        LinkedList<Note> myNotes = new LinkedList();
        
        try {
            myNotes = nc.getNotesFromCategory(catId);
            
            ((DefaultTableModel)myNotesTable.getModel()).setRowCount(0);    //clear table

            
            System.out.println(myNotes.size());
            
             if (myNotes.size() > 0)  {            

                TableColumnModel tcm = myNotesTable.getColumnModel();

                DefaultTableModel model = (DefaultTableModel) myNotesTable.getModel();
                Iterator<Note> itr = myNotes.iterator();

                //add data to notes table
                while(itr.hasNext()){                        
                    Note current = itr.next();
                    int id = current.getNoteId();
                    String title = current.getTitle();
                    String content = current.getContent();
                    int isArchive = current.getIsArchived();
                    String tag = current.getTag();
                    String location = current.getLocation();
                    String categoryId = current.getCategoryId();
                    String filePath = current.getAttachment().getLocation();
                    String fileType = current.getAttachment().getFileType();
                    String reminder = current.getReminder().getReminderDate();                                
                    String repeat = current.getReminder().getRepeat();
                
                    System.out.println("content " + content);
                    
                    if (categoryId == null) {
                        System.out.println("cat is null he");
                        categoryId = "None";
                    }

                    if (tag == null || "".equals(tag)) {
                        tag = "None";
                    }

                    if (location == null || "".equals(location)) {
                        location = "None";
                    }
                    
                    if (fileType == null || "".equals(fileType)) {
                        fileType = "None";
                        filePath = "None";
                    }
                    
                    if (reminder == null || "".equals(reminder)) {
                            reminder = "None";
                    }

                    Object[] row = { id, title, content, isArchive, tag, location, categoryId, filePath, fileType, reminder, repeat };
                    model.addRow(row);
                }
            
            } 
            
        } catch (Exception ex) {
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_categoryTreeValueChanged

    private void searchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyReleased
        String noteKeyword = this.searchBar.getText();
        LinkedList<Note> myNotes = new LinkedList();
        
        
         try {
            myNotes = nc.searchNotes(noteKeyword);
            
            ((DefaultTableModel)myNotesTable.getModel()).setRowCount(0);    //clear table

            
            System.out.println(myNotes.size());
            
             if (myNotes.size() > 0)  {            

                TableColumnModel tcm = myNotesTable.getColumnModel();

                DefaultTableModel model = (DefaultTableModel) myNotesTable.getModel();
                Iterator<Note> itr = myNotes.iterator();

                //add data to notes table
                while(itr.hasNext()){                        
                    Note current = itr.next();
                    int id = current.getNoteId();
                    String title = current.getTitle();
                    String content = current.getContent();
                    int isArchive = current.getIsArchived();
                    String tag = current.getTag();
                    String location = current.getLocation();
                    String categoryId = current.getCategoryId();
                    String filePath = current.getAttachment().getLocation();
                    String fileType = current.getAttachment().getFileType();
                    String reminder = current.getReminder().getReminderDate();                                
                    String repeat = current.getReminder().getRepeat();
                
                    System.out.println("content " + content);
                    
                    if (categoryId == null) {
                        System.out.println("cat is null he");
                        categoryId = "None";
                    }

                    if (tag == null || "".equals(tag)) {
                        tag = "None";
                    }

                    if (location == null || "".equals(location)) {
                        location = "None";
                    }
                    
                    if (fileType == null || "".equals(fileType)) {
                        fileType = "None";
                        filePath = "None";
                    }
                    
                    if (reminder == null || "".equals(reminder)) {
                            reminder = "None";
                    }

                    Object[] row = { id, title, content, isArchive, tag, location, categoryId, filePath, fileType, reminder, repeat };
                    model.addRow(row);
                }
            
            } 
            
        } catch (Exception ex) {
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_searchBarKeyReleased
    

    public void getCategories() {
        CategoryController cc = new CategoryController();
        LinkedList<Category> cats = new LinkedList();
        
        try {
            cats = cc.getCategories();
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Iterator<Category> itr = cats.iterator();
        
        DefaultMutableTreeNode categoryRoot = new DefaultMutableTreeNode("Categories");
        
        while (itr.hasNext()) {
            Category c = itr.next();
            categoryRoot.add(new DefaultMutableTreeNode(c));

        }
                
        DefaultTreeModel dtm = new DefaultTreeModel(categoryRoot);
        this.categoryTree.setModel(dtm);                   
    
    }
 
    
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
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuUI().setVisible(true);                
            }
        });
    }
    
    class MyComboItem {
        private Integer id;
        private String name;
        
        MyComboItem(Integer id, String name){
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
           return name;
        }
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem archiveMenu;
    private javax.swing.JTree categoryTree;
    private javax.swing.JButton jButton1;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable myNotesTable;
    private javax.swing.JTextPane searchBar;
    private javax.swing.JComboBox<String> sortMenu;
    private javax.swing.JMenuItem trashMenu;
    // End of variables declaration//GEN-END:variables

}
                
