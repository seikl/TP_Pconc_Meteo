package tp_pconc_meteo;

import java.util.Scanner;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {
    
    static Scanner clavier = new Scanner(System.in);
    
    static int periode=24; // p�riode commune � tous les ph�nom�nes et zones

    public static void main(String[] args) {
        System.out.println("hello world!");

        //cr�ation d'une zone
        Zones zone1 = new Zones();
        zone1.setNoZone(1);
        
        //cr�ation des Threads temp�rature et SC qui partageront une ou plusieurs zones
        Temperature temperature = new Temperature(zone1);
        SC_Temperature sc_temperature = new SC_Temperature(zone1);
        
        temperature.start();
        sc_temperature.start();        
        
        //appuyer une touche pour arr�ter
        clavier.nextLine();

        temperature.interrupt(); 
        sc_temperature.interrupt();

        System.exit(0);        
    }
    
}
