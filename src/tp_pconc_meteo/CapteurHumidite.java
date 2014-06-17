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
public class CapteurHumidite {
    public boolean readyToWrite_ = true;  
    private double humidity_;
    
    CapteurHumidite()
    {
        humidity_=0.;
        System.out.println("Un capteur a été activé ! \n");
    }
    
    public void setHumidity (double humidite)
    {
        humidity_ = humidite;
    }
    public double getHumidity()
    {
        return humidity_;
    }
}
