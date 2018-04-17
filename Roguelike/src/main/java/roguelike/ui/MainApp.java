package roguelike.ui;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import roguelike.domain.Roguelike;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();*/
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // launch(args);
        /*
        Koska ohjelma on vasta kehitysvaiheessa, käytämme main-metodia launchin sijasta
        Tässä vaiheessa ohjelma printtaa gridin, johon lisataan seinia ja pelaaja. Pelaasjaa voi sitten liikuttaa köykäisesti nuolinäppäimillä
         */

        Scanner lukija = new Scanner(System.in);
        Roguelike roguelike = new Roguelike();

        Kayttoliittyma peli = new Kayttoliittyma(lukija, roguelike);
        peli.kaynnista();

    }

}
