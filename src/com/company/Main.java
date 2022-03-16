package com.company;

import com.company.comparators.arrivalComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        processesGenerator generator = new processesGenerator();
        ArrayList<Process> processes;

        int n = 10000;
        int maxBurstTime = 100;
        int maxArrivalTime = 15000;
        generator.generator(n,maxBurstTime,maxArrivalTime);
        processes = generator.reader();
        String input = "Input for generator: n = "+ n + " maxBurstTime = " + maxBurstTime + " maxArrivalTime = " + maxArrivalTime;
        System.out.println(input);

        Collections.sort(processes, new arrivalComparator());
        FCFS fcfs = new FCFS();
        String fcfsString = "AWT fo FCFS: " + fcfs.FCFSalgorithms(processes);
        System.out.println(fcfsString);

        SJF sjf = new SJF();
        String sjfString = "AWT fo SJF: " + sjf.SJFalgorithm(processes);
        System.out.println(sjfString);

        SRJF srjf = new SRJF();
        String srjfString = "AWT fo SRJF: " + srjf.SRJFalgorithm(processes);
        System.out.println(srjfString);

        RR rr = new RR();
        int kwant = 100;
        String rrString = "AWT fo RR: " + rr.RRalgorithm(processes,kwant) + " for " + kwant + " kwantu";
        System.out.println(rrString);

        Zapis zapis = new Zapis();
        zapis.zapis(input,fcfsString,sjfString,srjfString,rrString);

    }
}
