package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException {
        ReadFile r = new ReadFile();
        Compare c = new Compare();
        ExecutionSpeed es = new ExecutionSpeed();
        UsernamePasswordHash h = new UsernamePasswordHash();
        TwoSaltedUsers two = new TwoSaltedUsers();

        //Question 1
        System.out.println(c.compare());
        //FOR SPEED GO TO EXECUTION SPEED AN COMMENT AND UNCOMMENT CODE NEEDED
        System.out.println(es.executionSpeed());
        //Question 4
        //System.out.println(h.hashPassword());
        //FOR SPEED GO TO EXECUTION SPEED AN COMMENT AND UNCOMMENT CODE NEEDED
        //System.out.println(es.executionSpeed());
        //Question 5
        // System.out.println(two.sameUsers());
        //Question 6
        // System.out.println(two.usersSalted());


    }
}
