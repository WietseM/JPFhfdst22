package be.vdab;

import java.util.concurrent.atomic.AtomicInteger;

public class Stapel {
    private AtomicInteger aantalPannekoeken = new AtomicInteger();

    public void voegPannenkoekToe() {
        aantalPannekoeken.incrementAndGet();
    }

    public int getAantalPannenkoeken() {
        return aantalPannekoeken.intValue();
    }
}
