package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Temperature extends Phenomenes{ 
            
    static int ampTemperature_ = 10;
    static int offsetTemperature_ =10; 
    static int dephasageTemp_ = 2;   
    Timer leTemp_;
    int min_=10;
    int max_ = 10;
    private RecepteurTemperature recTemp_;
    
    public Temperature(RecepteurTemperature recTemp, Timer temp){recTemp_=recTemp; leTemp_=temp;}; //objet-membre de type Zones

    public synchronized void run()
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
                           "Temperature !\n");
        return;
      }
    }    


    public double Calculer() throws InterruptedException {
      int random = -min_ + (int) (Math.random() * ((max_ - (-min_)) + 1));
      //System.out.println("le random temperature vaut : " + random);
      return ampTemperature_ * Math.sin((2 * 3.14 * leTemp_.temp_ )/(Le_Main.periode) + dephasageTemp_) + offsetTemperature_ + (random);

    }
}
