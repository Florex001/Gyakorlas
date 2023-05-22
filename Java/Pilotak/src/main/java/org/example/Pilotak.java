package org.example;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pilotak {

    private String név;
    private String szülezési_datum;
    private String nemzetiseg;

    private Integer rajtszám;

    public Pilotak(String név, String szülezési_datum, String nemzetiseg, Integer rajtszám) {
        this.név = név;
        this.szülezési_datum = szülezési_datum;
        this.nemzetiseg = nemzetiseg;
        this.rajtszám = rajtszám;
    }

    public Pilotak(String név, String szülezési_datum, String nemzetiseg) {
        this.név = név;
        this.szülezési_datum = szülezési_datum;
        this.nemzetiseg = nemzetiseg;
    }

    public Pilotak(String[] adatok) {
        if (adatok.length == 3){
            this.név = adatok[0];
            this.szülezési_datum = adatok[1];
            this.nemzetiseg = adatok[2];
            this.rajtszám = 0;
        }else {
            this.név = adatok[0];
            this.szülezési_datum = adatok[1];
            this.nemzetiseg = adatok[2];
            this.rajtszám = Integer.parseInt(adatok[3]);
        }


    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getSzülezési_datum() {
        return szülezési_datum;
    }

    public void setSzülezési_datum(String szülezési_datum) {
        this.szülezési_datum = szülezési_datum;
    }

    public String getNemzetiseg() {
        return nemzetiseg;
    }

    public void setNemzetiseg(String nemzetiseg) {
        this.nemzetiseg = nemzetiseg;
    }

    public Integer getRajtszám() {
        return rajtszám;
    }

    public void setRajtszám(Integer rajtszám) {
        this.rajtszám = rajtszám;
    }

    @Override
    public String toString() {
        return String.format("Név: %s  Rajtszám: %d  ", this.név, this.rajtszám);
    }

    public static ArrayList<Pilotak> beolvasas(String fajl){
        ArrayList<Pilotak> pilotak = new ArrayList<Pilotak>();

        File file = new File(fajl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Pilotak tmp = new Pilotak(adatok);
                pilotak.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Fájl beolvasási figyelmeztetés.");
            error.setHeaderText(null);
            error.setContentText("A fájl beolvasásakor hiba történt, ellenőrizze a fájlt.");
            error.show();
        }

        return pilotak;
    }

}
