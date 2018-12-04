/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author adis
 */
public class Location {

    public Location(String name, String coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }
    
    @Override
    public String toString(){
        return name + " " + coordinates;
    }
    
    public String getInfo(){
        return name + " " + coordinates;
    }
    
    private String name;
    private String coordinates;
}
