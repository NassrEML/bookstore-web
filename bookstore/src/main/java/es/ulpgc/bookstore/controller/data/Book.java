/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller.data;

/**
 *
 * @author nassr
 */

public class Book {

    private final String id;
    private final String title;
    private final String price;
    
    public Book(String id, String title, String price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getPrice(){
        return this.price + "€";
    }
    
}
