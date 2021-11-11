package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class TwoSaltedUsers {


    public String getSaltedHash1() {
        return saltedHash1;
    }

    public void setSaltedHash1(String saltedHash1) {
        this.saltedHash1 = saltedHash1;
    }

    public String getSaltedHash2() {
        return saltedHash2;
    }

    public void setSaltedHash2(String saltedHash2) {
        this.saltedHash2 = saltedHash2;
    }

    String saltedHash1 = null;
    String saltedHash2 = null;

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    String password1;
    String password2;

    public String sameUsers() throws FileNotFoundException {

        ReadFile r = new ReadFile();


        ArrayList<String> list1 = r.readUsers();
        String usersHashpassword1 = null;
        String usersHashpassword2 = null;

        String userUsername1 = null;
        String userUsername2 = null;


        boolean endLoop = false;
        for (int i = 3; i < list1.size(); i = i + 2) {
            for (int j = i + 2; j < list1.size(); j = j + 2) {

                if (list1.get(i).equals(list1.get(j))) {
                    usersHashpassword1 = list1.get(i);
                    usersHashpassword2 = list1.get(j);

                    userUsername1 = list1.get(i - 1);
                    userUsername2 = list1.get(j - 1);

                    endLoop = true;
                    break;
                }
            }
            if (endLoop == true) {
                break;
            }
        }


        UsernamePasswordHash uph = new UsernamePasswordHash();
        HashMap<String, String> hm1 = uph.hashPassword();

         password1 = hm1.get(userUsername1);
          setPassword1(password1);
         password2 = hm1.get(userUsername2);
         setPassword1(password2);



        ArrayList<String> list2 = r.usersSalted();



        for (int i = 3; i < list2.size(); i = i + 3) {
            if (userUsername1.equals(list2.get(i))) {
                saltedHash1 = list2.get(i + 1);
                setSaltedHash1(saltedHash1);
                break;
            }
        }
            for (int j = 3; j < list2.size(); j = j + 3) {
                if (userUsername2.equals(list2.get(j))) {
                    saltedHash2 = list2.get(j + 1);
                    setSaltedHash2(saltedHash2);
                    break;
                }
            }

            return userUsername1 + " " + password1 + " " + saltedHash1 + '\n' + userUsername2 + " " + password2 + " " + saltedHash2;






    }

    public String usersSalted () throws FileNotFoundException {

        TwoSaltedUsers ts = new TwoSaltedUsers();
        SHA_256_SaltedHash sh = new SHA_256_SaltedHash();
        SHA_256_Hash hash = new SHA_256_Hash();
        ts.sameUsers();


        byte[] bytes1 = ts.getSaltedHash1().getBytes();
        byte[] bytes2 =ts.getSaltedHash1().getBytes();

        byte[] salt1 = sh.getSaltedHashSHA256(ts.getPassword1(), bytes1);
        byte[] salt2 =sh.getSaltedHashSHA256(ts.getPassword2(), bytes2);

        System.out.println("Salt 1 = " + salt1);
        System.out.println("Salt 2 = " + salt2);

        String stringsalt1 = new String(salt1);
        String stringsalt2 = new String(salt2);


        return "Salt 1 = " +  hash.getHashSHA256(stringsalt1) + "\n" + "Salt 2 = " + hash.getHashSHA256(stringsalt2);

    }


}


