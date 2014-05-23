package tp_pconc_meteo;

/**
 * code inspir� du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int tabZones[]={1,2,3,4};
    private int duree=0;
    private boolean readyToWrite[] = {true, true, true, true,}; //initialisation � "pr�t", donc
                                        // on commence par le calcul
                                        // du ph�nom�ne
    private double temperatureZone;
    
    
    @SuppressWarnings("empty-statement")
    public synchronized void ecrirePhenomene() throws InterruptedException{    
        
        //V�rification si toutes les zones peuvents recevoir un ph�nom�nes
        if (readyToWrite[0] &&
            readyToWrite[1] &&
            readyToWrite[2] &&
            readyToWrite[3]){    
            
            duree++;
            temperatureZone=Temperature.calculTemperature(duree);
                        
            //TODO inscrire la temp�rature dans un capteur
            System.out.println("Une temp�rature de " + temperatureZone + " a �t� inscrite sur toutes les zones.");
            
            readyToWrite[0]=false;
            readyToWrite[1]=false;
            readyToWrite[2]=false;
            readyToWrite[3]=false;
            
            System.out.println("D�but attente de lecture des capteurs");
            notifyAll();
        }
        else //pas pr�te � inscrire un ph.
            wait();                  
    }    
    
    public synchronized void lirePhenomene() throws InterruptedException{
         
        int n=0;
        
        //parcours en boucle de tous les capteurs jusqu'� ce que toutes les valeurs aient �t� relev�es
        while (true) {
            
            if (n % tabZones.length == 0 && n > 0) n=0;//r�initialisation 
                        
            if(!readyToWrite[n]){//pr�te � lire un ph.  

                //TODO le SC lit le capteur
                System.out.println("La zone (le capteur) " + n + " a lu la temp�rature.");

                readyToWrite[n] = true;  
                notifyAll();

            }
            else //pas pr�te � lire un ph�nom�ne.
                wait();  
           
            n++;                    
        } 
    }

}
