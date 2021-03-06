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
public class SC_Pression extends Thread{
     private ActuateurPression atcuPression_;
    private CapteurPression captPression_;
    private double pressionRequise_;
    private double pressionPiece_;
    private ArrayList<Zone> lesZones = new ArrayList<Zone>();
    private int noZone=0;
    
    public SC_Pression()
    {
        
        
    } //objet-membre de type Zone
    void setPressionRequise(double pression)
    {
        pressionRequise_ = pression;
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
                                    
                
                double deltaPression= lesZones.get(noZone).getPressionReference()-lesZones.get(noZone).PressionCapteur_.getPression() ;
                //Il fait trop chaud. On doit refroidir/rechauffer avec un taux de 30% de rendement
                lesZones.get(noZone).PressionActuateur_.setPressionToModify(0.3*deltaPression); 
               // System.out.println("the zone : "+noZone+" need to change temp to : " +deltaTemperature+"\n");
                
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
