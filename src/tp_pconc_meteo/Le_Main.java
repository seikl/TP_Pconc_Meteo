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
        System.out.println("hello world!");

        //création des zone
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
