package comics;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Colecao {
	private String nome;
	ArrayList<Colecao> colecao = new ArrayList<Colecao>();
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	public void cadastraColecao(Colecao colection) throws ParseException {
		colection = new Colecao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da Coleção:");
		colection.setNome(teclado.nextLine());
		colecao.add(colection);
		System.out.println("\n");
		System.out.println("Coleção adicionada com Suceso! ");
	}
	
	public void imprimeColecoes(Colecao colection) {
		System.out.println("\n");
		System.out.println("***** Coleções cadastradas ***** ");
		System.out.println("--------------------");
		for(Colecao imprime : colecao) {
			System.out.println(imprime);
			System.out.println("--------------------");
		}
		System.out.println("\n");
	}
}
	

