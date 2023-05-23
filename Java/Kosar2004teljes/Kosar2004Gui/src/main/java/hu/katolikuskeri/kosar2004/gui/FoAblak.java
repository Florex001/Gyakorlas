package hu.katolikuskeri.kosar2004.gui;

import java.net.URL;
import java.util.ResourceBundle;

import hu.katolikuskeri.kosar2004.cli.Eredmeny;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static hu.katolikuskeri.kosar2004.gui.App.eredmenyek;

public class FoAblak implements Initializable {

    @FXML
    private ListView<Eredmeny> lista;

    @FXML
    private TextField hazai;

    @FXML
    private TextField hazaipont;

    @FXML
    private TextField helyszin;

    @FXML
    private TextField idegen;

    @FXML
    private TextField idegenpont;

    @FXML
    private TextField idopont;

    @FXML
    void kivalaszt(MouseEvent event) {

        int index = lista.getSelectionModel().getSelectedIndex();
        Eredmeny kivalasztott = lista.getItems().get(index);

        hazai.setText(kivalasztott.getHazai());
        idegen.setText(kivalasztott.getIdegen());
        hazaipont.setText(String.valueOf(kivalasztott.getHazai_pont()));
        idegenpont.setText(String.valueOf(kivalasztott.getIdegen_pont()));
        helyszin.setText(kivalasztott.getHelyszin());
        idopont.setText(String.valueOf(kivalasztott.getIdopont()));
    }

    @FXML
    void modositas(MouseEvent event) {

        int index = lista.getSelectionModel().getSelectedIndex();

        if (index >= 0){
            Eredmeny kivalasztott = lista.getItems().get(index);

            kivalasztott.setHelyszin(helyszin.getText());

            lista.refresh();

        }else {
            Alert hiba = new Alert(Alert.AlertType.ERROR);
            hiba.setTitle("Nincs kiválasztott elem.");
            hiba.setContentText("Vállaszon ki egy elemet a listából.");
            hiba.show();
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Eredmeny elem : App.eredmenyek){
            lista.getItems().add(elem);
        }
    }
}
