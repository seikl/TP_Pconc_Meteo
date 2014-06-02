package tp_pconc_meteo;

import java.util.Scanner;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {

    static Scanner clavier = new Scanner(System.in);    

   // période commune à tous les phénomènes et zones    
    static int periode=24;

    public static void main(String[] args) {
        
        RecepteurTemperature recTemp = new RecepteurTemperature();
        RecepteurPression recPres = new RecepteurPression();
        System.out.println("hello world!");

        //création des zone
        Zone zone1 = new Zone(1, recTemp);
        Zone zone2 = new Zone(2, recTemp);
        
        //création des Threads température et SC qui partageront une ou plusieurs zones
        
        Pression pression = new Pression(recPres);           
        
        //appuyer une touche pour arrêter
        clavier.nextLine();


        System.exit(0);        
    }
    
}
