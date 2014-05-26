/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

import static java.lang.Thread.sleep;

/**
 *
 * @author jit
 */
public class SC_Pression extends Thread{
      private Zones noZoneConcernee;

    public SC_Pression(Zones noZone){noZoneConcernee=noZone;}; //objet-membre de type Zones
    
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