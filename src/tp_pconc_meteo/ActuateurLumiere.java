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
public class ActuateurLumiere {
    private SC_Temperature scTemp_;
    public boolean readyToWrite_ = true;  
    private double lumAModifier_;
    
    ActuateurLumiere()
    {
        lumAModifier_=0;
        System.out.println("Un actuateur  de lumiere a été activé ! \n");
    }
    
    public void setLumToModify (double lum)
    {
        lumAModifier_ = lum;
    }
    public double getLumToModify()
    {
        return lumAModifier_;
    }
    
}
