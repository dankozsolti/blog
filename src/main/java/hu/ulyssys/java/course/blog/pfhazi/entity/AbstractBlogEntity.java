package hu.ulyssys.java.course.blog.pfhazi.entity;

import java.util.Date;

public abstract class AbstractBlogEntity {

    private Long id;
    private Date createdDate;
    private Date lastModifiedDate;

    public AbstractBlogEntity() {
    }

    public AbstractBlogEntity(Long id, Date createdDate, Date lastModifiedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
