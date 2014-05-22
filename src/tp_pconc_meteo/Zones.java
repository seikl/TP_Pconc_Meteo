package tp_pconc_meteo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int tabZones[]= {1,2,3,4};
    private int duree=0;
    private boolean readyToWrite [] = {true, true, true,true}; //initialisation à "prêt", donc
                                        // on commence par le calcul
                                        // du phénomène
    private double temperatureZone;    
    
    public synchronized void ecrireTemperature() throws InterruptedException{              
        //si toutes les zones sont prêtes à inscrire la température
        if (readyToWrite[0] && 
            readyToWrite[1] && 
            readyToWrite[2] && 
            readyToWrite[3]){//prête à inscrire un ph.                
               
            //on indique toutes les zones à false
            for (int i=0; i==tabZones.length; i++) {readyToWrite[i]=false;};            
            duree++;
            temperatureZone=Temperature.calculTemperature(duree);
            System.out.println("Une température de " + temperatureZone + " a été inscrite sur toutes les zones.");
            //TODO inscrire la température dans un capteur    
            notifyAll();
        }   
        else{ //sinon on attend
          while (!readyToWrite[0] && 
                !readyToWrite[1] && 
                !readyToWrite[2] && 
                !readyToWrite[3]){
                        try {
                                wait();
                        } catch (InterruptedException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }

        }        
    }                          
    
    public synchronized void lireTemperature() throws InterruptedException{
    
        try {
            //on parcourt chaque zone pour savoir si on peut lire  le phénomène
            for (int i = 1 ;i==tabZones.length; i++){

                if (!readyToWrite[i]){//prête à lire un ph.                
                    notify();
                    readyToWrite[i] = true;
                    System.out.println("Température lue dans la zone: " + i);
                    //TODO inscrire la température dans un capteur                      
                }   
                else
                    wait();
            }          
        }
        catch(InterruptedException ex) {
            Logger.getLogger(Zones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }       
}
