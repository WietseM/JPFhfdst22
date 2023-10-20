package be.vdab;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        double[] array = new double[1000000];
        double[] array2 = new double[]{1,2,3,4,5,6,7,8,9,10};
        Random rand = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt();
        }

        var gemiddelde1 = new GemiddeldeRekenaar(array2, 0, array2.length/2);
        var gemiddelde2 = new GemiddeldeRekenaar(array2, array2.length/2, array2.length);
        var thread1 = new Thread(gemiddelde1);
        var thread2 = new Thread(gemiddelde2);

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex){
            System.err.println(ex);
        }

        System.out.println("Gemiddelde: " + (gemiddelde1.getGemiddelde() + gemiddelde2.getGemiddelde())/2);

    }
}
