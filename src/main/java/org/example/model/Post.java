package org.example.model;

import jakarta.persistence.*;
import org.mariadb.jdbc.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String contenido;

    @ManyToOne
    @JoinColumn(name= "cliente_id")
    private Client client;

    @ManyToMany(mappedBy = "categories")
    private List<Post> Posts = new ArrayList<>();
    private ArrayList<Object> categories = new ArrayList<>();

    // CONSTRUCTOR
    // CONTRUCTOR VACIO
    public Post(String title, String contenido, org.example.model.Client client) {
    }

    // CONSTRUCTOR CON TODOS LOS PARAMETROS

    public Post(Long id, String title, String contenido, Client client, List<Post> posts) {
        this.id = id;
        this.title = title;
        this.contenido = contenido;
        this.client = client;
        Posts = posts;
    }

    // CONSTRUCTOR CON SOLO LOS PARAMETROS NECESARIOS
    public Post(String titulo, String contenido, Client client) {
    }


    // GETTERS Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContenido() {
            return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Post> getPosts() {
        return Posts;
    }

    public void setPosts(List<Post> posts) {
        Posts = posts;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", client=" + client +
                ", Posts=" + Posts +
                '}';
    }

    public void addCategory(Category category) {
        if (category!= null) {        if (this.categories == null) {
            this.categories = new ArrayList<>();
        }
        this.categories.add(category);
    }
    }
}
