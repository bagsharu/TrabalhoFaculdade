package rpgzinho;

public abstract class Personagem {
	
	// Atributos de cada Personagem
	private String nomeTipo;
	private double saude, forca, destreza;
	private Arma arma;
	
	// M�todo construtor da classe Personagem
	public Personagem(String nomeTipo,double saude, double forca, double destreza, Arma arma) {
		
		this.nomeTipo = nomeTipo; //"Mago, Paladino ou Cl�rigo"
		this.saude = saude; 	  // [0.0 - 10.0]
		this.forca = forca; 	  // [0.0 - 10.0]
		this.destreza = destreza; // [0.0 - 10.0]
		this.arma = arma;		  // Armas especif�cas de cada Classe
	}
	
	// M�todo de impress�o do status de personagem
	public void printStatus() {
		System.out.printf("%s [Saude: %.f, Forca: %.f, Destreza: %.f, %s]\n", nomeTipo,saude,forca,destreza,arma.getNome());
	}
	
	// M�todo de ataque, recebe um objeto Personagem como alvo
	public void atacar(Personagem alvo) {
		
	}
	
	// M�todo para c�lculo de dano, devolve o dano calculado
	public double calculoDano() {
	}
	
	// M�todo para receber dano, recebe como par�metro o valor recebido
	public void recebeDano() {
		
	}
	
	// M�todo para validar se o personagem est� vivo
	public boolean estaMorto() {
		if (saude<1)
			return true;
	return false;
		
	}
}