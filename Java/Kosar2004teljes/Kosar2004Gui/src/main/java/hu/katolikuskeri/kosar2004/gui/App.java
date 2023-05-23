package hu.katolikuskeri.kosar2004.gui;

import hu.katolikuskeri.kosar2004.cli.Eredmeny;
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

    public static ArrayList<Eredmeny> eredmenyek = Eredmeny.beolvas("eredmenyek.csv");

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("foablak"), 640, 480);
        stage.setTitle("Meccsek");
        stage.setScene(scene);

        stage.setOnCloseRequest(windowEvent -> {
            Alert kerdes = new Alert(Alert.AlertType.CONFIRMATION);
            kerdes.setTitle("Kilépés");
            kerdes.setHeaderText(null);
            kerdes.setContentText("Szeretné menteni?");
            kerdes.getButtonTypes().clear();
            ButtonType igenGomb = new ButtonType("Igen", ButtonBar.ButtonData.YES);
            ButtonType nemGomb = new ButtonType("Nem", ButtonBar.ButtonData.NO);
            ButtonType megseGomb = new ButtonType("Mégse", ButtonBar.ButtonData.CANCEL_CLOSE);
            kerdes.getButtonTypes().addAll(igenGomb, nemGomb, megseGomb);
            Optional<ButtonType> eredmeny = kerdes.showAndWait();

            if (eredmeny.get() == igenGomb){
                FileChooser mentes = new FileChooser();
                mentes.setTitle("Dolgozók adatainak mentése....");
                File mentesfile = mentes.showSaveDialog(stage);

                try {
                    FileWriter iro = new FileWriter(mentesfile, Charset.forName("UTF-8"), false);

                    iro.write("hazai;idegen;hazai_pont;idegen_pont;helyszín;időpont\n");
                    for (Eredmeny elem : eredmenyek){
                        iro.write(elem.getHazai());
                        iro.write(";");
                        iro.write(elem.getIdegen());
                        iro.write(";");
                        iro.write(elem.getHazai_pont());
                        iro.write(";");
                        iro.write(elem.getIdegen_pont());
                        iro.write(";");
                        iro.write(elem.getHelyszin());
                        iro.write(";");
                        iro.write(String.valueOf(elem.getIdopont()));
                        iro.write("\n");
                    }

                    iro.close();

                } catch (IOException e) {
                    Alert hiba = new  Alert(Alert.AlertType.ERROR);
                    hiba.setTitle("Valami hiba történt.");
                    hiba.setHeaderText(null);
                    hiba.setContentText("Próbálja újra.");
                    hiba.show();
                }

            }else if (eredmeny.get() == nemGomb){

            } else if (eredmeny.get() == megseGomb) {
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