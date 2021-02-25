package com.company;

import java.io.InputStream;
import java.util.Scanner;

public class Menu {

    /**
     * prompt_FirstName creates the output for the first name, telling user to enter their first name.
     * @param in
     * @return
     */

    public static String prompt_FirstName(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("First Name: ");
        return input.nextLine();
    }

    /**
     * prompt_LastName creates the output for the last name, telling user to enter their last name.
     * @param in
     * @return
     */

    public static String prompt_LastName(InputStream in) {

        Scanner input = new Scanner(in);
        System.out.println("Last Name: ");
        return input.nextLine();
    }

    /**
     * prompt_Street creates the output for the street name/address, telling user to enter their street address.
     * @param in
     * @return
     */

    public static String prompt_Street(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Street :");
        return input.nextLine();
    }

    /**
     * prompt_City creates the output for the city name, telling user to enter their city name.
     * @param in
     * @return
     */

    public static String prompt_City(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("City: ");
        return input.nextLine();
    }

    /**
     * prompt_State creates the output for the state name, telling user to enter their state name.
     * @param in
     * @return
     */

    public static String prompt_State(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("State: ");
        return input.nextLine();
    }

    /**
     * prompt_Zip creates the output for the Zip code, telling user to enter their Zip code.
     * @param in
     * @return
     */

    public static int prompt_Zip(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Zip :");
        return input.nextInt();
    }

    /**
     * prompt_Telephone creates the output for the phone number, telling user to enter their phone number.
     * @param in
     * @return
     */

    public static String prompt_Telephone(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Phone: ");
        return input.nextLine();
    }

    /**
     * prompt_Email creates the output for the email, telling user to enter their email.
     * @param in
     * @return
     */

    public static String prompt_Email(InputStream in) {
        Scanner input = new Scanner(in);
        System.out.println("Email: ");
        return input.nextLine();
    }

    /**
     * prompt_Menu  creates an output for users to choose what option they would like to choose from the menu.
     * @return
     */

    public static char promptMenu()
    {
        System.out.println("********************************");
        System.out.println("\nPlease enter your menu selection:\n");
        System.out.println("a) Loading from File");
        System.out.println("b) Addition");
        System.out.println("c) Removal");
        System.out.println("d) Find");
        System.out.println("e) Listing");
        System.out.println("f) Quit");
        System.out.println("\n*********************************");

        Scanner input = new Scanner(System.in);
        return input.nextLine().charAt(0);

    }
}
