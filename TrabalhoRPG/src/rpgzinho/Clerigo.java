package rpgzinho;

public class Clerigo extends Personagem{

	public Clerigo(String nomeTipo, double saude, double forca, double destreza, Arma arma) {
		super(nomeTipo, saude, forca, destreza, arma);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printStatus() {
		System.out.printf("Clérigo [Saude: %.f, Forca: %.f, DEstreza: %.f, " + arma.getNome());
	}

	@Override
	public void atacar(Personagem alvo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculoDano() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recebeDano() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaMorto() {
		// TODO Auto-generated method stub
		return false;
	}

}
