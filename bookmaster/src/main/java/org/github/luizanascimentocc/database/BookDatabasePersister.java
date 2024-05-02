package org.github.luizanascimentocc.database;

import org.github.luizanascimentocc.models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDatabasePersister{
    public List<Book> getAllBooks(Statement st) throws SQLException {
        String query = "select a.id As idAuthor, b.id As idBook, b.title, b.`year-of-publication`,  b.`number-of-pages`, a.name AS author from book b join author a ON b.author = a.id";
        return runQuery(st, query);
    }

    public List<Book> getBookByTitle(Statement st, String title) throws SQLException{
        String query = "select a.id As idAuthor, b.id As idBook, b.title, b.`year-of-publication`,  b.`number-of-pages`, a.name AS author from book b join author a ON b.author = a.id where b.title = " + title;
        return runQuery(st, query);
    }

    public List<Book> getBookByAuthors(Statement st, String name) throws SQLException{
        String query = "select a.id As idAuthor, b.id As idBook, b.title, b.`year-of-publication`,  b.`number-of-pages`, a.name AS author from book b join author a ON b.author = a.id where a.name = " + name;
        return runQuery(st, query);
    }

    private List<Book> runQuery(Statement st, String query) throws SQLException {
        List<Book> books = new ArrayList<Book>();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()){
            Book temp = new Book(rs.getString("idBook"), rs.getString("title"), rs.getString("year-of-publication"), rs.getString("number-of-pages"), rs.getString("idAuthor"), rs.getString("author"));
            books.add(temp);
        }

        return books;
    }
}
