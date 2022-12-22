package Patter;

import java.util.ArrayList;
import java.util.List;

import Negocio.FijarTexto;
import Negocio.RotarPalabra;
import Negocio.Sentence;
import Negocio.Sort;
import Negocio.sacarCola;

public class Master extends Thread {

    List<Slave> slaveMonitor = new ArrayList<>();
    List<Thread> killList = new ArrayList<>();

    Sentence palabra;
	sacarCola elementoCola;
	FijarTexto fijador;
	RotarPalabra rotador;
    Sort sort;

    public Master(String text) {
        this.palabra = new Sentence(text);
        this.elementoCola = new sacarCola(palabra);
		this.fijador = new FijarTexto(elementoCola);
		this.rotador = new RotarPalabra(elementoCola,fijador);
		sort = new Sort(palabra);
        System.out.println(palabra.getTexto());
        
            Slave slave1 = new Slave(rotador);
            slaveMonitor.add(slave1);
        
            Slave slave2 = new Slave(sort);
            slaveMonitor.add(slave2);
        
        
        killList.add(this);
 
        Thread shutDown = new Thread() {
            @Override
            public void run() {
                // try {
                //     killList.addAll(slaveMonitor);
                //     Collections.reverse(killList);
                //     System.out.format("%nShutting down threads...%n");
                //     for (Thread t : killList) {
                //         t.interrupt();
                //         t.join();
                //     }
                // } catch (InterruptedException ex) {
                //     ex.printStackTrace();
                //     System.out.println("Interrupted shutdown process");
                //     System.exit(1);
                // }
            }
        };
        Runtime.getRuntime().addShutdownHook(shutDown);
    }

    @Override
    public void run() {
        for (Slave s : slaveMonitor) {
            s.run();
        }

        while (true) {
            System.out.println(getName() + " - Master");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(getName() + " interrupted.");
                break;
            }
        }
        System.out.println(getName() + " exiting.");
    }
}
