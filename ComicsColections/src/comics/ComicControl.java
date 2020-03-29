package comics;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


public class ComicControl {
	public static void mensagemPadrao() {
		System.out.println("\n");
		System.out.println("Pressione Enter para Continuar");
	}
	

	public static void main(String[] args) throws ParseException, IOException {
		Colecao colection = new Colecao();
		Caixa box = new Caixa();
		Revista revista = new Revista();
		Amigo amigo = new Amigo();
		Emprestimo loan = new Emprestimo();		
		
		Scanner teclado = new Scanner(System.in);
		int opcao = 5;
		while (opcao != 0 ) {
			System.out.println("******************************************");
			System.out.println("*********** Comics Control ***************");
			System.out.println("------------------------------------------");
			System.out.println("Escolha uma opção para Continuar \n");
			System.out.println("1 - Cadastros \n");
			System.out.println("2 - Emprestimos \n");
			System.out.println("3 - Consultas \n");
			System.out.println("0 - Sair \n");
			opcao = teclado.nextInt();
			teclado.nextLine();
		
		switch (opcao) {
		case 1:
				int selecao = 1;
				while (selecao != 0 ) {
					System.out.println("******************************************");
					System.out.println("*********** Menu de Cadastros ************");
					System.out.println("------------------------------------------");
					System.out.println("Escolha a opção desejada: \n");
					System.out.println("1 - Criar Coleção \n");
					System.out.println("2 - Nova Caixa \n");
					System.out.println("3 - Incluir Revista \n");
					System.out.println("4 - Cadastrar Amigo(a) \n");
					System.out.println("0 - Voltar ao Menu Anterior \n");
					selecao = teclado.nextInt();
					teclado.nextLine();

				switch (selecao) {
				case 1:
					System.out.println("**** Nova Coleção ****");
					colection.cadastraColecao(colection);
					mensagemPadrao();
					System.in.read();
					break;
				case 2:
					System.out.println("******* Nova Caixa ******* ");
					box.cadastraCaixa(box);
					mensagemPadrao();
					System.in.read();
					break;
				case 3:
					System.out.println("******* Cadastrar Revista **********");
					revista.cadastraRevista(box, colection, revista);
					mensagemPadrao();
					System.in.read();
					break;
				case 4:
					System.out.println("******** Incluir Amigo(a) *********");
					amigo.cadastraAmigo(amigo);
					mensagemPadrao();
					System.in.read();
					break;
				case 0:
					break;
				default:
					System.out.println("Opção inválida, tente novamente \n");
					break;
				}
			}
			break;
		case 2:
				selecao = 1;
				while (selecao != 0 ) {
					System.out.println("******************************************");
					System.out.println("*********** Menu de Empréstimos **********");
					System.out.println("------------------------------------------");
					System.out.println("Escolha a opção desejada: \n");
					System.out.println("1 - Novo Empréstimo \n");
					System.out.println("2 - Consultar Empréstimos Ativos \n");
					System.out.println("3 - Consultar Devolvidos \n");
					System.out.println("4 - Registrar Devolução \n");
					System.out.println("0 - Voltar ao Menu Anterior \n");
					selecao = teclado.nextInt();
				
				switch (selecao) {
				case 1:
					System.out.println("********* Novo Empréstimo **********");
					loan.novoEmprestimo(loan, revista, amigo);
					mensagemPadrao();
					System.in.read();
					break;
				case 2:
					loan.emprestimosAtivos();
					mensagemPadrao();
					System.in.read();
                                        break;
				case 3:
					loan.emprestimosDevolvidos();
					mensagemPadrao();
					System.in.read();
                                        break;
				case 4:
					loan.devolucaoEmprestimo(amigo, revista, loan);
					mensagemPadrao();
					System.in.read();
					break;
				case 0:                        
					break;
				default:
					System.out.println("Opção inválida, tente novamente \n");
					break;
				}
			}
			break;
		case 3:
			selecao = 1;
			while (selecao != 0 ) {
				System.out.println("******************************************");
				System.out.println("*********** Menu de Consultas ************");
				System.out.println("------------------------------------------");
				System.out.println("Escolha a consulta desejada: \n");
				System.out.println("1 - Coleções Disponíveis \n");
				System.out.println("2 - Revistas \n");
				System.out.println("3 - Amigos(as) \n");
				System.out.println("0 - Voltar ao Menu Anterior \n");
				selecao = teclado.nextInt();
				teclado.nextLine();
			
			switch (selecao) {
			case 1:
				colection.imprimeColecoes(colection);
				mensagemPadrao();
				System.in.read();
				break;
			case 2:
				revista.listarRevistas();
				mensagemPadrao();
				System.in.read();
				break;
			case 3:
				amigo.imprimeAmigosCadastrados();
				mensagemPadrao();
				System.in.read();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida, tente novamente \n");
				break;
			}
			}
			break;
			
		case 0:
			System.out.println("\n \n Obrigado Por Utilizar o Comics Control '_' ! ");
			break;
		default:
			System.out.println("Opção inválida, tente novamente \n");
			break;
			}
		} teclado.close();
	} 
	
	
	
	
}
