package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int tabZones[]={1,2,3,4};
    private int duree=0;
    private boolean readyToWrite[] = {true, true, true, true,}; //initialisation à "prêt", donc
                                        // on commence par le calcul
                                        // du phénomène
    private double temperatureZone;
    
    
    @SuppressWarnings("empty-statement")
    public synchronized void ecrirePhenomene() throws InterruptedException{    
        
        //Vérification si toutes les zones peuvents recevoir un phénomènes
        if (readyToWrite[0] &&
            readyToWrite[1] &&
            readyToWrite[2] &&
            readyToWrite[3]){    
            
            duree++;
            temperatureZone=Temperature.calculTemperature(duree);
                        
            //TODO inscrire la température dans un capteur
            System.out.println("Une température de " + temperatureZone + " a été inscrite sur toutes les zones.");
            
            readyToWrite[0]=false;
            readyToWrite[1]=false;
            readyToWrite[2]=false;
            readyToWrite[3]=false;
            
            System.out.println("Début attente de lecture des capteurs");
            notifyAll();
        }
        else //pas prête à inscrire un ph.
            wait();                  
    }    
    
    public synchronized void lirePhenomene() throws InterruptedException{
         
        int n=0;
        
        //parcours en boucle de tous les capteurs jusqu'à ce que toutes les valeurs aient été relevées
        while (true) {
            
            if (n % tabZones.length == 0 && n > 0) n=0;//réinitialisation 
                        
            if(!readyToWrite[n]){//prête à lire un ph.  

                //TODO le SC lit le capteur
                System.out.println("La zone (le capteur) " + n + " a lu la température.");

                readyToWrite[n] = true;  
                notifyAll();

            }
            else //pas prête à lire un phénomène.
                wait();  
           
            n++;                    
        } 
    }

}
