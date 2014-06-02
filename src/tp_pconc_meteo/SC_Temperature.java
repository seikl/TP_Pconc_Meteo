package tp_pconc_meteo;

import static java.lang.Thread.sleep;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class SC_Temperature extends Thread {    
    
    private ActuateurTemperature atcuTemp_;
    private CapteurTemperature captTemp_;
    private double temperatureRequise_;
    private double tempPiece_;
    
    public SC_Temperature(ActuateurTemperature actuTemp,CapteurTemperature captTemp,double temperatureRequise)
    {
        atcuTemp_=actuTemp;
        captTemp_=captTemp;
        temperatureRequise_=temperatureRequise; 
        
    } //objet-membre de type Zone
    void setTempRequise(double temp)
    {
        temperatureRequise_ = temp;
    }

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )            
        {         
            if(captTemp_.readyToWrite_==false)
            {
                //ici on peut aller lite une mise a jour est dispo !
                tempPiece_=captTemp_.getTemp();
                if(tempPiece_ > temperatureRequise_)
                {
                    
                }
                else if (tempPiece_ < temperatureRequise_)
                {
                    
                }
                captTemp_.readyToWrite_=true;
            }
            sleep(1000);              
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "SC_Temperature !\n");
        return;
      }
    }  
}
