package org.example.onlinebookstore.repository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.onlinebookstore.exception.DataProcessingException;
import org.example.onlinebookstore.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    @Override
    public Book save(final Book book) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
            return book;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can`t save book: " + book, e);
        }
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Book", Book.class).list();
        } catch (Exception e) {
            throw new DataProcessingException("Can`t find all books", e);
        }
    }
}
