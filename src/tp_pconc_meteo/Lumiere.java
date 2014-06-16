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
public class Lumiere extends Phenomenes{
    
    private RecepteurLumiere recLum_;
    Timer leTemp_;
    public double valMax = 30000;
    private double a1 = 100;
    private double a2 = -80;
    int min=10;
    int max = 10;
    public Lumiere(RecepteurLumiere recLum, Timer temp){recLum_=recLum; leTemp_=temp;}; //objet-membre de type Zones

    public synchronized void run()
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
                           "Lumiere !\n");
        return;
      }
    }    


    public double Calculer() throws InterruptedException {
      
       double localLumi =0.; 
       int random = -min + (int) (Math.random() * ((max - (-min)) + 1));
       System.out.println("le random lumiere vaut : " + random);
       if (leTemp_.temp_ <300)
       {
          localLumi =0;
       }
       else if (leTemp_.temp_<600)
       {
          localLumi= a1*(leTemp_.temp_ -300)-random;
       }
        else if (leTemp_.temp_<1080)
       {
           localLumi=valMax -random;
       }
        else if (leTemp_.temp_<1320)
       {
           localLumi= valMax + a2*(leTemp_.temp_-1080) - random;
       }
        else if (leTemp_.temp_<1440)
       {
           localLumi =0;
       }
       return localLumi;

    }

}
