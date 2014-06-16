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
public class Pression extends Phenomenes {
    
   
    static int rangPression = 2; 
    static int temps=0;
    RecepteurPression recPress_;
    Timer leTemp_;
    int min=10;
    int max = 10;
    
    public Pression(RecepteurPression recPress, Timer temp){recPress_=recPress; leTemp_=temp;}; //objet-membre de type Zones
    

   
    public synchronized void run()
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
                           "Pression !\n");
        return;
      }
    }    

    public double Calculer() throws InterruptedException {
        int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
        //System.out.println("le random pression vaut :" + ii);
         return 1000 +ii;
    }
    
}
