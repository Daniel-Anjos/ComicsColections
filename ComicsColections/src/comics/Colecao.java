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

	public void cadastraColecao() throws ParseException {
		Colecao c = new Colecao();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da Cole��o: \n");
		c.setNome(teclado.nextLine());
		colecao.add(c);
		System.out.println("\n");
		System.out.println("Cole��o adicionada com Suceso! \n");
	}
	public void imprimeColecoes() {
		System.out.println("\n");
		System.out.println("***** Cole��es cadastradas ***** ");
		for (Colecao imprime : colecao) {
			System.out.println(imprime);
		}
		System.out.println("\n");
	}
}
	

