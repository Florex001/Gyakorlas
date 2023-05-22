package org.example;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {

    @FXML
    private ListView<Pilotak> lista;

    @FXML
    private TextField nemzetiseg_tf;

    @FXML
    private TextField nev_tf;

    @FXML
    private TextField rajt_tf;

    @FXML
    private TextField szül_datum_tf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Pilotak elem : App.pilotak){
            lista.getItems().add( elem );
        }
    }

    @FXML
    void versenyzovalasztas(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();
        Pilotak kivalasztot = lista.getItems().get(index);

        nev_tf.setText(kivalasztot.getNév());
        szül_datum_tf.setText(kivalasztot.getSzülezési_datum());
        nemzetiseg_tf.setText(kivalasztot.getNemzetiseg());
        rajt_tf.setText(String.valueOf(kivalasztot.getRajtszám()));
    }

    @FXML
    void modositas(MouseEvent event) {
        int kivalasztot = lista.getSelectionModel().getSelectedIndex();

        if (kivalasztot >= 0){
            lista.getItems().get(kivalasztot).setNév(nev_tf.getText());
            lista.getItems().get(kivalasztot).setSzülezési_datum(szül_datum_tf.getText());
            lista.getItems().get(kivalasztot).setNemzetiseg(nemzetiseg_tf.getText());
            lista.getItems().get(kivalasztot).setRajtszám(Integer.valueOf(rajt_tf.getText()));
            lista.refresh();

            App.pilotak.get(kivalasztot).setNév(nev_tf.getText());
            App.pilotak.get(kivalasztot).setSzülezési_datum(szül_datum_tf.getText());
            App.pilotak.get(kivalasztot).setNemzetiseg(nemzetiseg_tf.getText());
            App.pilotak.get(kivalasztot).setRajtszám(Integer.valueOf(rajt_tf.getText()));

        }else {
            Alert hiba = new Alert(Alert.AlertType.WARNING);
            hiba.setTitle("Nincs kiválasztott elem a listából.");
            hiba.setHeaderText(null);
            hiba.setContentText("Nem választott ki elemet a listából, kérem válasszon egyet.");
            hiba.show();
        }
    }

}
