package com.company;

import java.io.FileNotFoundException;

public class ExecutionSpeed {

    public long executionSpeed() throws FileNotFoundException {
        Compare c = new Compare();
        UsernamePasswordHash up = new UsernamePasswordHash();
        final long startTime = System.currentTimeMillis();
        //Question 1
        c.compare();
        //Question 4
        up.hashPassword();

        final long endTime = System.currentTimeMillis();
        final long finaltime = endTime - startTime;

        return finaltime;
    }

}
