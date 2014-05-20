package tp_pconc_meteo;

/**
 * @author S.Kleber et J.Ithurbide
 */
public class Zone {
    
    double valeurPhenomene = 0.0;
    double valeurSC = 0.0;
    
    synchronized public void CapteurTemperature(double valeurPhenomene){ 
        this.valeurPhenomene = valeurPhenomene;
    }
    
    synchronized public void ActuateurTemperature(double valeurSC){                       
        this.valeurSC = valeurSC;
    }
    
}
