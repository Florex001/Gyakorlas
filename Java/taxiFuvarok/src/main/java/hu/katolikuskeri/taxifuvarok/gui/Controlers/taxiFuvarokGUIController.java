package hu.katolikuskeri.taxifuvarok.gui.Controlers;

import hu.katolikuskeri.taxifuvarok.gui.App;
import hu.katolikuskeri.taxifuvarok.gui.Classes.Fuvar;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class taxiFuvarokGUIController implements Initializable {

    @FXML
    private ChoiceBox<String> fizmod;

    @FXML
    private TextField borravalo;

    @FXML
    private DatePicker datepicker;


    @FXML
    private TextField idopont;

    @FXML
    private TextField idotartam;

    @FXML
    private TextField tavolsag;

    @FXML
    private TextField taxi_id;

    @FXML
    private TextField viteldij;

    @FXML
    private ListView<Fuvar> lista;

    @FXML
    void kivalasztas(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();
        Fuvar kivalasztott = lista.getItems().get(index);

        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter FORMATTER2 = DateTimeFormatter.ofPattern("HH:mm");
        String formázottév = kivalasztott.getIndulas().format(FORMATTER);
        String formázottido = kivalasztott.getIndulas().format(FORMATTER2);

        taxi_id.setText(String.valueOf(kivalasztott.getTaxi_id()));
        datepicker.setValue(LocalDate.parse(formázottév));
        idopont.setText(formázottido);
        idotartam.setText(String.valueOf(kivalasztott.getIdotartam()));
        tavolsag.setText(String.valueOf(kivalasztott.getTavolsag()));
        viteldij.setText(String.valueOf(kivalasztott.getViteldij()));
        borravalo.setText(String.valueOf(kivalasztott.getBorravalo()));
        fizmod.setValue(kivalasztott.getFizetes_modja());
    }

    @FXML
    void modositas(MouseEvent event) {
        int index = lista.getSelectionModel().getSelectedIndex();

        if (index >= 0){
            lista.getItems().get(index).setTavolsag(Double.parseDouble(tavolsag.getText()));
            lista.getItems().get(index).setFizetes_modja(fizmod.getValue());
            lista.getItems().get(index).setIdotartam(Integer.parseInt(idotartam.getText()));

            lista.refresh();

            App.fuvar.get(index).setIdotartam(Integer.parseInt(idotartam.getText()));
            App.fuvar.get(index).setTavolsag(Double.parseDouble(tavolsag.getText()));
            App.fuvar.get(index).setFizetes_modja(fizmod.getValue());

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
        fizmod.getItems().add("bankkártya");
        fizmod.getItems().add("készpénz");

        for (Fuvar elem : App.fuvar){
            lista.getItems().add(elem);
        }

    }
}
