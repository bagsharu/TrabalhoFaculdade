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
		if(this.saude < 1)
			System.out.printf("%s [Saude: Morreu, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo,forca,destreza,arma.getNome());
		else
		System.out.printf("%s [Saude: %.1f, Forca: %.1f, Destreza: %.1f, %s]\n", nomeTipo,saude,forca,destreza,arma.getNome());
	}
	
	// M�todo de ataque, recebe um objeto Personagem como alvo
	public void atacar(Personagem alvo) {
		// Se o personagem A n�o est� morto...
		if (!this.estaMorto()) { 
			
			System.out.printf("O %s ataca o %s com %s.\n", this.nomeTipo, alvo.nomeTipo, arma.getNome());
			
			// Se a destreza de A � maior que de B e o mesmo n�o est� morto.
			if ((this.destreza >= alvo.destreza) && !alvo.estaMorto()) {
				
				// Calcula o dano e ataca B.
				alvo.recebeDano(this.calculoDano());
				System.out.printf("O ataque foi efetivo com %.1f pontos de dano!\n", this.calculoDano());
			}
			// Se a destreza de A � menor que de B e o mesmo n�o est� morto.
			else if((this.destreza < alvo.destreza) && !alvo.estaMorto()) {
				
				// Calcula o dano de B e ataca A.
				this.recebeDano(alvo.calculoDano());
				System.out.printf("O ataque foi inefetivo e revidado com %.1f pontos de dano!\n", alvo.calculoDano());
			}
			// Se ambas destrezas s�o iguais e B n�o est� morto, ningu�m perde sa�de.
			else if((this.destreza == alvo.destreza) && !alvo.estaMorto()) {
				System.out.println("O ataque foi defendido, ningu�m se machucou!");
			}
			
			// Se B estiver morto...
			else
				System.out.printf("Pare! O %s j� est� morto!\n", alvo.nomeTipo);
		}
		// Se o personagem estiver morto
		else
			System.out.printf("O %s n�o consegue atacar, pois est� morto.\n", this.nomeTipo);
	}
	
	// M�todo para c�lculo de dano, devolve o dano calculado
	public double calculoDano() {
		
		// Vari�vel dano para o c�lculo.
		double dano = this.forca * arma.getModDano();
		return dano;
	}
	
	// M�todo para sofrer dano, valor de pontos recebido como par�metro
	public void recebeDano(double pontosDano) {
		this.saude = this.saude - pontosDano;
	}
	
	// M�todo para validar se o personagem est� vivo
	public boolean estaMorto() {
		if (saude<1)
			return true;
	return false;
		
	}
}