package roguelike.ui;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import roguelike.dao.Database;
import roguelike.domain.Map;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Database db = new Database("jdbc:sqlite:viholliset.db");

        final Map peli = new Map(db);
        peli.uusiTaso(20, 20, 70, 3);

        VBox Asettelu = new VBox();
        Pane Peliruutu = PiirraPeliruutu(peli/*, 10, 10, 10, 10*/);
        Peliruutu.setPrefSize(600, 400);

        TextArea tekstikentta = new TextArea("Tervetuloa luolastoseikkailuun!"
                + "\n Yritä koluta luolastossa mahdollisimman syvälle!"
                + "\n Liikuta pelaaja numpadilla (tai nuolinäppäimillä)."
                + "\n Muut vinoneliöt ovat vihollisia, joita voi lyödä niitä päin kävelemällä."
                + "\n Onnea matkaan, seikkailija!");

        tekstikentta.setEditable(false);
        tekstikentta.setMouseTransparent(true);
        tekstikentta.setFocusTraversable(false);

        Asettelu.getChildren().add(Peliruutu);
        Asettelu.getChildren().add(tekstikentta);

        Scene scene = new Scene(Asettelu);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                TextArea a = tekstikentta;
                List<String> tulostettavat = new ArrayList<>();
                tyhjennaKommentit(tekstikentta);
                tulostaKommentti(peli.pelaajanStatsit(), tekstikentta);
                if (event.getCode() == KeyCode.NUMPAD1) {
                    tulostaKommentti(peli.liikutaPelaajaa(-1, 1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD2 || event.getCode() == KeyCode.DOWN) {
                    tulostaKommentti(peli.liikutaPelaajaa(0, 1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD3) {
                    tulostaKommentti(peli.liikutaPelaajaa(1, 1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD6 || event.getCode() == KeyCode.RIGHT) {
                    tulostaKommentti(peli.liikutaPelaajaa(1, 0), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD9) {
                    tulostaKommentti(peli.liikutaPelaajaa(1, -1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD8 || event.getCode() == KeyCode.UP) {
                    tulostaKommentti(peli.liikutaPelaajaa(0, -1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD7) {
                    tulostaKommentti(peli.liikutaPelaajaa(-1, -1), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };
                if (event.getCode() == KeyCode.NUMPAD4 || event.getCode() == KeyCode.LEFT) {
                    tulostaKommentti(peli.liikutaPelaajaa(-1, 0), a);
                    tulostettavat = peli.paivita();
                    Paivita(peli, Asettelu, tulostettavat);
                };

            }
        });

        stage.setTitle("Roguelike");
        stage.setScene(scene);

        stage.show();
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
        launch(args);

        /*Scanner lukija = new Scanner(System.in);
        Roguelike roguelike = new Roguelike();

        Kayttoliittyma peli = new Kayttoliittyma(lukija, roguelike);
        peli.kaynnista();*/
    }

    public Pane PiirraPeliruutu(Map peli/*, int ruudunLeveys, int ruudunKorkeus, int leveysRuuduissa, int korkeusRuuduissa*/) {
        Pane pelinakyma = new Pane();
        pelinakyma.getChildren().addAll(peli.haeRuudut(0, 0, 20, 20, 20));
        return pelinakyma;
    }

    public void Paivita(Map peli, Pane asettelu, List<String> tulostettavat) {
        Pane Peliruutu = PiirraPeliruutu(peli);
        Peliruutu.setPrefSize(600, 400);
        asettelu.getChildren().remove(0);
        asettelu.getChildren().add(0, Peliruutu);
        tulostettavat.forEach(tama -> tulostaKommentti(tama, (TextArea) asettelu.getChildren().get(1)));
    }

    public void tulostaKommentti(String mita, TextArea tekstikentta) {
        tekstikentta.setText(tekstikentta.getText() + "\n" + mita);
    }

    public void tyhjennaKommentit(TextArea tekstikentta) {
        tekstikentta.setText("");
    }

}
