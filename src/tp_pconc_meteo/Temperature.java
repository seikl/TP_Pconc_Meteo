package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Temperature extends Phenomenes{ 
            
    static int ampTemperature = 30;
    static int offsetTemperature =1; 
    static int rangTemperature = 1;
    static int dephasageTemp = 2;   
    static int temps=0;
    private RecepteurTemperature recTemp_;
    
    public Temperature(RecepteurTemperature recTemp){recTemp_=recTemp;}; //objet-membre de type Zones

    public void run()
    { 
      try
      { 
        while( !isInterrupted() )
        {            
            if(recTemp_.readyToWrite[0]==true &&  
                    recTemp_.readyToWrite[1]==true &&
                    recTemp_.readyToWrite[2]==true &&
                    recTemp_.readyToWrite[3]==true )
            {
                
                recTemp_.setTemp(Calculer());
                recTemp_.readyToWrite[0]=false ;
                recTemp_.readyToWrite[1]=false ;
                recTemp_.readyToWrite[2]=false; 
                recTemp_.readyToWrite[3]=false; 
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
      return ampTemperature * Math.sin(2 * 3.14 * temps /Le_Main.periode + dephasageTemp) + offsetTemperature + (Math.random()*rangTemperature - Math.random()*rangTemperature);

    }
}
