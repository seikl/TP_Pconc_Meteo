/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author jit
 */
public class SC_Humidite extends Thread{
    
    private ActuateurHumidite atcuHumidity_;
    private CapteurHumidite captHumidity_;
    private double humidityRequise_;
    private double humidityPiece_;
    private ArrayList<Zone> lesZones = new ArrayList<Zone>();
    private int noZone=0;
    
    public SC_Humidite()
    {
        
        
    } //objet-membre de type Zone
    void setHumidityRequise(double humidite)
    {
        humidityRequise_ = humidite;
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
           // System.out.println("One more time from SC! \n");
            for(int noZone=0;noZone<lesZones.size();noZone++)
            {
                                    
                
                double deltaHumidity= lesZones.get(noZone).getHumidityReference() -lesZones.get(noZone).HumiditeCapteur.getHumidity();
                //Il fait trop chaud. On doit refroidir/rechauffer avec un taux de 15% de rendement
                lesZones.get(noZone).HumititeActuateur.setHumidityToModify(0.15*deltaHumidity);   
               // System.out.println("the zone : "+noZone+" need to change temp to : " +deltaTemperature+"\n");
                
            }       
            sleep(1000);              
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "SC_Humidite !\n");
        return;
      }
    }  
    
}
