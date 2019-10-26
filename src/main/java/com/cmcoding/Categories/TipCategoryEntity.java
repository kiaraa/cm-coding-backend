package com.cmcoding.Categories;
import com.cmcoding.Categories.Tip.TipEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TipCategoryEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval=true)
    List<TipEntity> tips;

    public TipCategoryEntity(String name) {
        this.name = name;
        this.tips = new ArrayList<>();
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

    public List<TipEntity> getTips() {
        return tips;
    }

    public void setTips(List<TipEntity> tips) {
        this.tips = tips;
    }

    @Override
    public String toString() {
        return "TipCategoryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tips=" + tips +
                '}';
    }
}
