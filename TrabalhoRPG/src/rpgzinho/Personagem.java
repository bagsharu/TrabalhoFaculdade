package rpgzinho;

public abstract class Personagem {
	
	// Atributos de cada Personagem
	private String nomeTipo;
	private double saude, forca, destreza;
	private Arma arma;
	
	// Método construtor da classe Personagem
	public Personagem(String nomeTipo,double saude, double forca, double destreza, Arma arma) {
		
		this.nomeTipo = nomeTipo; //"Mago, Paladino ou Clérigo"
		this.saude = saude; 	  // [0.0 - 10.0]
		this.forca = forca; 	  // [0.0 - 10.0]
		this.destreza = destreza; // [0.0 - 10.0]
		this.arma = arma;		  // Armas especifícas de cada Classe
	}
	
	// Método de impressão do status de personagem
	public void printStatus() {
		System.out.printf("%s [Saude: %.f, Forca: %.f, Destreza: %.f, %s]\n", nomeTipo,saude,forca,destreza,arma.getNome());
	}
	
	// Método de ataque, recebe um objeto Personagem como alvo
	public void atacar(Personagem alvo) {
		
	}
	
	// Método para cálculo de dano, devolve o dano calculado
	public double calculoDano() {
	}
	
	// Método para receber dano, recebe como parâmetro o valor recebido
	public void recebeDano() {
		
	}
	
	// Método para validar se o personagem está vivo
	public boolean estaMorto() {
		if (saude<1)
			return true;
	return false;
		
	}
}