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
public class ActuateurPression {
    public boolean readyToWrite_ = true;  
    private double pressionAModifier_;
    
    ActuateurPression()
    {
        pressionAModifier_=0;
        System.out.println("Un actuateur  de pression a été activé ! \n");
    }
    
    public void setPressionToModify (double pression)
    {
        pressionAModifier_ = pression;
    }
    public double getPressionToModify()
    {
        return pressionAModifier_;
    }
    
}
