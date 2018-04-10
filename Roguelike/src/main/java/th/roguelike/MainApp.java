package th.roguelike;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
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
        // launch(args);
        /*
        Koska ohjelma on vasta kehitysvaiheessa, käytämme main-metodia launchin sijasta
        Tässä vaiheessa ohjelma printtaa gridin, johon lisataan seinia ja pelaaja. Pelaasjaa voi sitten liikuttaa köykäisesti nuolinäppäimillä
         */

        Scanner lukija = new Scanner(System.in);
        Grid kartta = new Grid(10, 10);
        kartta.lisaaPelaaja(4, 4);
        kartta.lisaaSeina(6, 7);

        while (true) {
            int i;
            for (i = 0; i < kartta.getY(); i++) {
                int j;
                for (j = 0; j < kartta.getX(); j++) {
                    Tyyppi mika  = kartta.haeKoordinaatista(j, i);
                    if(mika == Tyyppi.SEINÄ) {System.out.print("#");} else if(mika == Tyyppi.PELAAJA){System.out.print("P");} else {System.out.print("_");}
                }
                System.out.println("");
            }
            
            System.out.println("Siirretäänkö pelaajaa oikealle?");
            String kysymys = lukija.nextLine();
            
            if(kysymys == "y"){
                kartta.siirraPelaajaaOikealle();
            }else{
                System.out.println("Ei sitten!");
                break;
            }
            
            
        }
        
        System.out.println(" Kiitos pelistä!");

    }

}
