package com.desafiolatam.recyclerviewexample.model;

public class Animal {

    // PASO DOS : generamos modelo de lo que veremos en pantalla


    private String url;
    private String name;

    public Animal(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
