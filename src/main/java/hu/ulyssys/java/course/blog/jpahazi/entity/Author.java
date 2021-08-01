package hu.ulyssys.java.course.blog.jpahazi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "author")
public class Author extends AbstractBlogEntity implements Serializable {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;

    public Author(String firstName, String lastName, String username, Date createdDate, Date lastModifiedDate) {
        super(createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public Author() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }
}
