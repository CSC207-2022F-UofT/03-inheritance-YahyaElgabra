/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

import java.sql.Array;
import java.util.ArrayList;

public abstract class Bag {
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[capacity];
    }

    public String getColor() {
        return color;
    }

    public int getNumberOfContents() {
        return numberOfContents;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean addItem(String item) {
        if(numberOfContents < capacity) {
            this.contents[numberOfContents] = item;
            this.numberOfContents += 1;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * If there are no items in this Bag, return null.
     *
     * @return
     */
    public String popItem() {
        if (numberOfContents == 0){
            return null;
        }
        numberOfContents -= 1;
        String lastItem = this.contents[numberOfContents];
        this.contents[numberOfContents] = null;
        return lastItem;
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        String[] tempList = new String[capacity + n];
        for(int i = 0; i < capacity; i++) {
            tempList[i] = contents[i];
        }
        this.capacity += n;
        this.contents = tempList;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}