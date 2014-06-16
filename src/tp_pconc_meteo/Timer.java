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
public class Timer extends Thread{
    public int temp_;
    
     public Timer(){temp_=0;};
    
     public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        {            
          temp_++;
          if(temp_>1440) temp_=0;
          //System.out.println("le temps vaut  :" + temp_);
          sleep(50);
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "Lumiere !\n");
        return;
      }
    }
    
}
