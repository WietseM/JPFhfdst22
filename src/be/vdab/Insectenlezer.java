package be.vdab;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class Insectenlezer implements Runnable{
    private static final BigDecimal MAXIMUM = BigDecimal.valueOf(3);
    private final Path pad; // zal naar insecten1.csv of insecten2.csv wijzen
    private final PrintStream stream;  // staat voor System.out of System.err
    private int aantalRegels;

    public Insectenlezer(String bestand, PrintStream stream) {
        this.pad = Path.of(bestand);
        this.stream = stream;
    }

    @Override
    public void run() {
        try (var reader = Files.newBufferedReader(pad)) {
            for (String regel; (regel = reader.readLine()) != null;){
                var onderdelen = regel.split(";");
                var prijs = new BigDecimal(onderdelen[1]);
                if (prijs.compareTo(MAXIMUM) <= 0) {
                    ++aantalRegels;
                }
            }
        } catch (IOException ex){
            System.err.println(ex);
        }
    }

    public int getAantalRegels() {
        return aantalRegels;
    }
}
