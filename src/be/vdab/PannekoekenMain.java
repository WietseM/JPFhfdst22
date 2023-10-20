package be.vdab;

public class PannekoekenMain {
    public static void main(String[] args) {
        var stapel = new Stapel();
        var thread1 = new Thread(new Kok(stapel));
        var thread2 = new Thread(new Kok(stapel));
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        System.out.println(stapel.getAantalPannenkoeken());


    }
}
