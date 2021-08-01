package hu.ulyssys.java.course.blog.pfhazi.entity;

import java.util.Date;

public class BlogPost extends AbstractBlogEntity {

    private String title;
    private String content;
    private Date publishedDate;
    private Category category;

    public BlogPost() {
    }

    public BlogPost(Long id, Date createdDate, Date lastModifiedDate, String title, String content,
                    Date publishedDate, Category category) {
        super(id, createdDate, lastModifiedDate);
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
