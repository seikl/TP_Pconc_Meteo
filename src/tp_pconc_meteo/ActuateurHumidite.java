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
public class ActuateurHumidite {
    public boolean readyToWrite_ = true;  
    private double humidityAModifier_;
    
    ActuateurHumidite()
    {
        humidityAModifier_=0;
        System.out.println("Un actuateur d'humidite a été activé ! \n");
    }
    
    public void setHumidityToModify (double temp)
    {
        humidityAModifier_ = temp;
    }
    public double getHumidityToModify()
    {
        return humidityAModifier_;
    }
    
    
}
