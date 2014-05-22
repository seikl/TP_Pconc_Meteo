package tp_pconc_meteo;

import static java.lang.Thread.sleep;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class SC_Temperature extends Thread {    
    private Zones noZoneConcernee;

    public SC_Temperature(Zones noZone){noZoneConcernee=noZone;}; //objet-membre de type Zones
    
    //TODO écrire une méthode pour modifier l'actuateur

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        { 
          noZoneConcernee.lirePhenomene();
          sleep(500);
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
