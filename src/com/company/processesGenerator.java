package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class processesGenerator {

    public void writeProcesses(ArrayList<Process> list){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("processes.ser"))){
            writer.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void generator(int n,int burstTime,int activeTime){
        ArrayList<Process> processesList = new ArrayList<>();
        Random random = new Random();
        int origin = 0;
        for(int i = 0;i<n;i++){
            processesList.add(new Process(i, random.nextInt(1,burstTime+1), random.nextInt(origin,activeTime)));
            if (i%1000==0){
                origin+=5;
            }
        }
        writeProcesses(processesList);
    }
    public ArrayList<Process> reader(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("processes.ser"))){
            Object ob = reader.readObject();
            reader.close();
            return (ArrayList) ob;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
