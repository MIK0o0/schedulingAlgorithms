package com.company;

import java.io.Serializable;

public class Process implements Serializable {
    private final static long serialVersionUID = -8420577340779607644L;
    private int number;
    private int burstTime;
    public int arrivalTime;
    private int waitingTime;

    public Process(int number, int burstTime, int arrivalTime) {
        this.number = number;
        this.burstTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.waitingTime = 0;
    }

    @Override
    public String toString() {
        return "Process{" +
                "number=" + number +
                ", burstTime=" + burstTime +
                ", arrivalTime=" + arrivalTime +
                ", waitingTime=" + waitingTime +
                '}'+"\n";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
