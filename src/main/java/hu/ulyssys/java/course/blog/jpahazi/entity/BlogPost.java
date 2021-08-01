package hu.ulyssys.java.course.blog.jpahazi.entity;

import hu.ulyssys.java.course.blog.pfhazi.entity.Category;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class BlogPost extends AbstractBlogEntity implements Serializable {

    @Column
    private String title;
    @Column
    private String content;
    @Column(name = "published_date", nullable = false)
    private Date publishedDate;
    @Column
    private String category;

    public BlogPost() {
    }

    public BlogPost(String title, String content, Date publishedDate, String category, Date createdDate, Date lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.title = title;
        this.content = content;
        this.publishedDate = publishedDate;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
