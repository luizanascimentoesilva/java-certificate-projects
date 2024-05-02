package org.github.luizanascimentocc;

import org.github.luizanascimentocc.database.BookDatabasePersister;
import org.github.luizanascimentocc.models.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookmaster";
        String password = "1234";
        String user = "root";
        BookDatabasePersister bookDatabasePersister = new BookDatabasePersister();

        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement st = conn.createStatement();) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Scanner scanner = new Scanner(System.in);

            int opcao;
            do {
                System.out.println("### MENU ###");
                System.out.println("1 - Buscar todos os livros");
                System.out.println("2 - Buscar livro por título");
                System.out.println("3 - Buscar livro por autor");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        print(bookDatabasePersister.getAllBooks(st));
                        break;
                    case 2:
                        System.out.print("Digite o título do livro: ");
                        String titulo = scanner.nextLine();
                        print(bookDatabasePersister.getBookByTitle(st, titulo));
                        break;
                    case 3:
                        System.out.print("Digite o nome do autor: ");
                        String autor = scanner.nextLine();
                        print(bookDatabasePersister.getBookByAuthors(st, autor));
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print(List<Book> books) {
        for (Book book: books) {
            book.print();
        }
    }
}