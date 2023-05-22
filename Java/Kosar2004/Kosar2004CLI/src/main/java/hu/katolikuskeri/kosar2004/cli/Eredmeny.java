package hu.katolikuskeri.kosar2004.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Eredmeny {

    private String hazai;
    private String idegen;
    private int hazai_pontok;
    private int idegen_pontok;
    private String helyszin;
    private LocalDate idopont;

    public Eredmeny(String hazai, String idegen, int hazai_pontok, int idegen_pontok, String helyszin, LocalDate idopont) {
        this.hazai = hazai;
        this.idegen = idegen;
        this.hazai_pontok = hazai_pontok;
        this.idegen_pontok = idegen_pontok;
        this.helyszin = helyszin;
        this.idopont = idopont;
    }

    public Eredmeny(String[] adatok) {
        this(adatok[0],
             adatok[1],
             Integer.parseInt(adatok[2]),
             Integer.parseInt(adatok[3]),
             adatok[4],
                LocalDate.parse(adatok[5])

        );
    }

    public String getHazai() {
        return hazai;
    }

    public String getIdegen() {
        return idegen;
    }

    public int getHazai_pontok() {
        return hazai_pontok;
    }

    public int getIdegen_pontok() {
        return idegen_pontok;
    }

    public String getHelyszin() {
        return helyszin;
    }

    public LocalDate getIdopont() {
        return idopont;
    }

    public void setHelyszin(String helyszin) {
        this.helyszin = helyszin;
    }

    public static ArrayList<Eredmeny> beolvas(String fajl){
        ArrayList<Eredmeny> eredmenyek = new ArrayList<>();

        File file = new File(fajl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Eredmeny tmp = new Eredmeny(adatok);
                eredmenyek.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return eredmenyek;
    }


}
