package com.cmcoding.Categories;
import javax.persistence.*;

@Entity
public class TipCategoryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
//    List<TipEntity> tips;


    public TipCategoryEntity(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TipCategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", tips=" + tips +
                '}';
    }
}
