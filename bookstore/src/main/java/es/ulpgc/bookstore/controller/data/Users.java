/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.bookstore.controller.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nassr
 */
public final class Users {
    
    private static ArrayList<User> listOfUsers = new ArrayList();
    private static final Users instance = new Users();
    
    private Users() {
        try {
            this.loadUsers();
        } catch (IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static User isUserExist(String username, String password) {
        for (User user : listOfUsers) {
            if (user.isExist(username, password)) {
                return user;
            }
        }
        return null;
    }
    

    private void loadUsers() throws FileNotFoundException, IOException {
        String csvFile = "C:\\Users\\nassr\\Desktop\\bookstore-web\\bookstore\\src\\main\\resources\\users.csv";
        String csvSplitBy = ";";
        String line = "";
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] user = line.split(csvSplitBy);

                this.listOfUsers.add(new User(user[0],user[1],user[2],user[3],user[4].split(",")));

            }

        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                }
            }
        }

    }
}
