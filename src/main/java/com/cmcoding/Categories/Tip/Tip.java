package com.cmcoding.Categories.Tip;

public class Tip {

    private int id;
    private String tip;

    public Tip() {
    }

    public Tip(int id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }
}
