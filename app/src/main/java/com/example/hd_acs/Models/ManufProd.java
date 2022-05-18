package com.example.hd_acs.Models;

public class ManufProd {
    public String id, model, material, color, worker, amount;

    public ManufProd () {
    }

    public ManufProd(String id, String model, String material, String color, String worker, String amount) {
        this.id = id;
        this.model = model;
        this.material = material;
        this.color = color;
        this.worker = worker;
        this.amount = amount;
    }
}
