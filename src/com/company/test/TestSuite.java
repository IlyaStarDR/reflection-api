package com.company.test;

import com.company.annotation.Test;
import com.company.annotation.TestType;

public class TestSuite {

    @Test("Check auth call return 200 OK")
    @TestType(name="API")
    private void checkIfAuthCallSuccess() {
        System.out.println("Auth call is 200 OK");
    }

    @Test("Check Customer Resources call return 200 OK")
    @TestType(name="API")
    public void checkIfGetCustomerResourcesCallSuccess() {
        System.out.println("Customer Resources call is 200 OK");
    }

    @Test("Check Customer wishlist contains 2 items")
    @TestType(name="UI")
    private void checkIfWishlistHasTwoItems() {
        System.out.println("Wish list has 2 items");
    }

    @Test("Check Customer basket has total 25$")
    @TestType(name="UI")
    public void checkThatCustomerBasketTotalIsTwentyFiveDollars() {
        System.out.println("Basket total is 25$");
    }

    @TestType(name="UI")
    public static void checkBasketTotalIsZero() {
        System.out.println("Basket total is 0$");
    }

    @TestType(name="API")
    private static void checkThatCustomerOrderPlacedSuccessfully() {
        System.out.println("Order call is 200 OK");
    }

    @Test("Chore")
    public void checkChore() {
        System.out.println("Chore test");
    }
}
