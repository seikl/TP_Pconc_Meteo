package tp_pconc_meteo;

import java.util.Scanner;

/**
 *
 * @author S.Kleber et J.Ithurbide
 */
public class Le_Main {

    static Scanner clavier = new Scanner(System.in);    

   // période commune à tous les phénomènes et zones    
    static int periode=1440;

    public static void main(String[] args) {
        
        //init du timer principal
        Timer leTemp=new Timer();
        leTemp.start(); 
        
        RecepteurTemperature recTemp = new RecepteurTemperature();
        RecepteurPression recPres = new RecepteurPression();
        RecepteurLumiere recLum = new RecepteurLumiere();
        Temperature externalTemp = new Temperature(recTemp, leTemp);
        Pression externalPression = new Pression(recPres,leTemp);
        Lumiere externalLumiere = new Lumiere(recLum,leTemp
        
        
        
        
        
        
        
        );
        //System.out.println("hello world!");

        //création des zone (No. de zone, facteur influence, récepteur Temperature)        
        Zone zone1 = new Zone(0, 0.5, recTemp,recLum,recPres);
        Zone zone2 = new Zone(1, 0.5, recTemp,recLum,recPres);
        Zone zone3 = new Zone(2, 0.5, recTemp,recLum,recPres);
        Zone zone4 = new Zone(3, 0.5, recTemp,recLum,recPres);
        zone1.setTemperatureReference(23);
        zone1.setLumiereReference(20);
        zone1.setPressionReference(1000);
        zone2.setTemperatureReference(23);
        zone2.setLumiereReference(20);
        zone2.setPressionReference(1000);
        zone3.setTemperatureReference(23);
        zone3.setLumiereReference(20);
        zone3.setPressionReference(1000);
        zone4.setTemperatureReference(23);
        zone4.setLumiereReference(20);
        zone4.setPressionReference(1000);

        
        

        
        SC_Temperature systemControlTemperature = new SC_Temperature();
        systemControlTemperature.addAZone(zone1);
        systemControlTemperature.addAZone(zone2);        
        systemControlTemperature.addAZone(zone3);
        systemControlTemperature.addAZone(zone4);
        
        SC_Lumiere systemControlLumiere = new SC_Lumiere();
        systemControlLumiere.addAZone(zone1);
        systemControlLumiere.addAZone(zone2);
        systemControlLumiere.addAZone(zone3);
        systemControlLumiere.addAZone(zone4);
        
        SC_Pression systemControlPression = new SC_Pression();
        systemControlPression.addAZone(zone1);
        systemControlPression.addAZone(zone2);
        systemControlPression.addAZone(zone3);
        systemControlPression.addAZone(zone4);
        
        //démarrage du SC
          
        zone1.start();
        zone2.start();
        zone3.start();
        zone4.start();
        
        externalTemp.start();
        externalPression.start();
        externalLumiere.start();
        
        systemControlTemperature.start();  
        systemControlLumiere.start();
        systemControlPression.start();
        //création des Threads température et SC qui partageront une ou plusieurs zones
        
       // Pression pression = new Pression(recPres);           
        
        //appuyer une touche pour arrêter
        clavier.nextLine();


        System.exit(0);        
    }
    
}
