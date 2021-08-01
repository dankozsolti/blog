package hu.ulyssys.java.course.blog.pfhazi.service;

import hu.ulyssys.java.course.blog.pfhazi.entity.AbstractBlogEntity;

import java.util.List;

public interface CoreService<T extends AbstractBlogEntity> {

    List<T> getAll();

    void add(T entity);

    void remove(T entity);

    void update(T entity);

}
