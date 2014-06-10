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
    public CapteurTemperature TempCapteur_= new CapteurTemperature();
    public ActuateurTemperature TempActuateur_= new ActuateurTemperature();
    private RecepteurPression recPresZone_;
    private int idZone_;
    private double etatZone_ = 0.;
    private double influenceTemperatureExt_ = 0.4;
    private double influcenceInt_ = 0.5;
    private double temperatureReference=0.0;
            
    public Zone (int idZone, double infInt, RecepteurTemperature recTempZone)
    {
        recTempZone_ = recTempZone;
        idZone_ = idZone;
        influcenceInt_ = infInt;
    }
    public double getTemperatureReference()
    {
        return temperatureReference;
    }
     public void setTemperatureReference(double temp)
    {
         temperatureReference=temp;
    }

    @Override
    public void run() 
    {
        //System.out.println("One more time first! \n");
      try
      { 
        while( !isInterrupted() )
        {        
            //vérification si on peut récupérer la température extérieure
            //System.out.println("One more time! \n");
            if (recTempZone_.readyToWrite[idZone_]==false)
            {    
                double temperatureZone = TempCapteur_.getTemp();
                //mise à jour de l'etat de La Zone
              //  etatZone_ = etatZone_ + influenceTemperatureExt_ * (recTempZone_.getTemp() - etatZone_)+ TempCapteur_.getTemp() * ( TempActuateur_.getTempToModify() - etatZone_);
                temperatureZone = temperatureZone +influenceTemperatureExt_ * (recTempZone_.getTemp()) + TempActuateur_.getTempToModify();
                
                // on met a jour le capteur
                TempCapteur_.setTemp(temperatureZone);
                System.out.println("La tenperature pour la zone : " + idZone_+ " est maintenant de : " + temperatureZone+"\n");
                 //indique que la zone est prête à recevoir une température
                recTempZone_.readyToWrite[idZone_]=true;
            }
             sleep(1000); 
        }
      }
      catch(Exception e)
      {
        System.out.println("Exception " + e + " dans run() de " +
                           "Zone !\n");
      }    
    }
    

}
