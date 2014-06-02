package tp_pconc_meteo;

/**
 * code inspiré du JDemo 145 (Cours de O.B. - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Zone extends Thread{        
    
    private double temperatureZone;
    private double pressionZone;
    private double humditeZone;
    private double lumiereZone;
    
    private RecepteurTemperature recTempZone_;
    private RecepteurPression recPresZone_;
    private int idZone_;
    
    public Zone (int idZone, RecepteurTemperature recTempZone)
    {
        recTempZone_ = recTempZone;
        idZone_ = idZone;
    }
    
    public void run()
    {
        if (recTempZone_.readyToWrite[idZone_]==false)
            recTempZone_.readyToWrite[idZone_]=true;           
    
    }
    

}
