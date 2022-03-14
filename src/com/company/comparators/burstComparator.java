package com.company.comparators;

import com.company.Process;

import java.util.Comparator;

public class burstComparator implements Comparator<Process>{
    @Override
    public int compare(Process p1, Process p2) {
        int tym = p1.getBurstTime() - p2.getBurstTime();
        if (tym == 0){
            return 0;
        }else if (tym > 0){
            return 1;
        }else {
            return -1;
        }
    }
}
