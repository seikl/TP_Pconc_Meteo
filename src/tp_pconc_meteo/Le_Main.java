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
        
        //on inscrit la p�riode pour les ph�nom�nes
        Temperature.periode = periode;
        
        
        System.out.println("hello world!");

        //cr�ation d'une zone
        Zones lesZones = new Zones();
        
        //cr�ation des Threads temp�rature et SC qui partageront une ou plusieurs zones
        Temperature temperature = new Temperature(lesZones);
        SC_Temperature sc_temperature = new SC_Temperature(lesZones);
        
        temperature.start();
        sc_temperature.start();        
        
        //appuyer une touche pour arr�ter
        clavier.nextLine();

        temperature.interrupt(); 
        sc_temperature.interrupt();

        System.exit(0);        
    }
    
}
