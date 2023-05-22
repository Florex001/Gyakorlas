package hu.katolikuskeri.taxifuvarok.gui;

import hu.katolikuskeri.taxifuvarok.gui.Classes.Fuvar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    public static ArrayList<Fuvar> fuvar;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        FileChooser megnyitasablak = new FileChooser();
        megnyitasablak.setInitialDirectory(new File("/home/balogh/Letöltések"));
        File fájl = megnyitasablak.showOpenDialog(stage);
        String path = fájl.getAbsolutePath();

        fuvar = Fuvar.beolvas(path);


        scene = new Scene(loadFXML("taxiFuvarokGUI"), 600, 400);
        stage.setScene(scene);
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