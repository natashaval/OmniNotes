/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Configs.DBConnection;
import Views.CategoryUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Models.Category;
import Models.Category;
import Models.Note;
import Views.NoteFormEditorUI;

/**
 *
 * @author Natasha
 */
public class CategoryController {
    
    private DBConnection db = new DBConnection();
    private Connection conn = null;
    private LinkedList<Category> c = null;
    private NoteFormEditorUI nfe = new NoteFormEditorUI();
    
    public CategoryController(){
        this.conn = db.newConnection();                
    }

    public CategoryController(NoteFormEditorUI aThis) {
        this.conn = db.newConnection();                
        this.nfe = aThis;
    }
    
    public void openCategoryUI(){
        CategoryUI cui = new CategoryUI();
        cui.setVisible(true);
    }
    
    public void addCategory(Category cat) throws SQLException{
        String sql;
        sql = "INSERT INTO category (name, red, green, blue)"
                + "VALUES (?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, cat.getName());
        preparedStatement.setInt(2, cat.getRed());  
        preparedStatement.setInt(3, cat.getGreen());  
        preparedStatement.setInt(4, cat.getBlue());  
        preparedStatement.executeUpdate();  
        
        
        System.out.println("category added");
    }
    
    public void selectCategory() throws SQLException {
        
        
    }
    
    public LinkedList<Category> getCategories() throws SQLException{
        LinkedList<Category> cats = new LinkedList();
        
        Statement stmt = conn.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from category");                         
            
        while(rs.next()){
            Category c = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            System.out.println(c.getCategoryId());
            cats.add(c);
        }
        
        return cats;
    }

    public void openCategoryUI(int noteId) {
        CategoryUI cui = new CategoryUI(noteId, this);
        cui.setVisible(true);
        
    }
    

    public void selectCategory(int noteId, int catId, Category c) throws SQLException {
        String sql;
       
        sql = "UPDATE post set id_category = ? where id_note = ?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(2, noteId);
        preparedStatement.setInt(1, catId);  
        
        preparedStatement.executeUpdate();  
        this.nfe.setCat(c);
        System.out.println("category selected");
    }
    
    public void setCategory(Category c) {        
        this.nfe.setCat(c);
        System.out.println("category setted" + c.getCategoryId());
    }
    
    public Category findCategory(String catId) throws Exception {
        
        Category cat = null;
        
        String sql = "select * from category where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, catId); 
        ResultSet rs= ps.executeQuery();
        
        while(rs.next()){
            cat = new Category(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));            
        }
        
        return cat;
    }
    
    public void uncategorize(int noteId) throws Exception {
                String sql;
       
        sql = "UPDATE post set id_category = ? where id_note = ?";
        
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, null);  
        preparedStatement.setInt(2, noteId);

        preparedStatement.executeUpdate();  
        System.out.println("uncategorized");
    }
   
    
}
