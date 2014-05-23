package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int tabZones[]={1,2,3,4};
    private double capteurTemperature[]={0., 0., 0., 0.}; 
    private double actuateurTemperature[]={0., 0., 0., 0.}; 
    private double temperatureSeuil=20.;
    
    //tableau à 2 dimensions pour le phénomènes et les états des capteurs correspondants
    //NB: Tempéprature=(0), Pression=(1), Humidité=(2), Lumière=(3)
    //[1] [1] [0] [1]<- chaque ligne représent le no de phénomène
    //[0] [1] [1] [1]
    //[0] [1] [0] [1]
    //[1] [1] [0] [1]
    // ^
    // chaque colonne l'état d'une zone
    //
    //initialisation à 1="prêt" pour tous les phén., donc on commence par le calcul du phénomène
    private boolean readyToWrite[][] = {{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true}};                                                                
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private double lumiereZone;
    
    @SuppressWarnings("empty-statement")
    public synchronized void ecrirePhenomene(int noPhenomene) throws InterruptedException{    
        
        

        //Vérification si toutes les zones peuvents inscrire la valeur du phénomène
        if (readyToWrite[noPhenomene][0] &&
            readyToWrite[noPhenomene][1] &&
            readyToWrite[noPhenomene][2] &&
            readyToWrite[noPhenomene][3]){                            

            switch (noPhenomene){
            case 0: 
                temperatureZone=Temperature.calculTemperature();                        
                //inscrire la température dans le capteur correspondant au phénomène            
                for (int i=0;i<tabZones.length;i++){                                
                    capteurTemperature[i]=temperatureZone;
                }
                System.out.println("-------------------");
                System.out.println("Une température de " + temperatureZone + " a été envoyée sur toutes les zones.");
                break;
            }
            
            readyToWrite[noPhenomene][0]=false;
            readyToWrite[noPhenomene][1]=false;
            readyToWrite[noPhenomene][2]=false;
            readyToWrite[noPhenomene][3]=false;

            notifyAll();
        }
        else //pas prête à inscrire un ph.
            wait();                        
    }    
    
    public synchronized void lirePhenomene(int noPhenomene) throws InterruptedException{
         
        int n=0;
        
        //parcours en boucle de tous les capteurs jusqu'à ce que toutes les valeurs aient été relevées
        while (true) {
            
            if (n % tabZones.length == 0 && n > 0) n=0;//réinitialisation 
                        
            if(!readyToWrite[noPhenomene][n]){//prête à lire un ph.  

            switch (noPhenomene){
            case 0: 
                actuateurTemperature[n]= SC_Temperature.reglerActuateur(temperatureSeuil, capteurTemperature[n]);
                System.out.print("La zone (le capteur) " + (n+1) + " a enregistrée la température.");
                if (actuateurTemperature[n] > 0.){System.out.println("L'actuateur augmente la température de "+ actuateurTemperature[n]);}
                else if (actuateurTemperature[n] < 0.){System.out.println("L'actuateur baisse la température de "+ actuateurTemperature[n]);}
                else {System.out.println("La température est la même qu'avant");}
                break;
            }
                readyToWrite[noPhenomene][n] = true;  
                notifyAll();

            }
            else //pas prête à lire un phénomène.
                wait();  
           
            n++;                    
        } 
    }

}
