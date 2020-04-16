package vnnhnlm.open_blog.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String contentBlog;
    private Date dateTime;
    //Catrlogy là tên bảng,còn id là trường id là khóa chính của bảng Catelogy
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Blog() {
    }
    public Blog(String name,String contentBlog,Date dateTime,Category category) {
        this.name=name;
        this.contentBlog=contentBlog;
        this.dateTime=dateTime;
        this.category=category;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contentBlog='" + contentBlog + '\'' +
                ", dateTime=" + dateTime +
                ", category=" + category +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
