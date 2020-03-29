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
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
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
		this.statusDevolvido = statusDevolvido;
	}
	public int getCodigoEmprestimo() {
		return codigoEmprestimo;
	}
	public void setCodigoEmprestimo(int codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
	
	
	@Override
	public String toString() {
		return ("Código Empréstimo: " + this.getCodigoEmprestimo() + "\n Amigo(a): " + this.getFriend().getNome() + "\n Edição da Revista: " + this.getComic().getNumeroEdicao() +
				"\n Coleção: " + this.getComic().getColecao().getNome() + "\n Data de Empréstimo: " + this.getDataEmprestimo().format(formataData) + "\n Data de Devolução: " + this.getDataDevolucao().format(formataData));
	}
	
	public void novoEmprestimo(Emprestimo loan, Revista revista, Amigo amigo) throws ParseException {
		loan = new Emprestimo();
                loan.setDataEmprestimo(LocalDate.now());
		codigoEmprestimo ++;
                System.out.println("Empréstimo número: "+ codigoEmprestimo);
		amigo.imprimeAmigosCadastrados();
		System.out.println("Informe o nome do(a) Amigo(a) para o empréstimo");
		String amigoEmprestimo = teclado.nextLine();
				for (int i = 0; i < amigo.friend.size(); i++) {
					if(amigo.friend.get(i).getNome().equals(amigoEmprestimo)) {
						if(amigo.friend.get(i).getEmprestimoAtivo() == true) {
							System.out.println("Este amigo(a) já possui Empréstimo ativo. Efetue a devolução para continuar!");
						}else {
							amigo.friend.get(i).setEmprestimoAtivo(true);
							loan.setFriend(amigo.friend.get(i));
						}
					}
				}
		revista.listarRevistas();
		System.out.println("Informe o número da Edição da Revista Desejada: ");
		System.out.println("\n");
		int edicaoRevista = (teclado.nextInt());
			    for (int i = 0; i < revista.revista.size(); i++) {
					if(revista.revista.get(i).getNumeroEdicao() == edicaoRevista) {
						if (revista.revista.get(i).getEmprestada() == true ) {
							System.out.println("Revista indisponível para empréstimo! ");
						}else {
							revista.revista.get(i).setEmprestada(true);
							loan.setComic(revista.revista.get(i));
						}
					}
			    }
		System.out.println("Empréstimo de Quantos dias? ");
		int diasDevolucao = teclado.nextInt();
		loan.setDataDevolucao(loan.getDataEmprestimo().plusDays(diasDevolucao));
		System.out.println("Data Emprestimo: " + loan.getDataEmprestimo().format(formataData));
		System.out.println("Data de Devolução: " + loan.getDataDevolucao().format(formataData));
		loan.setStatusDevolvido(false);
                loan.setCodigoEmprestimo(codigoEmprestimo);
		emprestimo.add(loan);
		System.out.println("Empréstimo realizado com Suceso! \n");
	}
	
	public void emprestimosAtivos() {
		System.out.println("\n");
		System.out.println("***** Empréstimos ativos ***** ");    
                System.out.println(" ");
		for (Emprestimo imprime : emprestimo) {
			if (imprime.getStatusDevolvido() == false) {
				System.out.println(imprime);
                                System.out.println("------------------");
			}
		}
	}
	
	public void emprestimosDevolvidos() {
		System.out.println("\n");
		System.out.println("***** Emprestimos Devolvidos ***** ");
                 System.out.println(" ");
                for (Emprestimo imprime : emprestimo) {
			if (imprime.getStatusDevolvido() == true) {
				System.out.println(imprime);
                                System.out.println("------------------");
                        }
		}
	}
	
	public void devolucaoEmprestimo(Amigo amigo, Revista revista, Emprestimo loan) {
                System.out.println("***** Menu Devoluções *******");
                this.emprestimosAtivos();
		System.out.println("Informe o código do empréstimo para Devolução");
		int codigoEmprestimo = teclado.nextInt();
		for (int i = 0; i < loan.emprestimo.size(); i++) {
			if (loan.emprestimo.get(i).getCodigoEmprestimo() == codigoEmprestimo) {
				if (loan.emprestimo.get(i).getStatusDevolvido() == true) {
					System.out.println("Este empréstimo já foi finalizado!");
				}else {
                                        loan.emprestimo.get(i).setStatusDevolvido(true);
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
                                    System.out.println("Status devolvido? "+ loan.emprestimo.get(i).getStatusDevolvido());
                                    System.out.println("****  Devolução realizada com Sucesso!  ******");
				}				
				
			}
					
		} clearBuffer(teclado);
	}
			
	private void clearBuffer(Scanner teclado) {
		if (teclado.hasNextLine()) {
			teclado.nextLine();
		}
		
	}
}
	
	
	
	
	

