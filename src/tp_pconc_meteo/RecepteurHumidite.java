/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

/**
 *
 * @author jit
 */
public class RecepteurHumidite {
    public boolean readyToWrite[] = {true,true,true,true};  
    private double humidity_;
    
    public RecepteurHumidite()
    {
         humidity_ =0;
    }//objet-membre de type Zones
    
    public void setHumidity (double temp)
    {
        humidity_ = temp;
    }
    public double getHumidity()
    {
        return humidity_;
    }
    
    
}
