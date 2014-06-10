package tp_pconc_meteo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
 
/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class SC_Temperature extends Thread {    
    
    private ActuateurTemperature atcuTemp_;
    private CapteurTemperature captTemp_;
    private double temperatureRequise_;
    private double tempPiece_;
    private ArrayList<Zone> lesZones = new ArrayList<Zone>();
    private int noZone=0;
    
    public SC_Temperature()
    {
        
        
    } //objet-membre de type Zone
    void setTempRequise(double temp)
    {
        temperatureRequise_ = temp;
    }
    void addAZone(Zone laZone)
    {
        lesZones.add(laZone);
    }

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )            
        {         
            System.out.println("One more time from SC! \n");
            for(int noZone=0;noZone<lesZones.size();noZone++)
            {
                                    
                System.out.println("take control of the zone number : "+noZone+" \n");
                double deltaTemperature= lesZones.get(noZone).getTemperatureReference()-lesZones.get(noZone).TempCapteur_.getTemp();
                //Il fait trop chaud. On doit refroidir/rechauffer avec un taux de 30% de rendement
                lesZones.get(noZone).TempActuateur_.setTempToModify(0.3*deltaTemperature);   
                
            }       
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
