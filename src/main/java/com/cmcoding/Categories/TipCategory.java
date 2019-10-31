package com.cmcoding.Categories;

import com.cmcoding.Categories.Tip.Tip;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TipCategory {

    private Integer id;
    private String name;
    private List<Tip> tips;

    public TipCategory() {
        //empty constructor here for json serialization
    }

    public TipCategory(String name) {
        this.name = name;
    }

    public TipCategory(Integer id, String name, List<Tip> tips) {
        this.id = id;
        this.name = name;
        this.tips = tips;
    }

    public TipCategory(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.tips = new ArrayList<>();
    }

    public List<Tip> getTips() {
        return tips;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipCategory category = (TipCategory) o;
        return Objects.equals(id, category.id) &&
                Objects.equals(name, category.name) &&
                Objects.equals(tips, category.tips);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, tips);
    }

    @Override
    public String toString() {
        return "TipCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tips=" + tips +
                '}';
    }
}
