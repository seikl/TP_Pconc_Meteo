package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zone extends Thread {        
    
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private double lumiereZone;
    
    private RecepteurTemperature recTempZone_;
    private CapteurTemperature TempCapteur_;
    private ActuateurTemperature TempActuateur_;
    private RecepteurPression recPresZone_;
    private int idZone_;
    private double etatZone_ = 0.;
    private double influenceExt_ = 1.;
    private double influcenceInt_ = 0.5;
            
    public Zone (int idZone, double infInt, RecepteurTemperature recTempZone)
    {
        recTempZone_ = recTempZone;
        idZone_ = idZone;
        influcenceInt_ = infInt;
    }
    
    @Override
    public void run() 
    {
      try
      { 
        while( !isInterrupted() )
        {        
            //vérification si on peut récupérer la température extérieure
            if (recTempZone_.readyToWrite[idZone_]==false)
            {      
                //mise à jour de l'etat de La Zone
                etatZone_ = etatZone_ + influenceExt_ * (recTempZone_.getTemp() - etatZone_)
                        + TempCapteur_.getTemp() * ( TempActuateur_.getTempToModify() - etatZone_);
                
                //indique que la zone est prête à recevoir une température
                recTempZone_.readyToWrite[idZone_]=true;
            }
        }
      }
      catch(Exception e)
      {
        System.out.println("Exception " + e + " dans run() de " +
                           "Zone !\n");
      }    
    }
    

}
