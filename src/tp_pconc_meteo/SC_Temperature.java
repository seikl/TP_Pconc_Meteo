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
            if(captTemp_.readyToWrite_[0]==false&&captTemp_.readyToWrite_[1]==false && captTemp_.readyToWrite_[2]==false && captTemp_.readyToWrite_[3]==false)
            {
                //ici on peut aller lite une mise a jour est dispo !
                tempPiece_=captTemp_.getTemp();
                if(tempPiece_ > temperatureRequise_)
                {
                   double delta = tempPiece_ - temperatureRequise_; 
                   //on a environ 30% de rendement pour un chauffage
                   if(atcuTemp_.readyToWrite_[0]==true&&atcuTemp_.readyToWrite_[1]==true&&atcuTemp_.readyToWrite_[2]==true&&atcuTemp_.readyToWrite_[3]==true)
                   {
                       
                   }
                   
                }
                else if (tempPiece_ < temperatureRequise_)
                {
                    
                }
                captTemp_.readyToWrite_[0]=true;
                captTemp_.readyToWrite_[1]=true ;
                captTemp_.readyToWrite_[2]=true ;
                captTemp_.readyToWrite_[3]=true;
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
