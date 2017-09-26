package com.luke.example.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PreRenderViewEvent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class HelloBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<String> carts = new ArrayList<String>();

    {
        carts.add("11111");
        carts.add("22222");
        carts.add("33333");
        carts.add("44444");


    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<String> getCarts() {
        return carts;
    }

    public void setCarts(List<String> carts) {
        this.carts = carts;
    }


    public void addNewCard() {

        carts.add("hellllllll");

    }
}