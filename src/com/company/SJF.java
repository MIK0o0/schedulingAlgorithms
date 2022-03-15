package com.company;
import com.company.comparators.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SJF {
    public double SJFalgorithm(ArrayList<Process> lista){
        burstComparator burstComparator = new burstComparator();
        ArrayList<Process> processes = lista;
        ArrayList<Process> queue = new ArrayList<>();
        ArrayList<Process> doneProcesses = new ArrayList<>();
        int workingTime = 0;
        int index = 0;
        double avgWaitingTime = 0;
        do {
            if (index < processes.size()){
                while (processes.get(index).getArrivalTime() <= workingTime || queue.isEmpty()) {

                    if (processes.get(index).getArrivalTime() > workingTime){
                        workingTime+= (processes.get(index).getArrivalTime() - workingTime);
                    }


                    queue.add(processes.get(index));
                    index++;
                    if (index >= processes.size()) {
                        break;
                    }

                }
        }
            Collections.sort(queue, burstComparator);
            int tym = workingTime - queue.get(0).getArrivalTime();
            avgWaitingTime += tym;
            queue.get(0).setWaitingTime(tym);
            workingTime += queue.get(0).getBurstTime();
            doneProcesses.add(queue.get(0));
            queue.remove(0);
        }while (doneProcesses.size() != processes.size());
        return avgWaitingTime/doneProcesses.size();
    }
    //1468181.62782
}
