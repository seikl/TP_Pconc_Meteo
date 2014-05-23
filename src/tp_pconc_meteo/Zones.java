package tp_pconc_meteo;

/**
 * code inspir� du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zones{
    
    private int tabZones[]={1,2,3,4};
    private double capteurTemperature[]={0., 0., 0., 0.}; 
    private double actuateurTemperature[]={0., 0., 0., 0.}; 
    private double temperatureSeuil=20.;
    
    //tableau � 2 dimensions pour le ph�nom�nes et les �tats des capteurs correspondants
    //NB: Temp�prature=(0), Pression=(1), Humidit�=(2), Lumi�re=(3)
    //[1] [1] [0] [1]<- chaque ligne repr�sent le no de ph�nom�ne
    //[0] [1] [1] [1]
    //[0] [1] [0] [1]
    //[1] [1] [0] [1]
    // ^
    // chaque colonne l'�tat d'une zone
    //
    //initialisation � 1="pr�t" pour tous les ph�n., donc on commence par le calcul du ph�nom�ne
    private boolean readyToWrite[][] = {{true,true,true,true},{true,true,true,true},{true,true,true,true},{true,true,true,true}};                                                                
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private double lumiereZone;
    
    @SuppressWarnings("empty-statement")
    public synchronized void ecrirePhenomene(int noPhenomene) throws InterruptedException{    
        
        

        //V�rification si toutes les zones peuvents inscrire la valeur du ph�nom�ne
        if (readyToWrite[noPhenomene][0] &&
            readyToWrite[noPhenomene][1] &&
            readyToWrite[noPhenomene][2] &&
            readyToWrite[noPhenomene][3]){                            

            switch (noPhenomene){
            case 0: 
                temperatureZone=Temperature.calculTemperature();                        
                //inscrire la temp�rature dans le capteur correspondant au ph�nom�ne            
                for (int i=0;i<tabZones.length;i++){                                
                    capteurTemperature[i]=temperatureZone;
                }
                System.out.println("-------------------");
                System.out.println("Une temp�rature de " + temperatureZone + " a �t� envoy�e sur toutes les zones.");
                break;
            }
            
            readyToWrite[noPhenomene][0]=false;
            readyToWrite[noPhenomene][1]=false;
            readyToWrite[noPhenomene][2]=false;
            readyToWrite[noPhenomene][3]=false;

            notifyAll();
        }
        else //pas pr�te � inscrire un ph.
            wait();                        
    }    
    
    public synchronized void lirePhenomene(int noPhenomene) throws InterruptedException{
         
        int n=0;
        
        //parcours en boucle de tous les capteurs jusqu'� ce que toutes les valeurs aient �t� relev�es
        while (true) {
            
            if (n % tabZones.length == 0 && n > 0) n=0;//r�initialisation 
                        
            if(!readyToWrite[noPhenomene][n]){//pr�te � lire un ph.  

            switch (noPhenomene){
            case 0: 
                actuateurTemperature[n]= SC_Temperature.reglerActuateur(temperatureSeuil, capteurTemperature[n]);
                System.out.print("La zone (le capteur) " + (n+1) + " a enregistr�e la temp�rature.");
                if (actuateurTemperature[n] > 0.){System.out.println("L'actuateur augmente la temp�rature de "+ actuateurTemperature[n]);}
                else if (actuateurTemperature[n] < 0.){System.out.println("L'actuateur baisse la temp�rature de "+ actuateurTemperature[n]);}
                else {System.out.println("La temp�rature est la m�me qu'avant");}
                break;
            }
                readyToWrite[noPhenomene][n] = true;  
                notifyAll();

            }
            else //pas pr�te � lire un ph�nom�ne.
                wait();  
           
            n++;                    
        } 
    }

}
