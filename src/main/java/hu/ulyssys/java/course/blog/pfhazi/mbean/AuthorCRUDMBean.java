package hu.ulyssys.java.course.blog.pfhazi.mbean;

import hu.ulyssys.java.course.blog.pfhazi.entity.Author;
import hu.ulyssys.java.course.blog.pfhazi.service.AuthorService;

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
public class AuthorCRUDMBean implements Serializable {

    private List<Author> list;
    private Author selectedAuthor;
    private boolean inFunction;

    @Inject
    private AuthorService authorService;

    @PostConstruct
    private void init() {
        list = authorService.getAll();
        selectedAuthor = new Author();

    }

    public void initSave() {
        selectedAuthor = new Author();
        selectedAuthor.setLastModifiedDate(new Date());
        selectedAuthor.setCreatedDate(new Date());
        inFunction = true;
    }

    public void initEdit() {
        inFunction = true;
    }

    public void save() {
        selectedAuthor.setLastModifiedDate(new Date());
        if (selectedAuthor.getId() == null) {
            selectedAuthor.setId(System.currentTimeMillis());
            authorService.add(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres hozzáadás"));

        } else {
            authorService.update(selectedAuthor);
            list = authorService.getAll();
            selectedAuthor = new Author();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));

        }
    }

    public void remove() {
        authorService.remove(selectedAuthor);
        list = authorService.getAll();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        inFunction = false;
        selectedAuthor = new Author();

    }

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    public Author getSelectedAuthor() {
        return selectedAuthor;
    }

    public void setSelectedAuthor(Author selectedAuthor) {
        this.selectedAuthor = selectedAuthor;
    }

    public boolean isInFunction() {
        return inFunction;
    }
}