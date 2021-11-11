package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class Compare {

    public String compare() throws FileNotFoundException {
        ReadFile r = new ReadFile();
        SHA_256_Hash hash = new SHA_256_Hash();

        String save = null;
        String user1 = r.readTwoUsers().get(1);
        ArrayList <String> list1 = r.readPassword_dictionary();


        for (int i = 0; i < list1.size(); i++) {
           String h = hash.getHashSHA256(list1.get(i));
            if (user1.equals(h)) {
                save = list1.get(i);
                break;
            }
        }
        return save;
}

}
