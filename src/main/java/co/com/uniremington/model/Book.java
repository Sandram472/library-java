package co.com.uniremington.model;

public class
Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private BookStatus status;

    public Book(String isbn, String title, String author, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = BookStatus.Available;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public BookStatus getStatus() {
        return status;
    }

    public boolean isAvailable(){
        if (this.status == BookStatus.Available) {
            return true;
        } else {
            return false;
        }
    }

    public void changeState(BookStatus newStatus){
        this.status = newStatus;
    }

    public String toString(){
        return "ISBN: " + this.isbn + ", Title: " + this.title + ", Author: " + this.author + ", Category: " + this.category + ", Status: " + this.status;
    }
}
