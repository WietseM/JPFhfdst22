package be.vdab;

import java.util.concurrent.atomic.AtomicInteger;

public class GemiddeldeRekenaar implements Runnable{
    private double array[];
    private int beginIndex;
    private int eindIndex;
    private double gemiddelde;

    public GemiddeldeRekenaar(double[] array, int beginIndex, int eindIndex) {
        this.array = array;
        this.beginIndex = beginIndex;
        this.eindIndex = eindIndex;
    }

    public double getGemiddelde() {
        return gemiddelde;
    }

    @Override
    public void run() {
        AtomicInteger totaal = new AtomicInteger();
        for(int i = beginIndex; i<eindIndex; i++){
            totaal.addAndGet((int)array[i]);
        }
        gemiddelde = totaal.intValue() / (eindIndex-beginIndex);
    }
}
