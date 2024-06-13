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
		if (!this.estaMorto()) {
			System.out.printf("O %s ataca o %s com <arma>.\n", this.nomeTipo, alvo.nomeTipo);
			if ((this.destreza >= alvo.destreza) || !alvo.estaMorto()) {
				alvo.recebeDano(this.calculoDano());
				System.out.printf("O ataque foi efetivo com %.f pontos de dano!\n", this.calculoDano());
			}
			else if((this.destreza < alvo.destreza) || !alvo.estaMorto()) {
				this.recebeDano(alvo.calculoDano());
				System.out.printf("O ataque foi inefetivo e revidado com %.f pontos de dano!\n", alvo.calculoDano());
			}
			else if((this.destreza == alvo.destreza) || !alvo.estaMorto()) {
				System.out.println("O ataque foi defendido, ninguém se machucou!");
			}
			else
				System.out.printf("Pare! O %s já está morto!\n", alvo.nomeTipo);
		}
		else
			System.out.printf("O %s não consegue atacar, pois está morto.\n");
	}
	
	// Método para cálculo de dano, devolve o dano calculado
	public double calculoDano() {
		double dano = this.forca * arma.getModDano();
		return dano;
	}
	
	// Método para receber dano, recebe como parâmetro o valor recebido
	public void recebeDano(double pontosDano) {
		this.saude = this.saude - pontosDano;
	}
	
	// Método para validar se o personagem está vivo
	public boolean estaMorto() {
		if (saude>=1)
			return false;
	return true;
		
	}
}