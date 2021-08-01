package hu.ulyssys.java.course.blog.jpahazi;

import hu.ulyssys.java.course.blog.jpahazi.dao.AuthorDAO;
import hu.ulyssys.java.course.blog.jpahazi.dao.BlogPostDAO;
import hu.ulyssys.java.course.blog.jpahazi.entity.Author;
import hu.ulyssys.java.course.blog.jpahazi.entity.BlogPost;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        
        authorExample();
        blogPostExample();

    }
    
    private static void authorExample() {
        AuthorDAO authorDAO = new AuthorDAO();

        EntityManager entityManager = Persistence.createEntityManagerFactory("TestPersistence").createEntityManager();
        entityManager.getTransaction().begin();
        Author author = new Author("Zsolt","Dankó","dpara",new Date(),new Date());

        authorDAO.save(author);

        authorDAO.findByUsername("fancyUsername").forEach(author1 -> {
            author1.setUsername("User"+System.currentTimeMillis());
            authorDAO.update(author1);
        });

        authorDAO.findAll().forEach(author1 -> {
            System.out.println(author1.getId()+" "+author1.getFirstName() + " " +
                    author1.getLastName() + " " + author1.getUsername());
        });
        entityManager.close();
    }
    
    private static void blogPostExample() {
        BlogPostDAO blogPostDAO = new BlogPostDAO();

        EntityManager entityManager = Persistence.createEntityManagerFactory("TestPersistence").createEntityManager();
        entityManager.getTransaction().begin();
        BlogPost blogPost = new BlogPost("Cool Title","coolContent",new Date(),"exampleCategory",new Date(),new Date());
        blogPostDAO.save(blogPost);

        blogPostDAO.findByTitle("BlogTitle").forEach(blogPost1 -> {
            blogPost1.setTitle("Metro "+System.currentTimeMillis());
            blogPostDAO.update(blogPost1);
        });

        blogPostDAO.findAll().forEach(blogPost1 -> {
            System.out.println(blogPost1.getId() + " " + blogPost1.getTitle() + " " + blogPost1.getCategory()+" "+
                    blogPost1.getContent() + " " + blogPost1.getPublishedDate());
        });
        entityManager.close();
    }

}
