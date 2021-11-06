package com.timbuchalka;

/**
 * Created by dev on 7/10/2015.
 */
public class Parrot extends Bird {

    protected Parrot(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Flitting from branch to branch");
    }
}
