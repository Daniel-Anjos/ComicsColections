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
	private int codigoEmprestimo;
	private boolean statusDevolvido;
	ArrayList<Emprestimo> emprestimo = new ArrayList<Emprestimo>();
	Revista revista;
	Amigo amigo;
	Scanner teclado = new Scanner(System.in);
	
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
	public boolean getStatusDevolvido () {
		return statusDevolvido;
	}
	public void setStatusDevolvido(boolean statusDevolvido) {
		this.statusDevolvido = false;
	}
	public int getCodigoEmprestimo() {
		return codigoEmprestimo;
	}
	public void setCodigoEmprestimo(int codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
	
	
	@Override
	public String toString() {
		return ("C�digo Empr�stimo: " + this.getCodigoEmprestimo() + "\n Amigo(a): " + this.getFriend() + "\n Edi��o da Revista: " + this.getComic() +
				"\n Cole��o: " + revista.getColecao() + "\n Data de Empr�stimo: " + this.getDataEmprestimo() + "Data de Devolu��o: " + this.getDataDevolucao());
	}
	
	public void novoEmprestimo(Emprestimo loan, Revista revista, Amigo amigo) throws ParseException {
		loan = new Emprestimo();
		setCodigoEmprestimo(codigoEmprestimo ++);
		amigo.imprimeAmigosCadastrados();
		System.out.println("Selecione Amigo(a) para o empr�stimo");
		String amigoEmprestimo = teclado.nextLine();
				for (int i = 0; i < amigo.friend.size(); i++) {
					if(amigo.friend.get(i).getNome().equals(amigoEmprestimo)) {
						if(amigo.friend.get(i).getEmprestimoAtivo() == true) {
							System.out.println("Este amigo(a) j� possui Empr�stimo ativo. Efetue a devolu��o para continuar!");
						}else {
							amigo.friend.get(i).setEmprestimoAtivo(true);
							loan.setFriend(amigo.friend.get(i));
						}
					}
				}
		revista.listarRevistas();
		System.out.println("Informe o n�mero da Edi��o da Revista Desejada: ");
		System.out.println("\n");
		int edicaoRevista = (teclado.nextInt());
			    for (int i = 0; i < revista.revista.size(); i++) {
					if(revista.revista.get(i).getNumeroEdicao() == edicaoRevista) {
						if (revista.revista.get(i).getEmprestada() == true ) {
							System.out.println("Revista indispon�vel para empr�stimo! ");
						}else {
							revista.revista.get(i).setEmprestada(true);
							loan.setComic(revista.revista.get(i));
						}
					}
			    }
		System.out.println("Empr�stimo de Quantos dias? ");
		int diasDevolucao = teclado.nextInt();
		loan.setDataDevolucao(getDataEmprestimo().plusDays(diasDevolucao));
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Data Emprestimo: " + loan.getDataEmprestimo().format(formataData));
		System.out.println("Data de Devolu��o: " + loan.getDataDevolucao().format(formataData));
		System.out.println("\n");
		emprestimo.add(loan);
		System.out.println("Empr�stimo realizado com Suceso! \n");
	}
	
	public void emprestimosAtivos() {
		System.out.println("\n");
		System.out.println("***** Emprestimos ativos ***** ");
		for (Emprestimo imprime : emprestimo) {
			if (imprime.getStatusDevolvido() == false) {
				System.out.println(imprime);
			}
		}
		System.out.println("\n");
	}
	
	public void emprestimosDevolvidos() {
		System.out.println("\n");
		System.out.println("***** Emprestimos Devolvidos ***** ");
		for (Emprestimo imprime : emprestimo) {
			if (imprime.getStatusDevolvido() == true) {
			System.out.println(imprime);
		}
		}
		System.out.println("\n");
	}
	
	public void devolucaoEmprestimo(Amigo amigo, Revista revista, Emprestimo loan) {
		System.out.println("Informe o c�digo do empr�stimo para Devolu��o");
		int codigoEmprestimo = teclado.nextInt();
		for (int i = 0; i < loan.emprestimo.size(); i++) {
			if (loan.emprestimo.get(i).getCodigoEmprestimo() == codigoEmprestimo) {
				if (loan.emprestimo.get(i).getStatusDevolvido() == true) {
					System.out.println("Este empr�stimo j� foi finalizado!");
				}else {
					String amigoEmprestimo = loan.emprestimo.get(i).getFriend().getNome();
					for (int x = 0; x < amigo.friend.size(); x++) {
						if(amigo.friend.get(x).getNome().equals(amigoEmprestimo)) {
								amigo.friend.get(x).setEmprestimoAtivo(false);
							}
						}
					int edicaoRevista = loan.emprestimo.get(i).getComic().getNumeroEdicao();
				    for (int y = 0; y < revista.revista.size(); y++) {
						if(revista.revista.get(y).getNumeroEdicao() == edicaoRevista) {
								revista.revista.get(y).setEmprestada(false);
							}
						}
				}				
				loan.emprestimo.get(i).setStatusDevolvido(false);
			}
					
		}
	}
			
	
}
	
	
	
	
	

