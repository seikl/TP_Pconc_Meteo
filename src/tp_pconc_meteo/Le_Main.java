package tp_pconc_meteo;

import java.util.Scanner;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {

    static Scanner clavier = new Scanner(System.in);    

   // p�riode commune � tous les ph�nom�nes et zones    
    static int periode=24;

    public static void main(String[] args) {
        
        RecepteurTemperature recTemp = new RecepteurTemperature();
        RecepteurPression recPres = new RecepteurPression();
        //System.out.println("hello world!");

        //cr�ation des zone (No. de zone, facteur influence, r�cepteur Temperature)        
        Zone zone1 = new Zone(1, 0.5, recTemp);
        Zone zone2 = new Zone(2, 0.5, recTemp);
        Zone zone3 = new Zone(3, 0.5, recTemp);
        Zone zone4 = new Zone(4, 0.5, recTemp);
        zone1.setTemperatureReference(23);
        zone2.setTemperatureReference(23);
        zone3.setTemperatureReference(23);
        zone4.setTemperatureReference(23);
        //Zone zone3 = new Zone(3, 0.5, recTemp);
        //Zone zone2 = new Zone(2, 0.5, recTemp);

        
        SC_Temperature systemControlTemperature = new SC_Temperature();
        systemControlTemperature.addAZone(zone1);
        systemControlTemperature.addAZone(zone2);        
        systemControlTemperature.addAZone(zone3);
        systemControlTemperature.addAZone(zone4);
        
        //d�marrage du SC
        systemControlTemperature.start();        
        //cr�ation des Threads temp�rature et SC qui partageront une ou plusieurs zones
        
       // Pression pression = new Pression(recPres);           
        
        //appuyer une touche pour arr�ter
        clavier.nextLine();


        System.exit(0);        
    }
    
}
