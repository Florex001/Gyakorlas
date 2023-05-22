package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Fuvar {
    public static ArrayList<Fuvar> fuvar = new ArrayList<>();

    private int taxi_id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesi_mod;

    public Fuvar(Integer taxi_id, String indulas, Integer idotartam, String tavolsag, String viteldij, String borravalo, String fizetesi_mod) {
        this.taxi_id = taxi_id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = Double.parseDouble(tavolsag);
        this.viteldij = Double.parseDouble(viteldij);
        this.borravalo = Double.parseDouble(borravalo);
        this.fizetesi_mod = fizetesi_mod;
    }

    public Fuvar(String[] adatok) {
        this.taxi_id = Integer.parseInt(adatok[0]);
        this.indulas = adatok[1];
        this.idotartam = Integer.parseInt(adatok[2]);
        this.tavolsag = Double.parseDouble((adatok[3]));
        this.viteldij = Double.parseDouble((adatok[4]));
        this.borravalo = Double.parseDouble((adatok[5]));
        this.fizetesi_mod = adatok[6];
    }

    public static ArrayList<Fuvar> getFuvar() {
        return fuvar;
    }

    public static void setFuvar(ArrayList<Fuvar> fuvar) {
        Fuvar.fuvar = fuvar;
    }

    public int getTaxi_id() {
        return taxi_id;
    }

    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }

    public String getIndulas() {
        return indulas;
    }

    public void setIndulas(String indulas) {
        this.indulas = indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public void setIdotartam(int idotartam) {
        this.idotartam = idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public void setTavolsag(double tavolsag) {
        this.tavolsag = tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public void setViteldij(double viteldij) {
        this.viteldij = viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public void setBorravalo(double borravalo) {
        this.borravalo = borravalo;
    }

    public String getFizetesi_mod() {
        return fizetesi_mod;
    }

    public void setFizetesi_mod(String fizetesi_mod) {
        this.fizetesi_mod = fizetesi_mod;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "taxi_id=" + taxi_id +
                ", indulas='" + indulas + '\'' +
                ", idotartam=" + idotartam +
                ", tavolsag=" + tavolsag +
                ", viteldij=" + viteldij +
                ", borravalo=" + borravalo +
                ", fizetesi_mod='" + fizetesi_mod + '\'' +
                '}';
    }

    public static ArrayList<Fuvar> beolvasas(String fájl){

        try {
            Scanner olvaso = new Scanner(new File(fájl), "UTF-8");

            olvaso.nextLine();

            while (olvaso.hasNextLine()){
                String sor = olvaso.nextLine();
                String[] adatok = sor.split(";");
                Fuvar tmp = new Fuvar(adatok);
                fuvar.add(tmp);
            }

            olvaso.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        return fuvar;

    }

}
