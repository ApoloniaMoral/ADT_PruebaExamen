package org.example.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Post> posts = new ArrayList<>();

    // CONTRUCTOR VACÍO
    public Client() {
    }

    // CONSTRUCTOR CON TODOS LOS PARÁMETROS
    public Client(Long id, String nombre, List<Post> posts) {
        this.id = id;
        this.nombre = nombre;
        this.posts = posts;
    }

    // CONSTRUCTOR CON TODOS LOS PARÁMETROS NECESARIOS
    public Client(String nombre) {
        this.nombre = nombre;
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posts=" + posts +
                '}';
    }

}
