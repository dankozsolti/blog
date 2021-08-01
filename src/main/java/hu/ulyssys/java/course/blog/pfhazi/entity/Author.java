package hu.ulyssys.java.course.blog.pfhazi.entity;

import java.util.Date;

public class Author extends AbstractBlogEntity {

    private String firstName;
    private String lastName;
    private String userName;

    public Author() {
    }

    public Author(Long id, Date createdDate, Date lastModifiedDate, String firstName,
                  String lastName, String userName) {
        super(id, createdDate, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
