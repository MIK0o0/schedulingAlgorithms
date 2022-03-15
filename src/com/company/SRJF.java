package com.company;

import com.company.comparators.burstComparator;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;

public class SRJF {

    public double SRJFalgorithm(ArrayList<Process> lista){
        burstComparator burstComparator = new burstComparator();
        ArrayList<Process> processes = lista;
        ArrayList<Process> queue = new ArrayList<>();
        ArrayList<Process> doneProcesses = new ArrayList<>();
        Process current = null;
        int workingTime = 0;
        int index = 0;
        double avgWaitingTime = 0;

        while (doneProcesses.size() != processes.size()){
            if (index < processes.size()){
                while (processes.get(index).getArrivalTime() <= workingTime) {
                    queue.add(processes.get(index));
                    index++;
                    if (index >= processes.size()) {
                        break;
                    }
                }
            }
            if (current!=null){
                current.setBurstTime(current.getBurstTime() - 1);
                if (current.getBurstTime() == 0){
                    doneProcesses.add(current);
                    current = null;
                }
            }
            //System.out.println(queue.size());
            //System.out.println(workingTime+" working");
            Collections.sort(queue, burstComparator);
            int pom = 0;
            if (!queue.isEmpty() && current!=null) {
                while (queue.get(pom).getBurstTime() < current.getBurstTime()) {
                    pom++;
                    if (pom>=queue.size()){
                        break;
                    }
                }
                if (pom != 0){
                    current.setArrivalTime(workingTime);
                    queue.add(current);
                    current = queue.get(pom-1);
                    queue.remove(pom-1);
                    int tym = workingTime - current.getArrivalTime();
                    avgWaitingTime += tym;
                    current.setWaitingTime(tym + current.getWaitingTime());
                }
            }else if (!queue.isEmpty() && current == null){
                current = queue.get(0);
                queue.remove(0);
                int tym = workingTime - current.getArrivalTime();
                avgWaitingTime += tym;
                current.setWaitingTime(tym + current.getWaitingTime());
            }

            workingTime++;
            //System.out.println(doneProcesses.size());
            //System.out.println(current);
    }

        return avgWaitingTime/doneProcesses.size();
    }
}
