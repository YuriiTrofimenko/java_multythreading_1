/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.multythreading_1;

/**
 *
 * @author student
 */
public class Controller {
    
    public volatile boolean active = true;
    
    public Data mData;
    public static Data mDataStatic;
    
    public Controller(){}
    public Controller(Data _data){
    
        mData = _data;
    }
    
    public void doA() throws InterruptedException{
        
        for (int i = 0; i < 1000; i++) {
            
            if (active) {
                System.out.println("Start A");
                System.out.println("A" + i);
                System.out.println("Finish A");
            //Thread.sleep(1);
            } else {
                System.out.println(Thread.currentThread().getName() + " finished");
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void doB(){
    
        for (int i = 0; i < 10; i++) {
            System.out.println("Start B");
            System.out.println("B" + i);
            System.out.println("Finish B");
        }
    }
    
    public void addOne() throws InterruptedException{
    
        synchronized(mData){
            int x = mData.counter;
            Thread.sleep(10);
            x++;
            Thread.sleep(10);
            mData.counter = x;
        }
    }
    
    synchronized public static void addOneStatic() throws InterruptedException{
    
        int x = mDataStatic.counter;
        Thread.sleep(10);
        x++;
        Thread.sleep(10);
        mDataStatic.counter = x;
    }
}
