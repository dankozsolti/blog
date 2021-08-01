package hu.ulyssys.java.course.blog.pfhazi.view;

import hu.ulyssys.java.course.blog.pfhazi.entity.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class SelectOneMenuView {

    private String option;
    private List<String> options;
    private List<String> categories;

    @PostConstruct
    public void init() {
        categories = new ArrayList<>();

        for (Category category : Category.values()) {
            categories.add(category.name());
            System.out.println(category.name());
        }
        //options
        options = new ArrayList<>();
        options.addAll(categories);
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}