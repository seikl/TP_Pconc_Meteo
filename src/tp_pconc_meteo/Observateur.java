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
public class Observateur {
	char monVecteur[]={'R','V','V'};
	char valPompier1[]={'R','P','X','V'};
	char valPompier2[]={'P','Y','V','X'};
	char valPompier3[]={'A','V','Y','P'};
	
/*	Ne sert plus ici. Ce sont les récepteurs qui assument 
 * synchronized public void ecrirePompier(int i,int j){
		System.out.println("le pompier "+i+" change d'état. Il passe à "+j);
		if (i==1){monVecteur[i-1]=valPompier1[j-1];}
		if (i==2){monVecteur[i-1]=valPompier2[j-1];}
		if (i==3){monVecteur[i-1]=valPompier3[j-1];}

		System.out.println("le vecteur courant vaut "+monVecteur[0]+" "+monVecteur[1]+" "+monVecteur[2]);
	}
*/
	synchronized  char getStatus(int i){
		return monVecteur[i-1];
	}

	synchronized  void modifStatus(int i, int k){
		if (i==1) {monVecteur[0]=valPompier1[k];}
		if (i==2) {monVecteur[1]=valPompier2[k];}
		if (i==3) {monVecteur[2]=valPompier3[k];}
	}

}
