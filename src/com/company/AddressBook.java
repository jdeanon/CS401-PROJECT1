package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<AddressEntry> elements = new ArrayList<>();
    public void add(AddressEntry item){
        elements.add(item);
    }
    public void list()
    {
        for (AddressEntry element : elements) {
            System.out.println(element.toString());
        }
    }
}
