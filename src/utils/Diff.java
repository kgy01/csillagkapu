package utils;

import java.io.*;
import java.util.List;


public class Diff
{
    public static void main(String[] args) {
        if (args.length == 2) {
            File f1 = new File(args[0]);
            File f2 = new File(args[1]);
            try {
                LineNumberReader reader1 = new LineNumberReader(new FileReader(f1));
                LineNumberReader reader2 = new LineNumberReader(new FileReader(f2));
                while (reader1.ready() && reader2.ready()){
                    String lineA = reader1.readLine();
                    String lineB = reader2.readLine();
                    if (!lineA.equals(lineB)) {
                        System.out.print(reader1.getLineNumber());
                        System.out.println(".sor");
                        System.out.println("kapott kimenet: "+lineA);
                        System.out.println("referencia kimenet: "+lineB);
                    }
                }
                if (!reader1.ready() && reader2.ready()) {
                    System.out.println("A kapott kimenet kevesebb sort tartalmaz, mint a referencia kimenet!");
                }
                if (reader1.ready() && !reader2.ready()) {
                    System.out.println("A kapott kimenet kevesebb több tartalmaz, mint a referencia kimenet!");
                }
            } catch (FileNotFoundException e) {
                System.out.println("A megadott fájlok valamelyike nem létezik!");
            } catch (IOException e) {
                System.out.println("Olvasási hiba a fájlok olvasása közben!");
            }

        } else {
            System.out.println("Túl kevés paraméter! Az indításhoz meg kell adni a két összehasonlítandó fájlt!");
        }
    }
}