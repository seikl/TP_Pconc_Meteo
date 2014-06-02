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


public class ActuateurTemperature {
    
    private SC_Temperature scTemp_;
    public boolean readyToWrite_ = true;  
    private double tempAModifier_;
    
    ActuateurTemperature()
    {
        tempAModifier_=0;
    }
    
    public void setTempToModify (double temp)
    {
        tempAModifier_ = temp;
    }
    public double getTempToModify()
    {
        return tempAModifier_;
    }
    
}
