package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.example.Classes.Kolcsonzes;

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

    public static ArrayList<Kolcsonzes> kolcsonzes;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasablak = new FileChooser();
        megnyitasablak.setInitialDirectory(new File("/home/balogh/Letöltések"));
        File fájl = megnyitasablak.showOpenDialog(stage);
        String path = fájl.getAbsolutePath();

        kolcsonzes = Kolcsonzes.beolvas(path);

        scene = new Scene(loadFXML("FőAblak"), 650, 400);

        stage.setTitle("Kölcsönzések kezelése");
        stage.setScene(scene);
        stage.setOnCloseRequest((windowEvent -> {
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

                    iro.write("Név;JAzon;EÓra;EPerc;VÓra;Vperc\n");
                    for (Kolcsonzes elem : kolcsonzes){
                        iro.write(elem.getNév());
                        iro.write(";");
                        iro.write(elem.getJAzon());
                        iro.write(";");
                        iro.write(String.valueOf(elem.getEÓra().getHour()));
                        iro.write(";");
                        iro.write(String.valueOf(elem.getEPerc().getMinute()));
                        iro.write(";");
                        iro.write(String.valueOf(elem.getVÓra().getHour()));
                        iro.write(";");
                        iro.write(String.valueOf(elem.getVperc().getMinute()));
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

        }));
        stage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
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