package org.github.luizanascimentocc.models;

import java.sql.Date;

public class Book {
    private int id;
    private String title;
    private Date yearOfPublication;
    private int numberOfPages;
    private Author author;

    public Book(String id, String title, String yearOfPublication,String numberOfPages,String idAuthor,String name){
        this.id = Integer.parseInt(id);
        this.title = title;
        this.yearOfPublication = Date.valueOf(yearOfPublication);
        this.numberOfPages = Integer.parseInt(numberOfPages);
        this.author = new Author(idAuthor, name);
    }

    public void print(){
        System.out.println(id + " - " + title + " - " + yearOfPublication + " - " + author.getName());
    }
}
