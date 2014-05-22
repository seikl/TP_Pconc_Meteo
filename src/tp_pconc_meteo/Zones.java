package tp_pconc_meteo;

/**
 * code inspir� du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int noZone;
    private int duree=0;
    private boolean readyToWrite = true; //initialisation � "pr�t", donc
                                        // on commence par le calcul
                                        // du ph�nom�ne
    private double temperatureZone;
    
    public void setNoZone(int noZone){
        this.noZone = noZone;        
    }
    
    
    public synchronized void ecrirePhenomene() throws InterruptedException{
    
        if (readyToWrite){//pr�te � inscrire un ph.                
            duree++;
            temperatureZone=Temperature.calculTemperature(duree);
            System.out.println("Une temp�rature de " + temperatureZone + " sur la zone " + noZone + " a �t� inscrite.");
            //TODO inscrire la temp�rature dans un capteur
            notifyAll();
            readyToWrite = false;
            
        }
        else //pas pr�te � inscrire un ph.
            wait();                  
    }    
    
    public synchronized void lirePhenomene() throws InterruptedException{
    
        if (!readyToWrite){//pr�te � lire un ph.  
            System.out.println("La zone (le capteur) " + noZone + " a lu la temp�rature.");
            //TODO le SC lit le capteur
            notifyAll();
            readyToWrite = true;            
        }
        else //pas pr�te � lire un ph�nom�ne.
            wait();                  
    }       

}
