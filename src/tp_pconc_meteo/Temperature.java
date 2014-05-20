package tp_pconc_meteo;

/**
 * code insprié du JDemo 136 (Cours de OBI - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public class Temperature extends Phenomenes {
    
    private int ampTemperature, offsetTemperature, rangTemperature, dephasageTemp, periode;
 
    public Temperature(int amp, int offset, int rang, int dephasage, int periode){
        ampTemperature = amp;
        offsetTemperature = offset;
        rangTemperature = rang;
        dephasageTemp = dephasage;
        this.periode = periode;
    }
    
    synchronized public double Calcul(int temps)
    {    
        return ampTemperature * Math.sin(2 * 3.14 * temps /periode + dephasageTemp) + offsetTemperature + (Math.random()*rangTemperature - Math.random()*rangTemperature);
    }
    
    
    synchronized public void run()
    {
        try
        {
            for (int i = 1; i <= periode; i++)
            {
                System.out.println(Calcul(i));
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {}
        System.out.println();    
    
    
    }
}
