/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nassr
 */
public class User {

    private final String id;
    private final String username;
    private final String password;
    private final String role;
    private String[] cart;

    public User(String id, String username, String password, String role, String[] cart) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cart = cart;
    }

    public boolean isExist(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUsername() {
        return this.username;
    }

    public String[] getCart() {
        return this.cart;
    }

    public void deleteBookFromCartById(String id) {
        //String[] res = new String[cart.length - 1];
        for (int i = 0; i < cart.length; i++) {
            if (cart[i].equals(id)) {
                //res = addElement(res, id);
                cart = removeElementUsingCollection(cart, i);
            }
        }
    }

    public static String[] removeElementUsingCollection( String[] arr, int index ){
        List<String> tempList = new ArrayList<String>(Arrays.asList(arr));
        tempList.remove(index);
        return tempList.toArray(new String[0]);
    }
}
