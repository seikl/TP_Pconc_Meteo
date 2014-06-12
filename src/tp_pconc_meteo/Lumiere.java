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
public class Lumiere extends Thread{
    
    static int temps=0;
    private RecepteurLumiere recLum_;
    
    public Lumiere(RecepteurLumiere recLum){recLum_=recLum;}; //objet-membre de type Zones

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        {            
            if(recLum_.readyToWrite[0]==true &&  
                    recLum_.readyToWrite[1]==true &&
                    recLum_.readyToWrite[2]==true &&
                    recLum_.readyToWrite[3]==true )
            {
                
                recLum_.setLum(Calculer());
                recLum_.readyToWrite[0]=false ;
                recLum_.readyToWrite[1]=false ;
                recLum_.readyToWrite[2]=false; 
                recLum_.readyToWrite[3]=false; 
            }
          temps++;
          sleep(2000);
        }
      }
      catch(InterruptedException e)
      {
        System.out.println("InterruptedException dans run() de " +
                           "Lumiere !\n");
        return;
      }
    }    


    public int Calculer() throws InterruptedException {
      return 10;

    }
    
}
