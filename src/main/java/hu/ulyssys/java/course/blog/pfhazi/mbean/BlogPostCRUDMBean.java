package hu.ulyssys.java.course.blog.pfhazi.mbean;

import hu.ulyssys.java.course.blog.pfhazi.entity.BlogPost;
import hu.ulyssys.java.course.blog.pfhazi.service.BlogPostService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class BlogPostCRUDMBean implements Serializable {

    private List<BlogPost> list;
    private BlogPost selectedBlogPost;
    private boolean inFunction;

    @Inject
    private BlogPostService blogPostService;

    @PostConstruct
    private void init() {
        list = blogPostService.getAll();
        selectedBlogPost = new BlogPost();
    }

    public void initSave() {
        selectedBlogPost = new BlogPost();
        selectedBlogPost.setCreatedDate(new Date());
        selectedBlogPost.setLastModifiedDate(new Date());
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        if (selectedBlogPost.getId() == null) {
            selectedBlogPost.setId(System.currentTimeMillis());
            blogPostService.add(selectedBlogPost);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            blogPostService.update(selectedBlogPost);
            list = blogPostService.getAll();
            selectedBlogPost = new BlogPost();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
    }

    public void remove() {
        blogPostService.remove(selectedBlogPost);
        list = blogPostService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedBlogPost = new BlogPost();

    }

    public List<BlogPost> getList() {
        return list;
    }

    public void setList(List<BlogPost> list) {
        this.list = list;
    }

    public BlogPost getSelectedBlogPost() {
        return selectedBlogPost;
    }

    public void setSelectedBlogPost(BlogPost selectedBlogPost) {
        this.selectedBlogPost = selectedBlogPost;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}