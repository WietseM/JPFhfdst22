package be.vdab;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class jpfhfdst22 {
    public static void main(String[] args) {
        try {
            System.setErr(new PrintStream("/data/fouten.txt"));
            System.err.println("Deze error komt in de file fouten.txt terecht");
            System.setOut(new PrintStream("/data/output.txt"));
            System.out.println("Gay");

        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }

    }
}
