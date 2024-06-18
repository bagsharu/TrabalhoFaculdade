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
		if(this.saude < 1)
			System.out.printf("%s [Saude: Morreu, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo,forca,destreza,arma.getNome());
		else
		System.out.printf("%s [Saude: %.1f, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo,saude,forca,destreza,arma.getNome());
	}
	
	// Método de ataque, recebe um objeto Personagem como alvo
	public void atacar(Personagem alvo) {
		// Se o personagem A não está morto...
		if (!this.estaMorto()) { 
			
			System.out.printf("O %s ataca o %s com %s.\n", this.nomeTipo, alvo.nomeTipo, arma.getNome());
			
			// Se a destreza de A é maior que de B e o mesmo não está morto.
			if ((this.destreza >= alvo.destreza) && !alvo.estaMorto()) {
				
				// Calcula o dano e ataca B.
				alvo.recebeDano(this.calculoDano());
				System.out.printf("O ataque foi efetivo com %.1f pontos de dano!\n", this.calculoDano());
			}
			// Se a destreza de A é menor que de B e o mesmo não está morto.
			else if((this.destreza < alvo.destreza) && !alvo.estaMorto()) {
				
				// Calcula o dano de B e ataca A.
				this.recebeDano(alvo.calculoDano());
				System.out.printf("O ataque foi inefetivo e revidado com %.1f pontos de dano!\n", alvo.calculoDano());
			}
			// Se ambas destrezas são iguais e B não está morto, ninguém perde saúde.
			else if((this.destreza == alvo.destreza) && !alvo.estaMorto()) {
				System.out.println("O ataque foi defendido, ninguém se machucou!");
			}
			
			// Se B estiver morto...
			else
				System.out.printf("Pare! O %s já está morto!\n", alvo.nomeTipo);
		}
		// Se o personagem estiver morto
		else
			System.out.printf("O %s não consegue atacar, pois está morto.\n", this.nomeTipo);
	}
	
	// Método para cálculo de dano, devolve o dano calculado
	public double calculoDano() {
		
		// Variável dano para o cálculo.
		double dano = this.forca * arma.getModDano();
		return dano;
	}
	
	// Método para sofrer dano, valor de pontos recebido como parâmetro
	public void recebeDano(double pontosDano) {
		this.saude = this.saude - pontosDano;
	}
	
	// Método para validar se o personagem está vivo
	public boolean estaMorto() {
		if (saude<1)
			return true;
	return false;
		
	}
}