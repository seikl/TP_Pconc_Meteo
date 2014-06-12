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
public class CapteurPression {
    
    public boolean readyToWrite_ = true;  
    private double pression_;
    
    CapteurPression()
    {
        pression_=0.;
        System.out.println("Un capteur de pression a été activé ! \n");
    }
    
    public void setPression (double pression)
    {
        pression_ = pression;
    }
    public double getPression()
    {
        return pression_;
    }
    
    
}
