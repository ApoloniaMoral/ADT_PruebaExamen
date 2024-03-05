package org.example.EjemplosPruebas;

import org.example.HibernateUtil;
import org.example.model.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoryService {

    public void create(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Category category = new Category(nombre);
            session.persist(category);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Category get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.get(Category.class, id);
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public void update(Long id, String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Category category = session.get(Category.class, id);

            if (nombre != null && !nombre.isEmpty()) {
                category.setNombre(nombre);
            }

            session.update(category);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Category category = session.get(Category.class, id);

            if (category != null) {
                session.delete(category);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Category> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Category", Category.class).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}
