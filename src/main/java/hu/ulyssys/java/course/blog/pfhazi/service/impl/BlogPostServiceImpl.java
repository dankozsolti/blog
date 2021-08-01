package hu.ulyssys.java.course.blog.pfhazi.service.impl;

import hu.ulyssys.java.course.blog.pfhazi.entity.BlogPost;
import hu.ulyssys.java.course.blog.pfhazi.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;

@ApplicationScoped
public class BlogPostServiceImpl extends AbstractServiceImpl<BlogPost> implements BlogPostService {

    @Override
    public void update(BlogPost entity) {
        for (BlogPost blogPost : getAll()) {
            if(blogPost.getId().equals(entity.getId())) {
                blogPost.setTitle(entity.getTitle());
                blogPost.setContent(entity.getContent());
                blogPost.setCategory(entity.getCategory());
                blogPost.setPublishedDate(entity.getPublishedDate());
                blogPost.setLastModifiedDate(new Date());
            }
        }
    }
}
