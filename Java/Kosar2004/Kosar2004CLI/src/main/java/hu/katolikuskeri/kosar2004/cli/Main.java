package hu.katolikuskeri.kosar2004.cli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Eredmeny> eredmenys = Eredmeny.beolvas("eredmenyek.csv");

        int hazai = 0;
        int idegen = 0;

        for (Eredmeny elem : eredmenys){
            if (elem.getHazai().equals("Real Madrid")){
                hazai++;
            }
            if (elem.getIdegen().equals("Real Madrid")){
                idegen++;
            }
        }

        System.out.printf("5. feladat: Real Madrid: Hazai: %d, Idegen: %d\n", hazai, idegen);

        boolean egyenlo = false;

        for (Eredmeny elem : eredmenys){
            if (elem.getHazai_pontok() == elem.getIdegen_pontok()){
                egyenlo = true;
            }
        }

        if (!egyenlo){
            System.out.println("6. feladat: Volt döntetlen? nem");
        }else{
            System.out.println("6. feladat: Volt egyenlő? igen");
        }

        System.out.println("7. feladat:");
        for (Eredmeny elem : eredmenys){
            if (elem.getIdopont().equals(LocalDate.of(2004, 11, 21))){
                System.out.println("\t\t" + elem.getHazai() + " - " + elem.getIdegen() + " " + "(" + elem.getHazai_pontok() + ":" + elem.getIdegen_pontok() + ")");
            }
        }

        HashMap<String, Integer> stadionok = new HashMap<>();
        for (Eredmeny eredmeny : eredmenys) {
            String stadion = eredmeny.getHelyszin();
            if (stadionok.containsKey(stadion)) {
                int jelenlegiDarab = stadionok.get(stadion);
                stadionok.put(stadion, jelenlegiDarab + 1);
            } else {
                stadionok.put(stadion, 1);
            }
        }

        System.out.println("8.feladat:");
        for (String stadion : stadionok.keySet()) {
            int darab = stadionok.get(stadion);
            if (darab > 20) {
                System.out.println("\t\t" + stadion + ": " + darab);
            }
        }

    }
}