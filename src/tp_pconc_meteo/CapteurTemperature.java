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
public class CapteurTemperature {
    
    private SC_Temperature scTemp_;
    public boolean readyToWrite_[] = {true,true,true,true};  
    private double temp_;
    
    CapteurTemperature()
    {
        temp_=0;
    }
    
    public void setTemp (double temp)
    {
        temp_ = temp;
    }
    public double getTemp()
    {
        return temp_;
    }
    
}
