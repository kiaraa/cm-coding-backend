package com.cmcoding.Categories.Tip;

import java.util.Objects;

public class Tip {

    private Integer id;
    private String tip;

    public Tip() {
    }

    public Tip(Integer id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public Tip(String tip) {
        this.tip = tip;
    }

    public Integer getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tip tip1 = (Tip) o;
        return Objects.equals(id, tip1.id) &&
                Objects.equals(tip, tip1.tip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tip);
    }

    @Override
    public String toString() {
        return "Tip{" +
                "id=" + id +
                ", tip='" + tip + '\'' +
                '}';
    }
}
