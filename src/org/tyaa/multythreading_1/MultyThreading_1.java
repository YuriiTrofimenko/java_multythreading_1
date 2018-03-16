/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.multythreading_1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class MultyThreading_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        //Controller controller = new Controller();
        
        //controller.doA();
        //controller.doB();
        
        /*new Thread(() -> {
            controller.doA();
        }).start();*/
        
        /*new Thread(() -> {
            controller.doB();
        }).start();*/
        
        /*Thread t1 = new Thread(() -> {
            try {
                controller.doA();
            } catch (InterruptedException ex) {
                Logger.getLogger(MultyThreading_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        t1.setDaemon(true);
        
        t1.start();
        
        //t1.join(10);
        
        Thread.sleep(30);
        
        controller.active = false;
        t1.join();
        //t1.interrupt();
        
        System.out.println(Thread.currentThread().getName() + " finished");*/
        
        /* 2 */
        
        Data d = new Data();
        
        Controller.mDataStatic = d;
        Controller controller = new Controller(d);
        Controller controller2 = new Controller(d);
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    controller.addOne();
                    //Controller.addOneStatic();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultyThreading_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    controller2.addOne();
                    //Controller.addOneStatic();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultyThreading_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
        //t1.join();
        //t2.join();
        
        Thread.sleep(5000);
        
        System.out.println(d.counter);
    }
    
}
