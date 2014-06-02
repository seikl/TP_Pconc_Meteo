package tp_pconc_meteo;

/**
 * code inspir� du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zone extends Thread {        
    
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private double lumiereZone;
    
    private RecepteurTemperature recTempZone_;
    private RecepteurPression recPresZone_;
    private int idZone_;
    private double etatZone_ = 0.;
    private double infExt_ = 1.;
    private double infInt_ = 0.5;
    private double infSC_ = 0.5;
    
    public Zone (int idZone, double infInt, RecepteurTemperature recTempZone)
    {
        recTempZone_ = recTempZone;
        idZone_ = idZone;
        infInt_ = infInt;
    }
    
    @Override
    public void run() 
    {
      try
      { 
        while( !isInterrupted() )
        {        
            //v�rification si on peut r�cup�rer la temp�rature ext�rieure
            if (recTempZone_.readyToWrite[idZone_]==false)
            {      
                //mise � jour de l'etat de La Zone
                etatZone_ = etatZone_ + infExt_ * (infExt_ - etatZone_)
                        + infSC * (recTempZone_.getTemp() - etatZone_);
                
                //indique que la zone est pr�te � recevoir une temp�rature
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
