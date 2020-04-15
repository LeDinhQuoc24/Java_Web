package vnnhnlm.open_blog.model;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String describeCategory;

    public Category() {
    }
    public Category(String name, String describeCategory) {
        this.name=name;
        this.describeCategory=describeCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describeCategory='" + describeCategory + '\'' +
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
}
