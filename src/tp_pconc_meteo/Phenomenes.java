package tp_pconc_meteo;

/**
 * code inspri� du JDemo 136 (Cours de OBI - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public abstract class Phenomenes extends Thread{
    
    public abstract double Calculer() throws InterruptedException;
 
    public abstract void run();
        
}
