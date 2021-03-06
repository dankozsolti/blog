package hu.ulyssys.java.course.blog.jpahazi.entity;

import com.sun.mail.imap.protocol.ID;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractBlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date", updatable = false, nullable = false)
    private Date createdDate;
    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    public AbstractBlogEntity() {
    }

    public AbstractBlogEntity(Date createdDate, Date lastModifiedDate) {
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
