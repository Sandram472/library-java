package co.com.uniremington.model;

import java.time.LocalDate;

public class Loan {
    private String id;
    private Book book;
    private String borrowerName;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private boolean returned = false;

    public Loan(String id, Book book, String borrowerName) {
        this.id = id;
        this.book = book;
        this.borrowerName = borrowerName;
        this.loanDate = LocalDate.now();
        this.dueDate = this.loanDate.plusDays(14);
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void registerReturn(){
        this.returned = true;
    }


    public boolean isOverdue (){
        if (this.dueDate.isAfter(LocalDate.now()) && this.returned == false){
           return true;
        }else {
            return false;
        }
    }

    public String toString(){
        return "Id: " + this.id + " Titulo: " + this.book.getTitle() + " Prestatario: " + this.borrowerName + " Fecha prestamo: " + this.loanDate.toString() + " Fecha vencimiento: "+this.dueDate + " Activo: "+!this.returned;
    }
    
}
