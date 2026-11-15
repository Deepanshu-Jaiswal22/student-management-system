
package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class studentservice {

    private final SessionFactory sessionFactory;

    // Constructor: Initialize Hibernate using persistence.xml
    public studentservice() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("st_man");

        sessionFactory = emf.unwrap(SessionFactory.class);
    }

    // Create a new account
    public void createAccount(student account) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(account);

            transaction.commit();

            System.out.println("Account created successfully!");

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    // Find an account by ID
    public student findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(student.class, id);

        } catch (Exception e) {
            System.out.println("Error finding account: " + e.getMessage());
            return null;
        }
    }

    public void updatestudent(Long updateid, String rollNumber, String updateName, String updatecourse) {

        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            student account = session.find(student.class, updateid);

            if (account != null) {

                account.setStudentName(updateName);
                account.setCourse(updatecourse);
                account.setRollNumber(rollNumber);

                transaction.commit();

                System.out.println("Account updated successfully!");

            } else {
                transaction.rollback();
                System.out.println("Account not found!");
            }

        } catch (Exception e) {

            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println("Error updating account: " + e.getMessage());
        }
    }

    // Delete an account by ID
    public void deletestudent(Long id) {
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            student account = session.find(student.class, id);

            if (account == null) {
                System.out.println("Account not found!");
                transaction.rollback();
                return;
            }

            session.remove(account);

            transaction.commit();

            System.out.println("Account deleted successfully!");

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println("Error deleting account: " + e.getMessage());
        }
    }

    // Close Hibernate resources when the application ends
    public void close() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

}
