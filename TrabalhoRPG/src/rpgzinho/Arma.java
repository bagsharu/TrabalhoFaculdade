package rpgzinho;

public abstract class Arma {
	
	private String nome;
	private double modDano;
	
	public Arma(String nome, double modDano) {
		this.nome = nome;
		this.modDano = modDano;
	}

	// Método Get para o nome da Arma
	public String getNome() {
		return nome;
	}

	// Método Get para o modificador de dano da Arma
	public double getModDano() {
		return modDano;
	}

}
