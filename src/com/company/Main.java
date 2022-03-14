package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        processesGenerator generator = new processesGenerator();
        ArrayList<Process> processes;
        //generator.generator(100000,10,500000);
        processes = generator.reader();
        FCFS fcfs = new FCFS();
        System.out.println(fcfs.FCFSalgorithms(processes));

    }
}
