package com.cmcoding.Categories.Tip;

import java.util.Objects;

public class Tip {

    private Integer id;
    private String tip;
    private Integer categoryId;

    public Tip() {
    }

    public Tip(String tip, Integer categoryId) {
        this.tip = tip;
        this.categoryId = categoryId;
    }

    public Tip(Integer id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public Tip(Integer id, String tip, Integer categoryId) {
        this.id = id;
        this.tip = tip;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tip tip1 = (Tip) o;
        return Objects.equals(id, tip1.id) &&
                Objects.equals(tip, tip1.tip) &&
                Objects.equals(categoryId, tip1.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tip, categoryId);
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
