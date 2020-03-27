package comics;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Emprestimo {
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Revista comic;
	private Amigo friend;
	ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
	Revista revista;
	Amigo amigo;
	
	public LocalDate getDataEmprestimo() {
		dataEmprestimo = LocalDate.now();
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = LocalDate.now();
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public Revista getComic() {
		return comic;
	}
	public void setComic(Revista comic) {
		this.comic = comic;
	}
	public Amigo getFriend() {
		return friend;
	}
	public void setFriend(Amigo friend) {
		this.friend = friend;
	}
	
	//@Override
	//public String toString() {
		//return this.getRevista();
	

	public void novoEmprestimo() throws ParseException {
		Emprestimo emprestimo = new Emprestimo();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da Revista: ");
		System.out.println("\n");
		//lembrar de marcar o atributo emprestimo ativo como true
		//Setar a revista como emprestada
		System.out.println("Empréstimo de Quantos dias? ");
		int diasDevolucao = teclado.nextInt();
		emprestimo.setDataDevolucao(getDataEmprestimo().plusDays(diasDevolucao));
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Data Emprestimo: " + emprestimo.getDataEmprestimo().format(formataData) );
		System.out.println("Data de Devolução: " + emprestimo.getDataDevolucao().format(formataData));
		System.out.println("\n");
		System.out.println("Empréstimo realizado com Suceso! \n");
	}
	public void emprestimosAtivos() {
		System.out.println("\n");
		System.out.println("***** Emprestimos ativos ***** ");
		for (Emprestimo imprime : emprestimo) {
			System.out.println(imprime);
		}
		System.out.println("\n");
	}
}
	
	
	
	
	

