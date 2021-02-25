package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Joshua Deanon
 * @since February 2021
 *
 * AddressBookApplication calls the methods from the menu depending on what the user selects
 */

public class AddressBookApplication  {

    private static AddressBook ab = new AddressBook();

    public static void main(String[] args) throws IOException {

        char option;

        option = Menu.promptMenu();

        while(option != 'f') // if the user doesn't choose f
        {
            switch(option)
            {
                case 'a':
                    loadFromFile(); // loading data from file option, or option a
                    break;

                case 'b':
                    initAddressBookExercise(); // adding data, or option b
                    break;

                case 'c':
                    removal(); // removing data, or option c
                    break;

                case 'd':
                    findLastName(); // finding data through the last name, or option d
                    break;

                case 'e':
                    ab.list(); // displays who is on the list, option e
                    break;

                default:
                    System.out.println("Invalid Entry"); // anything other than a-f is invalid
                    break;
            }

            option = Menu.promptMenu();
            if(option == 'f')
            {
                System.out.println("Goodbye!"); // Exits the application
            }
        }

    }

    /**
     * init() reads and parses the data from the AddressEntry.java file until the end of file.
     * @param filename
     * @throws IOException
     */

    public static void init(String filename) throws IOException
    {
        FileReader file_reader = new FileReader(filename);
        BufferedReader buffered_reader = new BufferedReader(file_reader);
        String Current_line, f_name,l_name,street,city,state,telephone,email;
        int zip;

        while ((Current_line = buffered_reader.readLine()) != null)
        {
            f_name = Current_line;
            Current_line = buffered_reader.readLine();
            l_name = Current_line;
            Current_line =buffered_reader.readLine();
            street = Current_line;
            Current_line = buffered_reader.readLine();
            city = Current_line;
            Current_line = buffered_reader.readLine();
            state = Current_line;
            Current_line = buffered_reader.readLine();
            zip = Integer.valueOf(Current_line);
            Current_line =buffered_reader.readLine();
            email= Current_line;
            Current_line = buffered_reader.readLine();
            telephone = Current_line;
            AddressEntry elements = new AddressEntry(f_name,l_name,street,city,state,zip,email,telephone);
            ab.add(elements);
        }


    }

    /**
     * loadFromFile() asks the user to enter a file name, which is then read and gets the elements through the init() method.
     *
     * @throws IOException
     */

    public static void loadFromFile() throws IOException {
        System.out.println("Enter File Name: ");
        Scanner fileNameInput = new Scanner(System.in);
        init(fileNameInput.nextLine()); // init method which takes file elements

        System.out.print("\nRead in new address, successfully loaded\n");

    }

    /**
     * removal() reads the user's input last name in the file and then looks for the last name
     *  in the file by looking at the elements in the list.
     * If the user enters "y"(yes), then the last name is removed.
     * If the user enters "n"(no), then the user will be return to the menu.
     */

    public static void removal()
    {
        System.out.println("Enter last name for removal: ");
        Scanner input = new Scanner(System.in);
        ArrayList<AddressEntry> results= ab.find(input.nextLine());

        for(int i =0; i< results.size();i++)
        {
            System.out.println(i+1);
            System.out.println(results.get(i).toString());
        }

        System.out.print("The Following entries were found in the address book, select number of entry you wish to remove: ");
        int option =  input.nextInt();

        System.out.print("Hit y to remove the following entry or n to return to main menu:");
        System.out.println(results.get(option-1).toString());

        System.out.print(">");
        char remove;
        remove = input.next().charAt(0);

        if(remove =='y') // if user chooses y, then remove
        {
            ab.remove(results.get(option-1));
            System.out.print("\nYou have successfully removed the contact\n");

        }

        else if(remove == 'n') // if user chooses n, then return
        {
            return;
        }


    }

    /**
     * findLastName() method reads user's input for last name and looks for the last name
     * It also displays those who have similar last names.
     */

    public static void findLastName()
    {
        System.out.println("Enter in all or the beginning of the Last Name of the contact you wish to find: ");
        Scanner input = new Scanner(System.in);
        String lastName = input.nextLine();
        ArrayList <AddressEntry> results = ab.find(lastName);

        System.out.print("The following entries were found in the address book for a last name starting with: " );
        System.out.println(results.toString());

        for(int i =0; i< results.size();i++)
        {
            System.out.println(i+1);
            System.out.println(results.get(i).toString());
        }

    }

    /**
     * initAddressBookExercise() recieves the user's input by using the keyboard.
     * @throws IOException
     */

    public static void initAddressBookExercise() throws IOException {

        // This gets the input from the user
        Scanner keyboard = new Scanner(System.in);
        AddressEntry item2 = new AddressEntry();
        item2.setFirstName(Menu.prompt_FirstName(System.in));
        item2.setLastName(Menu.prompt_LastName(System.in));
        item2.setStreet(Menu.prompt_Street(System.in));
        item2.setCity(Menu.prompt_City(System.in));
        item2.setState(Menu.prompt_State(System.in));
        item2.setZip(Menu.prompt_Zip(System.in));
        item2.setPhone(Menu.prompt_Telephone(System.in));
        item2.setEmail(Menu.prompt_Email(System.in));
        ab.add(item2);

        System.out.println("\nThank you! The following contact has been added to your address book: ");
        System.out.println(item2.getFirstName());
        System.out.println(item2.getLastName());
        System.out.println(item2.getStreet());
        System.out.println(item2.getCity());
        System.out.println(item2.getState());
        System.out.println(item2.getZip());
        System.out.println(item2.getPhone());
        System.out.println(item2.getEmail());


    }

}


