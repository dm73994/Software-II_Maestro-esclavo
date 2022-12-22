package Patter;

import java.lang.reflect.Method;
import java.util.function.Function;

import Negocio.RotarPalabra;
import Negocio.Sort;

public class Slave extends Thread {
    RotarPalabra actionRot = null;
    Sort actionSor = null;

    public Slave( RotarPalabra obj) {
        this.actionRot = obj;
    }

    public Slave( Sort obj) {
        this.actionSor = obj;
    }

    @Override
    public void run() {
        System.out.println("actionObj");
        if(actionRot != null){
            while (actionRot.getTerminar() == 0) {
                try {
                    System.out.println("ROTACIONES\n");
                    actionRot.ejecutar(MAX_PRIORITY);
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    System.out.println(getName() + " interrupted.");
                    break;
                }
            }
        }else if(actionSor != null){
            while (actionSor.getTerminar() == 0) {
                try {
                    System.out.println("BUBBLE SORT\n");
                    System.out.println(actionSor.ejecutar());
                    System.out.println("QUICK SORT\n");
                    System.out.println(actionSor.ejecutar(null));
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    System.out.println(getName() + " interrupted.");
                    break;
                }
            }
        }

    }

}
