package com.company.comparators;

import com.company.Process;

import java.util.Comparator;

public class arrivalComparator implements Comparator<Process> {
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
}
