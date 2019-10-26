package com.cmcoding.Categories.Tip;
import com.cmcoding.Categories.TipCategoryEntity;

import javax.persistence.*;

@Entity
public class TipEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String tip;

    @ManyToOne
    @JoinColumn(name="category")
    private TipCategoryEntity category;

    public TipEntity(String tip) {
        this.tip = tip;
    }

    public TipEntity(String tip, TipCategoryEntity category) {
        this.tip = tip;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public TipCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(TipCategoryEntity category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "TipEntity{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", category=" + category +
                '}';
    }
}
