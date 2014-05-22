package tp_pconc_meteo;

import java.util.Scanner;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {
    
    static Scanner clavier = new Scanner(System.in);    
    static int periode=24; // période commune à tous les phénomènes et zones 
    
    public static void main(String[] args) {
        
        //on inscrit la période pour les phénomènes
        Temperature.periode = periode;
        
        
        System.out.println("hello world!");

        //création d'une zone
        Zones lesZones = new Zones();
        
        //création des Threads température et SC qui partageront une ou plusieurs zones
        Temperature temperature = new Temperature(lesZones);
        SC_Temperature sc_temperature = new SC_Temperature(lesZones);
        
        temperature.start();
        sc_temperature.start();        
        
        //appuyer une touche pour arrêter
        clavier.nextLine();

        temperature.interrupt(); 
        sc_temperature.interrupt();

        System.exit(0);        
    }
    
}
