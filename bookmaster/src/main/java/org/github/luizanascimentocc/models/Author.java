package org.github.luizanascimentocc.models;

public class Author {
    private int id;
    private String name;

    public Author(String id, String name){
        this.id = Integer.parseInt(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void print(){
        System.out.println(id + " - " + name);
    }
}
