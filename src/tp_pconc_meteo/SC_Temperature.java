package tp_pconc_meteo;

import static java.lang.Thread.sleep;

/**
 * code inspir� du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class SC_Temperature extends Thread {    
    private Zones noZoneConcernee;

    public SC_Temperature(Zones noZone){noZoneConcernee=noZone;}; //objet-membre de type Zones
    
    public static double reglerActuateur(double valSeuil, double valCapteur){
        
        if(valCapteur > valSeuil)
               return valSeuil - valCapteur;
        else
                return (valSeuil - valCapteur);
    }

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )            
        {         
            noZoneConcernee.lirePhenomene(0);
            sleep(1000);              
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "SC_Temperature !\n");
        return;
      }
    }  
}
