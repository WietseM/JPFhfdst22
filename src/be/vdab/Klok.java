package be.vdab;

import java.math.BigInteger;
import java.time.LocalTime;

public class Klok implements Runnable{
    @Override
    public void run() {
        var verderDoen = true;
        while (verderDoen){
            System.out.println(LocalTime.now());
            /* checken op interrupted status
            if(Thread.interrupted()){
                verderDoen=false;
            }*/
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                // verderDoen = false;
                System.err.println(ex);
            }
        }
    }
}
