package org.example.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kolcsonzes {

    private String név;
    private Character JAzon;
    private LocalTime EÓra;
    private LocalTime EPerc;
    private LocalTime VÓra;
    private LocalTime Vperc;

    public Kolcsonzes(String név, Character JAzon, LocalTime EÓra, LocalTime EPerc, LocalTime VÓra, LocalTime vperc) {
        this.név = név;
        this.JAzon = JAzon;
        this.EÓra = EÓra;
        this.EPerc = EPerc;
        this.VÓra = VÓra;
        this.Vperc = vperc;
    }

    public String getNév() {
        return név;
    }

    public Character getJAzon() {
        return JAzon;
    }

    public LocalTime getEÓra() {
        return EÓra;
    }

    public LocalTime getEPerc() {
        return EPerc;
    }

    public LocalTime getVÓra() {
        return VÓra;
    }

    public LocalTime getVperc() {
        return Vperc;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public void setJAzon(Character JAzon) {
        this.JAzon = JAzon;
    }

    public void setEÓra(LocalTime EÓra) {
        this.EÓra = EÓra;
    }

    public void setEPerc(LocalTime EPerc) {
        this.EPerc = EPerc;
    }

    public void setVÓra(LocalTime VÓra) {
        this.VÓra = VÓra;
    }

    public void setVperc(LocalTime vperc) {
        Vperc = vperc;
    }

    public Kolcsonzes(String[] adatok) {
        this(
                adatok[0],
                adatok[1].charAt(0),
                LocalTime.of(Integer.parseInt(adatok[2]), 00),
                LocalTime.of(00, Integer.parseInt(adatok[3])),
                LocalTime.of(Integer.parseInt(adatok[4]), 00),
                LocalTime.of(00, Integer.parseInt(adatok[5]))
        );
    }

    @Override
    public String toString() {
        return String.format("%s (%02d:%02d)", this.név, this.EÓra.getHour(), this.EPerc.getMinute());
    }

    public static ArrayList<Kolcsonzes> beolvas(String fájl){

        ArrayList<Kolcsonzes> kolcsonzes = new ArrayList<Kolcsonzes>();

        File file = new File(fájl);

        try {
            Scanner olvaso = new Scanner(file, "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Kolcsonzes tmp = new Kolcsonzes(adatok);
                kolcsonzes.add(tmp);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return kolcsonzes;
    }


}
