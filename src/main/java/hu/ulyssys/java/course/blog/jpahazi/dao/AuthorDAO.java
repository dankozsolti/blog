package hu.ulyssys.java.course.blog.jpahazi.dao;

import hu.ulyssys.java.course.blog.jpahazi.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorDAO {

    private static final String PERSISTENCE_UNIT = "TestPersistence";

    private EntityManager createEntityManager() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT).createEntityManager();
    }

    public void save(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void update(Author author) {
        EntityManager entityManager = createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(author);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Author> findAll() {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n",Author.class);
        return query.getResultList();
    }

    public List<Author> findByUsername(String name) {
        TypedQuery<Author> query = createEntityManager().createQuery("select n from Author n where n.username =:username",Author.class);
        query.setParameter("username",name);
        return query.getResultList();
    }
}
