package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Temperature extends Thread{ 
        
    static int ampTemperature = 30;
    static int offsetTemperature =1; 
    static int rangTemperature = 1;
    static int dephasageTemp = 2;
    static int periode=24;    
    private Zones noZoneConcernee;
    
    public Temperature(Zones noZone){noZoneConcernee=noZone;}; //objet-membre de type Zones
    
    static public double calculTemperature(int temps) throws InterruptedException
    {          
        return ampTemperature * Math.sin(2 * 3.14 * temps /periode + dephasageTemp) + offsetTemperature + (Math.random()*rangTemperature - Math.random()*rangTemperature);
    }  

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        { 
          noZoneConcernee.ecrireTemperature();
          sleep(2000);
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "Temperature !\n");
        return;
      }
    }    
}
