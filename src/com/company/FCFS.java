package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import com.company.comparators.arrivalComparator;

public class FCFS {


    public double FCFSalgorithms(ArrayList<Process> list){

        ArrayList<Process> processes = list;
        //Collections.sort(processes,new arrivalComparator());

        double avgWaitingTime = 0;
        int workingTime = 0;
        for(int i = 0;i<list.size();i++){
            if(list.get(i).getArrivalTime()>workingTime){
                workingTime+=(list.get(i).getArrivalTime()-workingTime);
            }
            int tym = workingTime-list.get(i).getArrivalTime();
            list.get(i).setWaitingTime(tym);
            workingTime += list.get(i).getBurstTime();
            avgWaitingTime += tym;
        }
        return avgWaitingTime/list.size();
    }
}
