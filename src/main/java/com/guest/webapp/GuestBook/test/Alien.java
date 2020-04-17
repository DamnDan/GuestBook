package com.guest.webapp.GuestBook.test;

public class Alien {
    public void interagieren() {
        Mensch mensch = null;
        mensch = new Wolf();
        mensch.sprechen();
        mensch.winken();

        mensch = new Daniel();
        mensch.winken();
    }
}
