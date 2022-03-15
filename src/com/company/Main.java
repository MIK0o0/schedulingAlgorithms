package com.company;

import com.company.comparators.arrivalComparator;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        processesGenerator generator = new processesGenerator();
        ArrayList<Process> processes;
        generator.generator(50000,10,25000);
        processes = generator.reader();

        Collections.sort(processes, new arrivalComparator());
        FCFS fcfs = new FCFS();
        System.out.println(fcfs.FCFSalgorithms(processes));

        SJF sjf = new SJF();
        System.out.println(sjf.SJFalgorithm(processes));

        SRJF srjf = new SRJF();
        System.out.println(srjf.SRJFalgorithm(processes));

    }
}
