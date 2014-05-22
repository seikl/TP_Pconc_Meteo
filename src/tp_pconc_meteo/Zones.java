package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int noZone;
    private int duree=0;
    private boolean readyToWrite = true; //initialisation à "prêt", donc
                                        // on commence par le calcul
                                        // du phénomène
    private double temperatureZone;
    
    public void setNoZone(int noZone){
        this.noZone = noZone;        
    }
    
    
    public synchronized void ecrirePhenomene() throws InterruptedException{
    
        if (readyToWrite){//prête à inscrire un ph.                
            duree++;
            temperatureZone=Temperature.calculTemperature(duree);
            System.out.println("Une température de " + temperatureZone + " sur la zone " + noZone + " a été inscrite.");
            //TODO inscrire la température dans un capteur
            notifyAll();
            readyToWrite = false;
            
        }
        else //pas prête à inscrire un ph.
            wait();                  
    }    
    
    public synchronized void lirePhenomene() throws InterruptedException{
    
        if (!readyToWrite){//prête à lire un ph.  
            System.out.println("La zone (le capteur) " + noZone + " a lu la température.");
            //TODO le SC lit le capteur
            notifyAll();
            readyToWrite = true;            
        }
        else //pas prête à lire un phénomène.
            wait();                  
    }       

}
