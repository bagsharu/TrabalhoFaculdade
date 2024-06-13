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
				System.out.println("O ataque foi defendido, ningu�m se machucou!");
			}
			else
				System.out.printf("Pare! O %s j� est� morto!\n", alvo.nomeTipo);
		}
		else
			System.out.printf("O %s n�o consegue atacar, pois est� morto.\n");
	}
	
	// M�todo para c�lculo de dano, devolve o dano calculado
	public double calculoDano() {
		double dano = this.forca * arma.getModDano();
		return dano;
	}
	
	// M�todo para receber dano, recebe como par�metro o valor recebido
	public void recebeDano(double pontosDano) {
		this.saude = this.saude - pontosDano;
	}
	
	// M�todo para validar se o personagem est� vivo
	public boolean estaMorto() {
		if (saude>=1)
			return false;
	return true;
		
	}
}