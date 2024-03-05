package org.example.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "category_id",
            joinColumns =@JoinColumn(name="post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private List<Category> categories = new ArrayList<>();

    // CONSTRUCTOR
    // CONTRUCTOR VACIO

    public Category() {
    }
    // CONSTRUCTOR CON TODOS LOS PARAMETROS
    public Category(Long id, String nombre, List<Category> categories) {            this.id =id;
        this.nombre =nombre;
        this.categories =categories;
}

    public Category(String nombre) {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categories=" + categories +
                '}';
    }

}
