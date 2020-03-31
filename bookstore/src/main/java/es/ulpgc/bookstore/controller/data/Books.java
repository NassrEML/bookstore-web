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
public final class Books {
    
    private static ArrayList<Book> listOfBooks = new ArrayList();
    private static final Books instance = new Books();
    
    private Books() {
        try {
            this.loadBooks();
        } catch (IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Book getBookById(String id) {
        for (Book book : listOfBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    private void loadBooks() throws FileNotFoundException, IOException {
        String csvFile = "C:\\Users\\nassr\\Desktop\\bookstore-web\\bookstore\\src\\main\\resources\\books.csv";
        String csvSplitBy = ";";
        String line = "";
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] book = line.split(csvSplitBy);

                Books.listOfBooks.add(new Book(book[0],book[1],book[2]));

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

