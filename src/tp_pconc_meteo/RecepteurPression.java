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
public class RecepteurPression {
    public boolean readyToWrite[] = {true,true,true,true};  
    private double pression;
    RecepteurPression()
    {
        pression=1000;
    }
    
    public void setPression (double pres)
    {
        pression = pres;
    }
    public double getPression()
    {
        return pression;
    }

}
