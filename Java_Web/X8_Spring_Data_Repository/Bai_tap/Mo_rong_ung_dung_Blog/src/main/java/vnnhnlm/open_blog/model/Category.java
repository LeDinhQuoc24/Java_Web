package vnnhnlm.open_blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String describeCategory;

    @OneToMany(targetEntity = Blog.class)
    private List<Blog> blogs;

    public Category() {
    }
    public Category(String name, String describeCategory,List<Blog> blogs) {
        this.name=name;
        this.describeCategory=describeCategory;
        this.blogs = blogs;
    }


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describeCategory='" + describeCategory + '\'' +
                ", blogs=" + blogs +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribeCategory() {
        return describeCategory;
    }

    public void setDescribeCategory(String describeCategory) {
        this.describeCategory = describeCategory;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
