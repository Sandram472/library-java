package co.com.uniremington.service;

import co.com.uniremington.model.Book;
import co.com.uniremington.model.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {
    private List<Book> bookList = new ArrayList<Book>();
    private List<Loan> loanList = new ArrayList<>();

    public boolean addBook(String isbn, String title, String author, String category) {

        if (this.findBookByIsbn(isbn) != null) {
            return false;
        } else {

            Book newBook = new Book(isbn, title, author, category);
            this.bookList.add(newBook);
            return true;
        }

    }

    public Book findBookByIsbn(String isbn) {
        Book book = null;
        for (int i = 0; i < this.bookList.size(); i++) {
            if (Objects.equals(this.bookList.get(i).getIsbn(), isbn)) {
                book = this.bookList.get(i);
                return book;
            }
        }
        return book;

    }

    public List<Book> findBookByTitle(String title) {

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < this.bookList.size(); i++) {
            if (this.bookList.get(i).getTitle().toLowerCase().contains(title.toLowerCase())) {
                books.add(this.bookList.get(i));
            }
        }
        return books;
    }

    public List<Book> getCatalog() {
        return this.bookList;
    }
}
