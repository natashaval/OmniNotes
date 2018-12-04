/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Natasha
 */
public class Category {
    private Integer categoryId;
    private String name;
    private String color;
    private Integer red;

    public Category(Integer categoryId, String name, int r, int g, int b) {
        this.categoryId = categoryId;
        this.name = name;
        this.red = r; this.blue = b; this.green = g;
    }

    public Category(String mode) {
      this.categoryId = null;
      this.name = null;
      this.red = null; this.green = null; this.blue = null;
    }

    public Category() {
        System.out.println("category constructed");
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }
    private Integer green;
    private Integer blue;
    
    public Category(Integer categoryId, String name, String color) {
        this.categoryId = categoryId;
        this.name = name;
        this.color = color;
    }
    
    public Category(String name, int r, int g, int b) {        
        this.name = name;
        this.red = r; this.blue = b; this.green = g;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString(){
     return this.name;   
    }
    
    
}
