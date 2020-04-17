package com.guest.webapp.GuestBook.test;

import net.bytebuddy.implementation.bind.MethodDelegationBinder;

public class Daniel implements Mensch {
    @Override
    public void winken() {
        System.out.println("wink");
    }

    @Override
    public String sprechen() {
        return "Hallo";
    }
}
