package hu.ulyssys.java.course.blog.pfhazi.service.impl;

import hu.ulyssys.java.course.blog.pfhazi.entity.Author;
import hu.ulyssys.java.course.blog.pfhazi.service.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class AuthorServiceImpl extends AbstractServiceImpl<Author> implements AuthorService {
    @Override
    public void update(Author entity) {
        for (Author author : getAll()) {
            if(author.getId().equals(entity.getId())) {
                author.setFirstName(entity.getFirstName());
                author.setLastName(entity.getLastName());
                author.setUserName(entity.getUserName());
                author.setLastModifiedDate(new Date());
            }
        }
    }
}
