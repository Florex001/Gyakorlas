package org.example.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.Classes.Kolcsonzes;

import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class FőAblakController implements Initializable {

    @FXML
    private ListView<Kolcsonzes> lista;

    @FXML
    private TextField elvitel;

    @FXML
    private TextField név;

    @FXML
    private ChoiceBox<Character> tipus;

    @FXML
    private TextField visszahozatal;
    @FXML
    private TextField kulonbseg;


    @FXML
    private void kivalasztas(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();
        Kolcsonzes kivalasztott = lista.getItems().get(index);

        név.setText(kivalasztott.getNév());
        tipus.setValue(kivalasztott.getJAzon());
        elvitel.setText(kivalasztott.getEÓra().getHour() + ":" + kivalasztott.getEPerc().getMinute());
        visszahozatal.setText(kivalasztott.getVÓra().getHour() + ":" + kivalasztott.getVperc().getMinute());

        LocalTime elvit = LocalTime.of(kivalasztott.getEÓra().getHour(), kivalasztott.getEPerc().getMinute());
        LocalTime vissza = LocalTime.of(kivalasztott.getVÓra().getHour(), kivalasztott.getVperc().getMinute());

        Duration idopont = Duration.between(elvit, vissza);
        long perc = idopont.toMinutes();
        long mp = idopont.toSeconds();

        kulonbseg.setPromptText(perc + " perc " + mp + " másodperc");

    }


    @FXML
    private void módositás(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();

        String pattern = "HH:mm";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        if (index >= 0){
            try {
                LocalTime elvitido = LocalTime.parse(elvitel.getText(), formatter);
                LocalTime visszaido = LocalTime.parse(visszahozatal.getText(), formatter);

                lista.getItems().get(index).setNév(név.getText());
                lista.getItems().get(index).setJAzon(tipus.getValue());
                lista.getItems().get(index).setEÓra(LocalTime.of(elvitido.getHour(), 0));
                lista.getItems().get(index).setEPerc(LocalTime.of(0,elvitido.getMinute()));
                lista.getItems().get(index).setVÓra(LocalTime.of(visszaido.getHour(),0));
                lista.getItems().get(index).setVperc(LocalTime.of(0, visszaido.getMinute()));
                lista.refresh();

                App.kolcsonzes.get(index).setNév(név.getText());
                App.kolcsonzes.get(index).setJAzon(tipus.getValue());
                App.kolcsonzes.get(index).setEÓra(LocalTime.of(elvitido.getHour(), 0));
                App.kolcsonzes.get(index).setEPerc(LocalTime.of(0,elvitido.getMinute()));
                App.kolcsonzes.get(index).setVÓra(LocalTime.of(visszaido.getHour(),0));
                App.kolcsonzes.get(index).setVperc(LocalTime.of(0, visszaido.getMinute()));

                LocalTime elvit = LocalTime.of(elvitido.getHour(), elvitido.getMinute());
                LocalTime vissza = LocalTime.of(visszaido.getHour(), visszaido.getMinute());

                Duration idopont = Duration.between(elvit, vissza);
                long perc = idopont.toMinutes();
                long mp = idopont.toSeconds();

                kulonbseg.setPromptText(perc + " perc " + mp + " másodperc");


            }catch (DateTimeParseException e){
                Alert hiba = new  Alert(Alert.AlertType.WARNING);
                hiba.setTitle("Hibás idő formátum.");
                hiba.setHeaderText(null);
                hiba.setContentText("Az időt így adja meg: 06:12 vagy 14:06.");
                hiba.show();
            }




        }else {
            Alert hiba = new  Alert(Alert.AlertType.WARNING);
            hiba.setTitle("Nincs kiválasztott elem a listából.");
            hiba.setHeaderText(null);
            hiba.setContentText("Nem választott ki elemet a listából, kérem válasszon egyet.");
            hiba.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipus.getItems().add('A');
        tipus.getItems().add('B');
        tipus.getItems().add('C');
        tipus.getItems().add('D');
        tipus.getItems().add('E');
        tipus.getItems().add('F');
        tipus.getItems().add('G');

        for (Kolcsonzes elem : App.kolcsonzes){
            lista.getItems().add(elem);
        }
    }

}
