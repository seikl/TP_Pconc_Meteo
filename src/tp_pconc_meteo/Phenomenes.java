package tp_pconc_meteo;

/**
 * code inspri� du JDemo 136 (Cours de OBI - AprogOO)
 * @author S.Kleber et J.Ithurbide
 */
public abstract class Phenomenes implements Runnable {
    
    public abstract double Calcul(int temps);

    public void start()
    {
        Thread thr = new Thread(this); 
        thr.start(); // Attention : M�thode start() de la classe Thread !
    }    

    public abstract void run(); 
        
}
