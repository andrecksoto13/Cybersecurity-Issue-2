package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class UsernamePasswordHash {

    public HashMap<String, String> hashPassword() throws FileNotFoundException {

        ReadFile r = new ReadFile();
        SHA_256_Hash hash = new SHA_256_Hash();

        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();



        ArrayList<String> list1 = r.readPassword_dictionary();
        for (int i = 0; i < list1.size(); i++) {
            String hashpasswords = hash.getHashSHA256(list1.get(i));
            String passwords = list1.get(i);
            hm1.put(hashpasswords,passwords);
        }

        ArrayList <String> list2  = r.readUsers();

        for (int i = 2; i < list2.size(); i = i + 2 ) {

                String username = list2.get(i);
                String hashpassword = list2.get(i + 1);
                String password = hm1.get(hashpassword);
                hm2.put(username, password);

        }
            return hm2;
    }
}
