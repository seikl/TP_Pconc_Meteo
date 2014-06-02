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
public class RecepteurTemperature {
    public boolean readyToWrite[] = {true,true,true,true};  
    private double temperature;
    
    public RecepteurTemperature()
    {
         temperature =0;
    }//objet-membre de type Zones
    
    public void setTemp (double temp)
    {
        temperature = temp;
    }
    public double getTemp()
    {
        return temperature;
    }
    

    
}
