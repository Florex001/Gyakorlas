package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    public static ArrayList<Pilotak> pilotak;
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FileChooser megnyitasablak = new FileChooser();
        megnyitasablak.setTitle("Adatokat tartalmazó .csv állomány");
        megnyitasablak.getExtensionFilters().add(new FileChooser.ExtensionFilter("Adatállomány","*.csv"));
        File fajl = megnyitasablak.showOpenDialog(stage);
        String path = fajl.getAbsolutePath();
        pilotak = Pilotak.beolvasas(path);



        scene = new Scene(loadFXML("Foablak"), 640, 480);
        stage.setScene(scene);

        stage.setOnCloseRequest(windowEvent -> {
            Alert mentes = new Alert(Alert.AlertType.CONFIRMATION);
            mentes.setTitle("Kilépés");
            mentes.setHeaderText("Menti a változásokat?");
            mentes.setContentText(null);
            mentes.getButtonTypes().clear();
            ButtonType igen = new ButtonType("Igen", ButtonBar.ButtonData.FINISH);
            ButtonType nem = new ButtonType("Nem", ButtonBar.ButtonData.NO);
            ButtonType mégse = new ButtonType("Mégse", ButtonBar.ButtonData.CANCEL_CLOSE);
            mentes.getButtonTypes().addAll(igen, nem, mégse);
            Optional<ButtonType> kivalasztva = mentes.showAndWait();

            if (kivalasztva.get() == igen){
                FileChooser mentés = new FileChooser();
                mentes.setTitle("Pilóták módosításának mentése...");
                File menteshelye = mentés.showSaveDialog(stage);

                try {
                    FileWriter iro = new FileWriter(menteshelye, Charset.forName("UTF-8"), false);

                    iro.write("név;születési_dátum;nemzetiség;rajtszám\n");

                    for (Pilotak elem : pilotak){
                        iro.write(elem.getNév());
                        iro.write(";");
                        iro.write(elem.getSzülezési_datum());
                        iro.write(";");
                        iro.write(elem.getNemzetiseg());
                        iro.write(";");
                        iro.write(String.valueOf(elem.getRajtszám()));
                        iro.write("\n");
                    }

                    iro.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }else if (kivalasztva.get() == nem){

            }else {
                windowEvent.consume();
            }

        });


        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}