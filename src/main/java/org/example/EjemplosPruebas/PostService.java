package org.example.EjemplosPruebas;

import org.example.HibernateUtil;
import org.example.model.Category;
import org.example.model.Client;
import org.example.model.Post;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PostService {

//Crear un nuevo post
        public void createPost(String titulo, String contenido, Client client) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                Post post = new Post(titulo, contenido, (org.mariadb.jdbc.client.Client) client);
                session.save(post);

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

 //Obtener un post por su id
        public Post get(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                return session.get(Post.class, id);
            } catch (Exception e) {
                throw e;
            } finally {
                session.close();
            }
        }

//Actualizar un post

        public void update(int id, String titulo, String contenido) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                Post post = session.get(Post.class, id);

                if (titulo != null && !titulo.isEmpty()) {
                    post.setTitle(titulo);
                }

                if (contenido != null && !contenido.isEmpty()) {
                    post.setContenido(contenido);
                }

                session.update(post);

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

//Borrar un post

        public void delete(int id) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                Post post = session.get(Post.class, id);

                if (post != null) {
                    session.delete(post);
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

//Obtener todos los posts

        public void deleteAll() {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                session.createQuery("delete from Post").executeUpdate();

                tx.commit();
            } catch (
                    Exception e) {
                if (tx != null) {
                    tx.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }

    public void createPost(Post post) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.save(post);

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

    public void setCategories(int postId, String[] categoryNames) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Post post = session.get(Post.class, postId);

            for (String categoryName : categoryNames) {
                Category category = session.get(Category.class, categoryName);
                post.addCategory(category);
            }

            session.update(post);

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
}

