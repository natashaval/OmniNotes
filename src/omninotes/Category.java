/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omninotes;

/**
 *
 * @author Natasha
 */
public class Category {
    private Integer categoryId;
    private String name;
    private String color;

    public Category(Integer categoryId, String name, String color) {
        this.categoryId = categoryId;
        this.name = name;
        this.color = color;
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
    
    
}
