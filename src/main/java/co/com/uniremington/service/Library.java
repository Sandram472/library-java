package co.com.uniremington.service;

import co.com.uniremington.model.Book;
import co.com.uniremington.model.BookStatus;
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

    public List<Book> getAvailableBooks() {

        List<Book> books = new ArrayList<>();

        for (int i = 0; i < this.bookList.size(); i++) {
            if (this.bookList.get(i).isAvailable()) {
                books.add(this.bookList.get(i));
            }
        }
        return books;
    }

    private String generateId(){
        String id = String.format("P%03d", this.loanList.size() +1);
        return id;
    }

    public Loan  borrowBook(String isbn, String name) {
        Book book = this.findBookByIsbn(isbn);
        if (book != null && book.isAvailable()){
            Loan loan = new Loan(this.generateId(), book, name);
            book.changeState(BookStatus.Loaned);
            this.loanList.add(loan);
            return loan;
        }else {
            return null;
        }
    }

    public boolean returnBook(String borrowId){
        Loan loan = null;
        for (int i = 0; i < this.loanList.size(); i++){
            if (Objects.equals(this.loanList.get(i).getId(),borrowId)){
                loan = this.loanList.get(i);
                break;
            }
        }
        if (loan != null && loan.isReturned() == false){
            loan.registerReturn();
            loan.getBook().changeState(BookStatus.Available);
            return true;
        }else {
            return false;
        }
    }

    public List<Loan> getActiveLoans(){
        List<Loan> loans = new ArrayList<>();
        for (int i = 0; i < this.loanList.size(); i++){
            if (this.loanList.get(i).isReturned() == false){
                loans.add(this.loanList.get(i));
            }
        }
        return loans;
    }

    public List<Loan> getAllLoans(){
        return this.loanList;
    }
}
