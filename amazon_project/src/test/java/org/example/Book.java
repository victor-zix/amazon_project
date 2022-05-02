package org.example;

public class Book {
    String name;
    String author1;
    String author2;
    String author3;
    String author4;
    String author5;
    String priceWhole;
    String priceFraction;
    boolean badge;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public void setAuthor3(String author3) {
        this.author3 = author3;
    }

    public void setAuthor4(String author4) {
        this.author4 = author4;
    }

    public void setAuthor5(String author5) {
        this.author5 = author5;
    }

    public void setPriceWhole(String priceWhole) {
        this.priceWhole = priceWhole;
    }

    public void setPriceFraction(String priceFraction) {
        this.priceFraction = priceFraction;
    }

    public void setBestSellerBadge(boolean badge) {
        this.badge = badge;
        System.out.println("Bestseller badge is found: " + badge);
    }

    public String getName() {
        return name;
    }

    public String getAuthor1() {
        return author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public String getAuthor4() {
        return author4;
    }

    public String getAuthor5() {
        return author5;
    }

    public String getPriceWhole() {
        return priceWhole;
    }

    public String getPriceFraction() {
        return priceFraction;
    }

    public boolean getBadge() {
        return badge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;

        if (getName() != book.getName()) {
            return false;
        }
        if (getAuthor1() != book.getAuthor1()) {
            return false;
        }
        if (getPriceWhole() != book.getPriceWhole()) {
            return false;
        }
        if (getPriceFraction() != book.getPriceFraction()) {
            return false;
        }
        if (getBadge() != book.getBadge()) {
            return false;
        }
        return false;
    }

    /*
    @Override
    public String toString() {
        return name;
    }
    */

}
