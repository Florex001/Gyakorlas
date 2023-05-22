package org.example;

import static org.example.Fuvar.*;

public class Main {
    public static void main(String[] args) {

        beolvasas("/home/balogh/Dokumentumok/GitRepo/linux-my-code/java/Fuvar/src/main/resources/fuvar.csv");

        System.out.printf("3. Feladat: %d fuvar\n", fuvar.size());

        int db =0;
        double bevetel = 0;
        int kartya = 0;
        int kp =0;
        int vitatott = 0;
        int ingyenes =0;
        int ismeretlen = 0;
        double merfold = 0;

        for (Fuvar fuvarok : fuvar){
            if (fuvarok.getTaxi_id() == 6185 ){
                db++;
                bevetel += fuvarok.getViteldij();
            }

            if (fuvarok.getFizetesi_mod().equals("bankkártya")){
                kartya++;
            } else if (fuvarok.getFizetesi_mod().equals("készpénz")) {
                kp++;
            }else if (fuvarok.getFizetesi_mod().equals("vitatott")){
                vitatott++;
            } else if (fuvarok.getFizetesi_mod().equals("ingyenes")) {
                ingyenes++;
            } else if (fuvarok.getFizetesi_mod().equals("ismeretlen")) {
                ismeretlen++;
            }

            merfold += fuvarok.getTavolsag();

        }

        System.out.printf("4. Feladat: %d fuvar alatt: %.2f$\n", db, bevetel);

        System.out.printf("5. Feladat: \n" +
                "\t\tbankkártya: %d fuvar\n" +
                "\t\tkészpénz: %d fuvar\n" +
                "\t\tvitatott: %d fuvar\n" +
                "\t\tingyenes: %d fuvar\n" +
                "\t\tismeretlen: %d fuvar\n", kartya, kp, vitatott, ingyenes, ismeretlen);

        double km = merfold * 1.6;

        System.out.printf("6. Feladat: %.2fkm\n", km);

    }
}

