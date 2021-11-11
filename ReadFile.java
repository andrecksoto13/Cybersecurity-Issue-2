package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public ArrayList<String> readPassword_dictionary() throws FileNotFoundException {
        Scanner password_dictionary = new Scanner(new File("password_dictionary"));
        ArrayList list1 = new ArrayList();

        while(password_dictionary.hasNextLine()) {
            list1.add(password_dictionary.next());
        }
        password_dictionary.close();
        return list1;
    }

    public ArrayList<String> readTwoUsers() throws FileNotFoundException {
        Scanner users = new Scanner(new File("users"));
        ArrayList<String> list2 = new ArrayList();
        list2.add(users.nextLine());
        list2.add(users.nextLine());

        users.close();

        String firstUserandPw = list2.get(1);

        String[] arrOfStr = firstUserandPw.split(",", 5);

        ArrayList<String> list3 = new ArrayList<>();
        for (String a : arrOfStr)
            list3.add(a);
        return list3;
    }

    public ArrayList<String> readUsers() throws FileNotFoundException {
        Scanner users = new Scanner(new File("users"));
        ArrayList <String> list4 = new ArrayList();

        while(users.hasNextLine()) {
            list4.add(users.next());
        }
        users.close();

        String usernameandpassword;
        String[] arrOfStr;
        ArrayList<String> list5 = new ArrayList<>();

        for (int i = 0; i < list4.size(); i++ ){

            usernameandpassword =  list4.get(i);
          arrOfStr = usernameandpassword.split(",", 5);
            for (String a : arrOfStr)
                list5.add(a);
        }
        return list5;

    }

    public ArrayList<String> usersSalted() throws FileNotFoundException {
        Scanner users = new Scanner(new File("users_salted"));
        ArrayList <String> list5 = new ArrayList();

        while(users.hasNextLine()) {
            list5.add(users.next());
        }
        users.close();

        String usernameandpassword;
        String[] arrOfStr;
        ArrayList<String> list6 = new ArrayList<>();

        for (int i = 0; i < list5.size(); i++ ){

            usernameandpassword =  list5.get(i);
            arrOfStr = usernameandpassword.split(",", 5);
            for (String a : arrOfStr)
                list6.add(a);
        }
        return list6;

    }

}
