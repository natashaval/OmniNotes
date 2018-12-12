/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import Controllers.CategoryController;
import Models.Category;

/**
 *
 * @author Hwie
 */
public class CategoryUI extends javax.swing.JFrame {
    
    
    private CategoryController cc = null;
    private JComboBox comboBox;
    private int noteId = -1;
    private int catId = -1;
    /**
     * Creates new form CategoryUI
     */
    public CategoryUI() {
        initComponents();        
        this.cc = new CategoryController();
        comboBox = new JComboBox();        
        comboBox = this.catSelect;
        this.getCategories();
        
        
    }

    public CategoryUI(int noteId, CategoryController cc) {
        initComponents();        
        this.cc = new CategoryController();
        comboBox = new JComboBox();        
        comboBox = this.catSelect;
        this.noteId = noteId;
        this.getCategories();
        
        this.cc = cc;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoryLabel = new javax.swing.JLabel();
        catColor = new javax.swing.JColorChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryInput = new javax.swing.JTextPane();
        addCatBtn = new javax.swing.JButton();
        catSelect = new javax.swing.JComboBox<>();
        saveBtn = new javax.swing.JButton();
        uncategorizeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Omni Notes - Category");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        categoryLabel.setText("Category");
        categoryLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N

        catColor.setName(""); // NOI18N

        categoryInput.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(categoryInput);

        addCatBtn.setText("Add Category");
        addCatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCatBtnActionPerformed(evt);
            }
        });

        catSelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                catSelectItemStateChanged(evt);
            }
        });
        catSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                catSelectMouseClicked(evt);
            }
        });
        catSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catSelectActionPerformed(evt);
            }
        });

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        uncategorizeBtn.setText("Uncategorize");
        uncategorizeBtn.setBackground(new java.awt.Color(255, 0, 51));
        uncategorizeBtn.setForeground(new java.awt.Color(255, 255, 255));
        uncategorizeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uncategorizeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(categoryLabel)
                    .addComponent(catColor, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(catSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(uncategorizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(categoryLabel)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addCatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(catColor, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(catSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(uncategorizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // add new category
    private void addCatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCatBtnActionPerformed
        Color color = this.catColor.getColor();
        Category cat = new Category(this.categoryInput.getText(), color.getRed(), color.getGreen(), color.getBlue());
        
        try {
            cc.addCategory(cat);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getCategories();
            
    }//GEN-LAST:event_addCatBtnActionPerformed

    private void catSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catSelectActionPerformed
        
    }//GEN-LAST:event_catSelectActionPerformed

    private void catSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catSelectMouseClicked
                       
    }//GEN-LAST:event_catSelectMouseClicked

    private void catSelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_catSelectItemStateChanged
        
    }//GEN-LAST:event_catSelectItemStateChanged

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        this.selectCategory();
        this.dispose();
    }//GEN-LAST:event_saveBtnActionPerformed

    private void uncategorizeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uncategorizeBtnActionPerformed
        this.uncategorize(this.noteId);
    }//GEN-LAST:event_uncategorizeBtnActionPerformed

    private void getCategories(){        
        LinkedList<Category> cats = null;
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
        model.removeAllElements();
        
        try {
            cats = cc.getCategories();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Iterator <Category> it = cats.iterator();
        
        while (it.hasNext()) {
            Category c = it.next();
            comboBox.addItem(c);            
        }                
    }
    
    public void selectCategory(){
        Category c = (Category)this.catSelect.getSelectedItem();
        this.catId = c.getCategoryId();
        System.out.println(catId);

//        note hasn't been created yet
        if (this.noteId == -1) {
            this.cc.setCategory(c);
            
            System.out.println(c.getName());
        } else { //note has been created
            try {
            
                cc.selectCategory(this.noteId, c.getCategoryId(), c);
            
            } catch (SQLException ex) {
            
                Logger.getLogger(CategoryUI.class.getName()).log(Level.SEVERE, null, ex);
            
            }
        }
        
        this.dispose();
    }
    
    public void uncategorize(int noteId){
        try {
            this.cc.uncategorize(noteId);

        } catch (Exception ex) {
            Logger.getLogger(CategoryUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
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
            java.util.logging.Logger.getLogger(CategoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CategoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CategoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoryUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CategoryUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCatBtn;
    private javax.swing.JColorChooser catColor;
    private javax.swing.JComboBox<String> catSelect;
    private javax.swing.JTextPane categoryInput;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton uncategorizeBtn;
    // End of variables declaration//GEN-END:variables
}


    class Item
    {
        private int id;
        private String description;

        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public int getId()
        {
            return id;
        }

        public String getDescription()
        {
            return description;
        }

        @Override
        public String toString()
        {
            return description;
        }
    }

class ItemRenderer extends BasicComboBoxRenderer {
  @Override
  public Component getListCellRendererComponent(JList list, Object value,
      int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected,
        cellHasFocus);
    if (value != null) {
      Item item = (Item) value;
      setText(item.getDescription().toUpperCase());
    }
    if (index == -1) {
      Item item = (Item) value;
      setText("" + item.getId());
    }
    return this;
  }
}