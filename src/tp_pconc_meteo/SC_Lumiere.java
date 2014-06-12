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
public class SC_Lumiere  extends Thread{
    private ActuateurLumiere atcuLum_;
    private CapteurLumiere captLum_;
    private double LumiereRequise_;
    private double LumPiece_;
    private ArrayList<Zone> lesZones = new ArrayList<Zone>();
    private int noZone=0;
    
    public SC_Lumiere()
    {
        
        
    } //objet-membre de type Zone
    void setLumRequise(double lum)
    {
        LumiereRequise_ = lum;
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
                                    
                
                double deltaLumiere= lesZones.get(noZone).getLumiereReference()-lesZones.get(noZone).PressionCapteur_.getPression();
                //Il fait trop chaud. On doit refroidir/rechauffer avec un taux de 30% de rendement
                lesZones.get(noZone).LumActuateur_.setLumToModify(0.3*deltaLumiere); 
               // System.out.println("the zone : "+noZone+" need to change temp to : " +deltaTemperature+"\n");
                
            }       
            sleep(1000);              
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "SC_Lumiere !\n");
        return;
      }
    }  
    
}
