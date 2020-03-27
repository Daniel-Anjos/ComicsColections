package comics;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Amigo {
	
	private String nome;
	private String telefone;
	private String localAmigo;
	private boolean emprestimoAtivo;
	ArrayList<Amigo> friend = new ArrayList<Amigo>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getLocalAmigo() {
		return localAmigo;
	}
	public void setLocalAmigo(String localAmigo) {
		this.localAmigo = localAmigo;
	}
	public boolean getEmprestimoAtivo() {
		return emprestimoAtivo;
	}
	public void setEmprestimoAtivo(boolean emprestimoAtivo) {
		this.emprestimoAtivo = emprestimoAtivo;
	}
	@Override
	public String toString() {
		return ("Nome: " + this.getNome() + "\n Telefone: " + this.getTelefone() + "\n Local/Departamento: " + this.getLocalAmigo()+
				"\n Empréstimos Ativos: " + this.getEmprestimoAtivo());
	}
	
	
	public void cadastraAmigo() throws ParseException {
		Amigo amigo = new Amigo();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o Nome:");
		amigo.setNome(teclado.nextLine());
		System.out.println("Telefone - (DD)XXXX-XXXX : ");
		amigo.setTelefone(teclado.nextLine());
		System.out.println("Local/Departamento: ");
		amigo.setLocalAmigo(teclado.nextLine());
		amigo.setEmprestimoAtivo(false);
		System.out.println("\n");
		friend.add(amigo);
		System.out.println("Amigo(a) cadastrado com Suceso! ");
	}
	public void imprimeAmigosCadastrados() {
		System.out.println("***** Amigos e Amigas cadastrados ***** \n");
		for (Amigo imprime : friend) {
			System.out.println(imprime);
			System.out.println("--------------------");
		}
		System.out.println("\n");
	}
}
