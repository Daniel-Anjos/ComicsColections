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
		Emprestimo emprestimo = new Emprestimo();		
		
		Scanner teclado = new Scanner(System.in);
		int opcao = 5;
		while (opcao != 0 ) {
			System.out.println("******************************************");
			System.out.println("*********** Comics Control ***************");
			System.out.println("------------------------------------------");
			System.out.println("Escolha uma op��o para Continuar \n");
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
					System.out.println("Escolha a op��o desejada: \n");
					System.out.println("1 - Criar Cole��o \n");
					System.out.println("2 - Nova Caixa \n");
					System.out.println("3 - Incluir Revista \n");
					System.out.println("4 - Cadastrar Amigo(a) \n");
					System.out.println("0 - Voltar ao Menu Anterior \n");
					selecao = teclado.nextInt();
					teclado.nextLine();

				switch (selecao) {
				case 1:
					System.out.println("**** Nova Cole��o ****");
					colection.cadastraColecao();
					mensagemPadrao();
					System.in.read();
					break;
				case 2:
					System.out.println("******* Nova Caixa ******* ");
					box.cadastraCaixa();
					mensagemPadrao();
					System.in.read();
					break;
				case 3:
					System.out.println("******* Cadastrar Revista **********");
					revista.cadastraRevista();
					break;
				case 4:
					System.out.println("******** Incluir Amigo(a) *********");
					amigo.cadastraAmigo();
					mensagemPadrao();
					System.in.read();
					break;
				case 0:
					break;
				default:
					System.out.println("Op��o inv�lida, tente novamente \n");
					break;
				}
			}
			break;
		case 2:
				selecao = 1;
				while (selecao != 0 ) {
					System.out.println("******************************************");
					System.out.println("*********** Menu de Empr�stimos **********");
					System.out.println("------------------------------------------");
					System.out.println("Escolha a op��o desejada: \n");
					System.out.println("1 - Novo Empr�stimo \n");
					System.out.println("2 - Consultar Empr�stimo \n");
					System.out.println("3 - Incluir Revista \n");
					System.out.println("0 - Voltar ao Menu Anterior \n");
					selecao = teclado.nextInt();
					teclado.nextLine();
				
				switch (selecao) {
				case 1:
					System.out.println("******* Novo Empr�stimo **********");
					emprestimo.novoEmprestimo();
					mensagemPadrao();
					System.in.read();
					break;
				case 2:
					System.out.println("Consultar Empr�stimo");
					break;
				case 3:
					System.out.println("Registrar Devolu��o");
					break;
				case 0:
					break;
				default:
					System.out.println("Op��o inv�lida, tente novamente \n");
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
				System.out.println("1 - Cole��es Dispon�veis \n");
				System.out.println("2 - Revistas \n");
				System.out.println("3 - Amigos(as) \n");
				System.out.println("0 - Voltar ao Menu Anterior \n");
				selecao = teclado.nextInt();
				teclado.nextLine();
			
			switch (selecao) {
			case 1:
				colection.imprimeColecoes();
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
				System.out.println("Op��o inv�lida, tente novamente \n");
				break;
			}
			}
			break;
			
		case 0:
			System.out.println("\n \n Obrigado Por Utilizar o Comics Control '_' ! ");
			break;
		default:
			System.out.println("Op��o inv�lida, tente novamente \n");
			break;
			}
		} teclado.close();
	} 
	
	
	
	
}
/*

criar novo array em cada classe (inserir no array cada novo objeto)
*/


//Para exibi��es utilizar um foreach para percorrer o array
//A cada cadastrar criamos um novo objeto da classe
//chamamos o m�todo cadastrar 
//incrmentamos o contador (verificar a utiliza��o em arraylist
//verificar se devemos fazer um add pro arraylist ou apenas incrementar o contador

