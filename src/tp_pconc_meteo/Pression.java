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
public class Pression extends Thread {
    
   
    static int rangPression = 2; 
    static int temps=0;
    private Zones noZoneConcernee;
    RecepteurPression recPress_;
    
    public Pression(RecepteurPression recPress){recPress_=recPress;}; //objet-membre de type Zones
    

   
    public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        {  
            if(recPress_.readyToWrite[0]==true &&  
                    recPress_.readyToWrite[1]==true &&
                    recPress_.readyToWrite[2]==true &&
                    recPress_.readyToWrite[3]==true )
            {
                
                recPress_.setPression(Calculer());
                recPress_.readyToWrite[0]=false ;
                recPress_.readyToWrite[1]=false ;
                recPress_.readyToWrite[2]=false; 
                recPress_.readyToWrite[3]=false; 
            }
          
          temps++;
          sleep(2000);
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "Temperature !\n");
        return;
      }
    }    

    public double Calculer() throws InterruptedException {
         return 1000 +Math.random()*rangPression;
    }
    
}
