package com.company;

import com.company.comparators.burstComparator;

import java.util.ArrayList;

public class RR {

    public double RRalgorithm(ArrayList<Process> lista, int kwant){
        ArrayList<Process> processes = lista;
        ArrayList<Process> queue = new ArrayList<>();
        ArrayList<Process> doneProcesses = new ArrayList<>();
        Process current = null;
        int workingTime = 0;
        int index = 0;
        double avgWaitingTime = 0;

        while (doneProcesses.size() != processes.size()) {
            if (index < processes.size()) {
                while (processes.get(index).getArrivalTime() <= workingTime) {
                    queue.add(processes.get(index));
                    index++;
                    if (index >= processes.size()) {
                        break;
                    }
                }
            }
            if (!queue.isEmpty()){
                current = queue.get(0);
                queue.remove(0);
                int tym = workingTime - current.getArrivalTime();
                avgWaitingTime += tym;
                current.setWaitingTime(tym + current.getWaitingTime());
                current.setBurstTime(current.getBurstTime()-kwant);
                current.setArrivalTime(workingTime+kwant);

                if (current.getBurstTime() <= 0){
                    doneProcesses.add(current);
                }else {
                    queue.add(current);
                }
                current = null;
            }
            workingTime+= kwant;
        }
        return avgWaitingTime/doneProcesses.size();
    }
}
