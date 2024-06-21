package rpgzinho;
import java.util.Scanner;

public class BatalhaTeste {

	public static void main(String[] args) {
		
		ArmaPaladino Espada = new Espada();
		Personagem paladino = new Paladino(10,6,4,Espada);
		
		ArmaClerigo Martelo = new Martelo();
		Personagem clerigo = new Clerigo(10,4,7,Martelo);
		
		// Teste de entrada_combate 1
		do {
			paladino.atacar(clerigo);
			paladino.printStatus();
			clerigo.printStatus();
			System.out.println("");
			//sclerigo.atacar(paladino);
			//clerigo.printStatus();
			//paladino.printStatus();
		}while(!paladino.estaMorto() && !clerigo.estaMorto());
		
		
		
		paladino.printStatus();
		clerigo.printStatus();
	}

}
