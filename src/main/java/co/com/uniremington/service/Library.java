package co.com.uniremington.service;

import co.com.uniremington.model.Book;
import co.com.uniremington.model.Loan;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> bookList = new ArrayList<>();
    List<Loan> loanList = new ArrayList<>();

    public boolean addBook (String isbn, String title, String author, String category){
        boolean bookExists = false;

        for (int i = 0; i < this.bookList.size(); i++){
            if (this.bookList.get(i).getIsbn()== isbn){
               bookExists = true;
               break;
            }
        }
        if (bookExists){
            return false;
        }
        Book newBook = new Book(isbn, title, author, category);
        this.bookList.add(newBook);
        return true;

    }
}
