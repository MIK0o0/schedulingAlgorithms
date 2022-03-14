package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class FCFS {
    public static Comparator<Process> arrivalCoparator = new Comparator<Process>() {
        @Override
        public int compare(Process p1, Process p2) {
            int tym = p1.getArrivalTime() - p2.getArrivalTime();
            if (tym == 0){
                return 0;
            }else if (tym > 0){
                return 1;
            }else {
                return -1;
            }
        }
    };
    public double FCFSalgorithms(ArrayList<Process> list){

        ArrayList<Process> processes = list;
        Collections.sort(processes,arrivalCoparator);

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
