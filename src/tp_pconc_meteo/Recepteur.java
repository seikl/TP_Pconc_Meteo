/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp_pconc_meteo;

/**
 *
 * @author skl
 */
public class Recepteur {
    		
		Observateur monObs;
		
		public Recepteur(Observateur obs){
			this.monObs = obs;
		}
		
		synchronized public void essaiEchange(int i, int j){
			if (monObs.getStatus(j)=='Y'){
				notify();
				System.out.println("l'�change aura lieu entre "+ i + " et "+j);
			} else {
				while (monObs.getStatus(j)!='Y'){
					System.out.println("on bloque le thread courant "+i);
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("on vient de d�bloquer le thread courant "+i);
				
			}
		}
		
		synchronized public void gestionStatus(int i,int j,int k){
			System.out.println("le pompier "+i+" change d'�tat. Il veut passer � "+k);
			monObs.modifStatus(i,k); //changement de status
			if (monObs.getStatus(i)=='Y') {
				System.out.println("on veut un �change entre "+i+" et "+j);
				essaiEchange(i,j);
			}
			System.out.println("le vecteur courant vaut "+monObs.getStatus(1)+" "+monObs.getStatus(2)+" "+monObs.getStatus(3));
		}
	}
