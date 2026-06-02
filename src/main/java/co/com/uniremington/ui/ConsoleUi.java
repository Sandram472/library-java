package co.com.uniremington.ui;

import co.com.uniremington.model.Book;
import co.com.uniremington.service.Library;

import java.util.List;
import java.util.Scanner;

public class ConsoleUi {
    private Library library;
    private Scanner scanner;

    public ConsoleUi() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }
    private void showMainMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Libros");
        System.out.println("2. Préstamos");
        System.out.println("3. Resumen");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void showBookMenu() {
        System.out.println("\n--- SUBMENÚ LIBROS ---");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Buscar por ISBN");
        System.out.println("3. Buscar por Título");
        System.out.println("4. Ver todos los libros");
        System.out.println("5. Ver libros disponibles");
        System.out.println("6. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    private void showMenuLoan() {
        System.out.println("\n--- SUBMENÚ PRÉSTAMOS ---");
        System.out.println("1. Registrar Préstamo");
        System.out.println("2. Registrar Devolución");
        System.out.println("3. Ver Préstamos Activos");
        System.out.println("4. Ver Historial de Préstamos");
        System.out.println("5. Volver al Menú Principal");
        System.out.print("Seleccione una opción: ");
    }

    public void start(){
        int option = 0;
        while (option != 4){
            this.showMainMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    this.handleBookMenu();
                    break;
                case 2:
                    this.handleMenuLoan();
                    break;
                case 3:
                    // Lógica para ver resumen
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");

            }
        }
    }

    private void handleBookMenu() {
        int option = 0;
        while (option != 6) {
            this.showBookMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Registrar nuevo libro ");
                    System.out.println("Ingrese ISBN ");
                    String isbn = scanner.nextLine();
                    System.out.println("Ingrese título ");
                    String title = scanner.nextLine();
                    System.out.println("Ingrese autor ");
                    String author = scanner.nextLine();
                    System.out.println("Ingrese categoria ");
                    String category = scanner.nextLine();
                    boolean registered = this.library.addBook(isbn, title, author, category);
                    if (registered) {
                        System.out.println("Libro registrado exitosamente.");
                    } else {
                        System.out.println("Error al registrar el libro. ISBN ya existe.");
                    }
                    System.out.println("presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Buscar libro por ISBN ");
                    System.out.println("Ingrese ISBN ");
                    String searchedIsbn = scanner.nextLine();
                    Book foundBook = this.library.findBookByIsbn(searchedIsbn);
                    if (foundBook != null) {
                        System.out.println("Libro encontrado:");
                        System.out.println(foundBook.toString());
                    } else {
                        System.out.println("No se encontró un libro con ese ISBN.");
                    }
                    System.out.println("presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Buscar libro por titulo");
                    System.out.println("Ingrese título ");
                    String searchedTitle = scanner.nextLine();
                    List<Book> foundBooks = this.library.findBookByTitle(searchedTitle);
                    for (Book book : foundBooks) {
                        System.out.println(book.toString());
                        System.out.println("-------------------------\n");
                    }
                    System.out.println("presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 4:
                    List<Book> catalog = this.library.getCatalog();
                    for (Book book : catalog) {
                        System.out.println(book.toString());
                        System.out.println("-------------------------\n");
                    }
                    System.out.println("presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 5:
                    List<Book> booksAvailable = this.library.getAvailableBooks();
                    for (Book book : booksAvailable) {
                        System.out.println(book.toString());
                        System.out.println("-------------------------\n");
                    }
                    System.out.println("presione enter para continuar...");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Regresar al menu principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private void handleMenuLoan (){
        int option = 0;
        while (option != 5) {
            this.showMenuLoan();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    // Lógica para registrar préstamo
                    break;
                case 2:
                    // Lógica para registrar devolución
                    break;
                case 3:
                    // Lógica para ver préstamos activos
                    break;
                case 4:
                    // Lógica para ver historial de préstamos
                    break;
                case 5:
                    System.out.println("Regresar al menu principal.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

}
