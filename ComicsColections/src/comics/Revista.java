package comics;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Revista {
	private int numeroEdicao;
	private int ano;
	private Caixa caixa;
	private Colecao colecao;
	private boolean emprestada;
	ArrayList<Revista> revista = new ArrayList<Revista>();
		
	public int getNumeroEdicao() {
		return numeroEdicao;
	}
	public void setNumeroEdicao(int numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public Caixa getCaixa() {
		return caixa;
	}
	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	public boolean getEmprestada() {
		return emprestada;
	}
	public void setEmprestada(boolean emprestada) {
		this.emprestada = emprestada;
	}
	@Override
	public String toString() {
		return ("Edição: " + this.getNumeroEdicao() + "\n Ano: " + this.getAno() + "\n Caixa: " + this.getCaixa().getNumeroCaixa() +
				"\n Coleção: " + this.getColecao().getNome() + "\n Emprestada? " + this.getEmprestada());
	}
	
	public void cadastraRevista(Caixa caixa, Colecao colecao, Revista comic) throws ParseException {
		comic = new Revista();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o Número da Edição:");
		comic.setNumeroEdicao(teclado.nextInt());
		System.out.println("Ano - YYYY:");
		comic.setAno(teclado.nextInt());
		System.out.println("\n");
		caixa.listarCaixas();
		System.out.println("Informe o número da caixa desejada: ");
		int codCaixa = (teclado.nextInt());
		comic.setCaixa(caixa.caixa.get(codCaixa - 1));
		clearBuffer(teclado);
		colecao.imprimeColecoes(colecao);
		System.out.println("Informe o nome da Coleção: ");
		String nomeColecao = (teclado.nextLine());
	    for (int i = 0; i < colecao.colecao.size(); i++) {
			if(colecao.colecao.get(i).getNome().equals(nomeColecao)) {
				comic.setColecao(colecao.colecao.get(i));
			}
		}
		comic.setEmprestada(false);
		System.out.println("\n");
		revista.add(comic);
		System.out.println("Revista cadastrada com Suceso! ");
	}
	
	private void clearBuffer(Scanner teclado) {
		if (teclado.hasNextLine()) {
			teclado.nextLine();
		}
		
	}
	public void listarRevistas() {
		System.out.println("***** Catálogo de Revistas ***** \n");
		for (Revista imprime : revista) {
			System.out.println(imprime);
			System.out.println("--------------------");
		}
	}
	
	
}













