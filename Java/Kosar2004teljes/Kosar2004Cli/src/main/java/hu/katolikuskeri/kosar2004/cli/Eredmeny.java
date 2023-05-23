package hu.katolikuskeri.kosar2004.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Eredmeny {

    private String hazai;
    private String idegen;
    private int hazai_pont;
    private int idegen_pont;
    private String helyszin;
    private LocalDate idopont;

    public Eredmeny(String hazai, String idegen, int hazai_pont, int idegen_pont, String helyszin, LocalDate idopont) {
        this.hazai = hazai;
        this.idegen = idegen;
        this.hazai_pont = hazai_pont;
        this.idegen_pont = idegen_pont;
        this.helyszin = helyszin;
        this.idopont = idopont;
    }

    public Eredmeny(String[] adatok) {
        this(
                adatok[0],
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

    public int getHazai_pont() {
        return hazai_pont;
    }

    public int getIdegen_pont() {
        return idegen_pont;
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

    @Override
    public String toString() {
        return helyszin + "(" + idopont + ")";
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
