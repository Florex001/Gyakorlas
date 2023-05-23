package hu.katolikuskeri.kosar2004.cli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Eredmeny> eredmenyek = new ArrayList<>();

        eredmenyek = Eredmeny.beolvas("eredmenyek.csv");

        int hazaiszam = 0;
        int idegenszam = 0;

        for (Eredmeny elem : eredmenyek){
            if (elem.getHazai().equals("Real Madrid")){
                hazaiszam++;
            } else if (elem.getIdegen().equals("Real Madrid")) {
                idegenszam++;
            }
        }

        System.out.printf("5. feladat: Real Madrid: Hazai: %d, Idegen: %d\n", hazaiszam, idegenszam);

        boolean volt = false;

        for (Eredmeny elem : eredmenyek){
            if (elem.getHazai_pont() == elem.getIdegen_pont()){
                volt = true;
            }
        }

        if (!volt){
            System.out.println("6. feladat: Volt döntetlen? nem");
        }else {
            System.out.println("6. feladat: Volt döntetlen? igen");
        }

        System.out.println("7. feladat:");
        for (Eredmeny elem : eredmenyek){
            if (elem.getIdopont().equals(LocalDate.of(2004, 11, 21))){
                System.out.printf("\t\t%s-%s (%d:%d)\n", elem.getHazai(), elem.getIdegen(), elem.getHazai_pont(), elem.getIdegen_pont());
            }
        }

        HashMap<String, Integer> stadionok = new HashMap<>();
        for (Eredmeny eredmeny : eredmenyek) {
            String stadion = eredmeny.getHelyszin();
            if (stadionok.containsKey(stadion)) {
                int jelenlegiDarab = stadionok.get(stadion);
                stadionok.put(stadion, jelenlegiDarab + 1);
            } else {
                stadionok.put(stadion, 1);
            }
        }

        System.out.println("8. feladat");
        for(String stadion : stadionok.keySet()){
            int darab = stadionok.get(stadion);
            if (darab > 20){
                System.out.println("\t\t" + stadion + ": " + darab);
            }
        }

    }
}