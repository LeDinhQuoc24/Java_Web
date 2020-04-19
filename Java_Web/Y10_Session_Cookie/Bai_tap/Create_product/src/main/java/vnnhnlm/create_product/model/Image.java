package vnnhnlm.create_product.model;

import javax.persistence.*;
@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String id_product;
    private String image_url;
    public Image() {
    }

    public Image(String image_url,String id_product) {
        this.image_url = image_url;
        this.id_product=id_product;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", id_product='" + id_product + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
