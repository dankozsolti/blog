package hu.ulyssys.java.course.blog.pfhazi.service.impl;

import hu.ulyssys.java.course.blog.pfhazi.entity.AbstractBlogEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractBlogEntity> {

    private List<T> list = new ArrayList<>();

    public List<T> getAll() {
        return list;
    }

    public void add(T entity) {
        list.add(entity);
    }

    public void remove(T entity) {
        list.remove(entity);
    }

}
