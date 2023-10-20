package be.vdab;

public class InsectenMain {
    public static void main(String[] args) {
        var lezer1 = new Insectenlezer("insecten1.csv", System.out);
        var lezer2 = new Insectenlezer("insecten2.csv", System.err);

        var thread1 = new Thread(lezer1);
        var thread2 = new Thread(lezer2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex){
            System.err.println(ex);
        }

        System.out.println(lezer1.getAantalRegels() + lezer2.getAantalRegels() + " regels");

    }
}
