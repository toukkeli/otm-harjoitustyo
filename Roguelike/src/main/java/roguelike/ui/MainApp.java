package roguelike.ui;

import java.util.Scanner;
import roguelike.domain.Roguelike;

public class MainApp /*extends Application*/ {

    /*@Override
    public void start(Stage stage) throws Exception {
        final HashMap<KeyCode, Boolean> painetutNapit = new HashMap<>();

        final int korkeusRuuduissa = 10;
        final int leveysRuuduissa = 10;
        final Roguelike peli = new Roguelike();

        Pane ruutu = new Pane();
        ruutu.setPrefSize(leveysRuuduissa * 10, korkeusRuuduissa * 10);

        ruutu.getChildren().addAll(peli.haeRuudut());
        Scene scene = new Scene(ruutu);

        stage.setTitle("Roguelike");
        stage.setScene(scene);
        stage.show();

        scene.setOnKeyPressed(event -> {
            painetutNapit.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            painetutNapit.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                Boolean tehtySiirto = false;
                if (painetutNapit.getOrDefault(KeyCode.LEFT, Boolean.FALSE)) {
                    peli.liikutaPelaajaa(-1, 0);
                    tehtySiirto = true;
                } else if (painetutNapit.getOrDefault(KeyCode.RIGHT, Boolean.FALSE)) {
                    peli.liikutaPelaajaa(1, 0);
                    tehtySiirto = true;
                } else if (painetutNapit.getOrDefault(KeyCode.DOWN, Boolean.FALSE)) {
                    peli.liikutaPelaajaa(0, 1);
                    tehtySiirto = true;
                } else if (painetutNapit.getOrDefault(KeyCode.UP, Boolean.FALSE)) {
                    peli.liikutaPelaajaa(0, -1);
                    tehtySiirto = true;
                }

            }

        }.start();

        stage.show();
    }*/
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*launch(args);*/
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
