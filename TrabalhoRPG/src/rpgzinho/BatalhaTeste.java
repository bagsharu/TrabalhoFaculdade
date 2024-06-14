package rpgzinho;

public class BatalhaTeste {

	public static void main(String[] args) {
		
		ArmaPaladino Espada = new Espada("Espada", 0.3);
		Personagem paladino = new Paladino("Paladino", 10,6,4,Espada);
		
		ArmaClerigo Martelo = new Martelo("Martelo", 0.6);
		Personagem clerigo = new Clerigo("Clerigo", 10,4,7,Martelo);
		
		
		paladino.atacar(clerigo);
		paladino.printStatus();
		clerigo.printStatus();
		System.out.println("");
		clerigo.atacar(paladino);
		clerigo.printStatus();
		paladino.printStatus();
		
	}

}
