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
public class CapteurLumiere {
    private SC_Temperature scTemp_;
    public boolean readyToWrite_ = true;  
    private double lum_;
    
    CapteurLumiere()
    {
        lum_=0.;
        System.out.println("Un capteur de lumiere a été activé ! \n");
    }
    
    public void setLum (double lum)
    {
        lum_ = lum;
    }
    public double getLum()
    {
        return lum_;
    }
}
