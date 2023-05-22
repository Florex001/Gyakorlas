package hu.katolikuskeri.cli;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Kolcsonzes> kolcsonzes;

        kolcsonzes = Kolcsonzes.beolvas("kolcsonzesek.txt");

        //TODO: 5. Feladat

        System.out.println("5. Feladat: Napi kölcsönzések száma: " + kolcsonzes.size());

        //TODO: 6. Feladat

        Scanner sc = new Scanner(System.in);

        System.out.println("6. Feladat: Kérek egy nevet: " );
        String nev = sc.nextLine();

        LocalTime kezdo;
        LocalTime vegzo;

        System.out.printf("\t\t%s kölcsönzései:\n", nev);

        for (Kolcsonzes elem : kolcsonzes){
            if (nev.equals(elem.getNev())){
                kezdo = LocalTime.of(elem.getEora(), elem.getEperc());
                vegzo = LocalTime.of(elem.getVora(), elem.getVperc());
                System.out.println("\t\t" + kezdo + "-" + vegzo);
            }
        }

        //TODO: 7. Feladat

        System.out.println("7. Feladat: Adjon meg egy időpontot óra:perc alakban: ");
        String raperc = sc.nextLine();

        String[] darabolt = raperc.split(":");

        int ora =Integer.parseInt(darabolt[0]);
        int perc =Integer.parseInt(darabolt[1]);
        LocalTime kolcsonzesbevane = LocalTime.of(ora, perc);

        System.out.println("\t\tA vízen lévő járművek:");
        for (Kolcsonzes elem : kolcsonzes){
            LocalTime van = LocalTime.of(elem.getEora(), elem.getEperc());
            LocalTime nemvan = LocalTime.of(elem.getVora(), elem.getVperc());
            if (kolcsonzesbevane.isAfter(van) && kolcsonzesbevane.isBefore(nemvan)){
                System.out.println("\t\t" + LocalTime.of(elem.getEora(), elem.getEperc()) + "-" + LocalTime.of(elem.getVora(), elem.getVperc())
                + " : " + elem.getNev());
            }
        }

        //TODO: 8. Feladat
        double kulonbseg = 0;

        for (Kolcsonzes elem : kolcsonzes){
            LocalTime kezdodik = LocalTime.of(elem.getEora(), elem.getEperc());
            LocalTime vegzodik = LocalTime.of(elem.getVora(), elem.getVperc());

            kulonbseg += Duration.between(kezdodik, vegzodik).toMinutes();

        }

        System.out.println("8. Feladat: A napi bevétel: " + kulonbseg/30*2400 + "Ft");

        //TODO: 9. Feladat

        try {
            FileWriter iro = new FileWriter("F.txt", StandardCharsets.UTF_8, false);

            for (Kolcsonzes elem : kolcsonzes){
                if (elem.getJazon() == 'F'){
                    iro.write(elem.getEora() + ":" + elem.getEperc() + "-" + elem.getVora() + ":" + elem.getVperc() + " : " + elem.getNev());
                    iro.write("\n");
                }
            }

            iro.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Todo: 10. Feladat

        ArrayList<Character> azon = new ArrayList<>();

        for (Kolcsonzes elem : kolcsonzes){
            azon.add(elem.getJazon());
        }


    }
}