package com.guest.webapp.GuestBook.test;

public class Wolf implements Mensch {
    @Override
    public void winken() {
        System.out.println("wonk");
    }

    @Override
    public String sprechen() {
        return "Hello";
    }
}
