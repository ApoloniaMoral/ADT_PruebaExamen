package org.example.EjemplosPruebas;

import org.example.HibernateUtil;
import org.example.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientService {

    public void create(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Client client = new Client(nombre);
            session.persist(client);

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

    public Client get(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.get(Client.class, id);
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

            Client cliente = session.get(Client.class, id);

            if (nombre != null && !nombre.isEmpty()) {
                cliente.setNombre(nombre);
            }

            session.update(cliente);

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

            Client client = session.get(Client.class, id);

            if (client != null) {
                session.delete(client);
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

    public List<Client> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            return session.createQuery("FROM Cliente", Client.class).getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }

    public Client getClient(int clientId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Client.class, clientId);
        } catch (Exception e) {
            throw e;
        } finally {
            session.close();
        }
    }
}

