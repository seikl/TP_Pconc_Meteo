package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zone extends Thread {        
    
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private int lumiereZone;
    
    private RecepteurTemperature recTempZone_;
    private RecepteurLumiere recLumZone_;
    private RecepteurPression recPresZone_;
    public CapteurTemperature TempCapteur_= new CapteurTemperature();
    public CapteurLumiere LumCapteur_ = new CapteurLumiere();
    public CapteurPression PressionCapteur_ =  new CapteurPression();
    public ActuateurTemperature TempActuateur_= new ActuateurTemperature();
    public ActuateurLumiere LumActuateur_ = new ActuateurLumiere();
    public ActuateurPression PressionActuateur_ = new ActuateurPression();
    
    private int idZone_;
    private double etatZone_ = 0.;
    private double influenceTemperatureExt_ = 0.4;
    private double influenceLumiereExt_ = 0.33;
    private double influencePressionExt_ = 0.27;
    private double influcenceInt_ = 0.5;
    private double temperatureReference=0.0;
    private double pressionReference = 0.0;
    private double lumiereReference = 1200.0;
            
    public Zone (int idZone, double infInt, RecepteurTemperature recTempZone,RecepteurLumiere recLumZone,RecepteurPression recPressionZone)
    {
        recTempZone_ = recTempZone;
        recLumZone_ = recLumZone;
        recPresZone_ = recPressionZone;
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
    public double getLumiereReference()
    {
        return lumiereReference;
    }
     public void setLumiereReference(double lum)
    {
         lumiereReference=lum;
    }
     public double getPressionReference()
    {
        return pressionReference;
    }
     public void setPressionReference(double pression)
    {
         pressionReference=pression;
    }

    @Override
    public synchronized void run() 
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
                temperatureZone = temperatureZone +influenceTemperatureExt_ * (recTempZone_.getTemp()-temperatureZone) + TempActuateur_.getTempToModify();
                
                // on met a jour le capteur
                TempCapteur_.setTemp(temperatureZone);
                System.out.println("La temperature pour la zone : " + idZone_+ " est maintenant de : " + temperatureZone+"\n");
                 //indique que la zone est prête à recevoir une température
                recTempZone_.readyToWrite[idZone_]=true;
                 if(recTempZone_.readyToWrite[0]==true &&  
                    recTempZone_.readyToWrite[1]==true &&
                    recTempZone_.readyToWrite[2]==true &&
                    recTempZone_.readyToWrite[3]==true )
                {
                    notifyAll();
                }
            }
            if(recLumZone_.readyToWrite [idZone_]==false)
            {
                double lumiereZone = LumCapteur_.getLum();
                
                lumiereZone = lumiereZone + influenceLumiereExt_*( recLumZone_.getLum()-lumiereZone) ;//+ LumActuateur_.getLumToModify();
                LumCapteur_.setLum (lumiereZone);
                
                System.out.println("La lumiere pour la zone : " + idZone_+ " est maintenant de : " + lumiereZone+"\n");
                recLumZone_.readyToWrite [idZone_]=true;
                
              
                 if(recLumZone_.readyToWrite[0]==true &&  
                    recLumZone_.readyToWrite[1]==true &&
                    recLumZone_.readyToWrite[2]==true &&
                    recLumZone_.readyToWrite[3]==true )
                {
                    notifyAll();
                }
            }
            if(recPresZone_.readyToWrite [idZone_]==false)
            {
                double pressionZone = PressionCapteur_.getPression();
                
                pressionZone = pressionZone + influencePressionExt_*( recPresZone_.getPression()-pressionZone) + PressionActuateur_.getPressionToModify();
                PressionCapteur_.setPression(pressionZone);
                System.out.println("La pression pour la zone : " + idZone_+ " est maintenant de : " + pressionZone+"\n");
                recPresZone_.readyToWrite [idZone_]=true;
                
                 if(recPresZone_.readyToWrite[0]==true &&  
                    recPresZone_.readyToWrite[1]==true &&
                    recPresZone_.readyToWrite[2]==true &&
                    recPresZone_.readyToWrite[3]==true )
                {
                    notifyAll();
                }
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
