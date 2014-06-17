/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

import static java.lang.Thread.sleep;

/**
 *
 * @author jit
 */
public class Humidite  extends Phenomenes{
    static int ampHumidity_ = 10;
    static int offsetHumidity_=10; 
    static int dephasageHumidity_ = 2;   
    Timer leTemp_;
 
    int min=10;
    int max = 10;
    private RecepteurHumidite recHumidity_;
    
    public Humidite(RecepteurHumidite recHum, Timer temp){recHumidity_=recHum; leTemp_=temp;}; //objet-membre de type Zones

    public synchronized void run()
    { 
      try
      { 
        while( !isInterrupted() )
        {            
            if(recHumidity_.readyToWrite[0]==true &&  
                    recHumidity_.readyToWrite[1]==true &&
                    recHumidity_.readyToWrite[2]==true &&
                    recHumidity_.readyToWrite[3]==true )
            {
                
                recHumidity_.setHumidity(Calculer());
                recHumidity_.readyToWrite[0]=false ;
                recHumidity_.readyToWrite[1]=false ;
                recHumidity_.readyToWrite[2]=false; 
                recHumidity_.readyToWrite[3]=false; 
            }
            else
            {
                wait();
            }
          sleep(2000);
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "Humidity !\n");
        return;
      }
    }    


    public double Calculer() throws InterruptedException {
      int random = -min + (int) (Math.random() * ((max - (-min)) + 1));
      //System.out.println("le random temperature vaut : " + random);
      return ampHumidity_ * Math.sin((2 * 3.14 * leTemp_.temp_ )/(Le_Main.periode) + dephasageHumidity_) + offsetHumidity_ + (random);

    }
    
}
