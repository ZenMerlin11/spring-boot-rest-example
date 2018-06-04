package io.github.zenmerlin11.coffeerun.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String coffee;
    private String emailAddress;
    private String size;
    private String flavor;
    private String strength;

    public CoffeeOrder() {}

    public String getCoffee() {
        return coffee;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getStrength() {
        return strength;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
