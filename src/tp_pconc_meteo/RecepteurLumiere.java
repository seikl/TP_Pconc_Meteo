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
public class RecepteurLumiere {
    public boolean readyToWrite[] = {true,true,true,true};  
    private double lumiere;
    
    public RecepteurLumiere()
    {
         lumiere =0;
    }//objet-membre de type Zones
    
    public void setLum (double lumi)
    {
        lumiere = lumi;
    }
    public double getLum()
    {
        return lumiere;
    }
    
    
}
