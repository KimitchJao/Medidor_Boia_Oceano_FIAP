////////////////////////////////
//
// FIAP Ocean Monitoring System
//
////////////////////////////////
package fiapOMS_ToDo;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class fiapOMS_ToDo
{
	public static final int BOIAS = 20;

	// objeto da classe Scanner deve ser global
	// para poder ser utilizado em vários métodos
	public static Scanner teclado = new Scanner(System.in);

	/*******************************************************************
	 *
	 * TAREFA 1: Defina a classe Boia que implemente o registro Boia.
	 *
	 *******************************************************************/
		
	/*******************************************************************
	 *
	 * TAREFA 2: Implemente uma função que usando as coordenadas 
	 * informadas gere o hash code de cada Boia.
	 *
	 *******************************************************************/

	/*******************************************************************
	 *
	 * TAREFA 3: Altere a função geraVetorBoias para que, usando o arquivo 
	 * coordenadas.txt obtenha as coordenadas onde cada boia foi instalada, 
	 * e da leitura do arquivo o atributo chamado de coordenadas é armazenado 
	 * em cada elemento do vetor de registros Boia. 
	 *
	 * A função da TAREFA 2 deve ser chamada para gerar o hash code e este 
	 * ser armazenado no atributo correspondente.
	 *
	 * O vetor gerado deve ser usado no método main, ou seja, "parâmetros
	 * precisam ser passados".
	 *
	 *******************************************************************/

	public static int geraVetorBoias()
	{
		// caminho do arquivo
		String caminhoDoArquivo = "C:\\Users\\sergi\\eclipse-workspace\\fiapOMS_ToDo\\src\\coordenadas.txt";
		int n = 0;
		try
		{
			// cria um objeto File com o caminho do arquivo
			File arquivo = new File(caminhoDoArquivo);

			// cria um objeto Scanner para ler o arquivo
			Scanner leArq = new Scanner(arquivo);

			// laço para ler linha por linha até o final do arquivo
			while (leArq.hasNextLine())
			{
				// lê a próxima linha
				String linha = leArq.nextLine();

				/*
				 * Cria um registro para armazenar coordenadas e gera hash code.
				 * Armazena registro como n-ésimo elemento do vetor boias.
				 */
				n++;
			}
		}
		catch (FileNotFoundException e)
		{
			// caso o arquivo não seja encontrado
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}

		return n;
	}

	/*******************************************************************
	 *
	 * TAREFA 4: Implemente uma função que percorre todo o vetor de registros
	 * de boias lendo do teclado as medidas de salinidade e temperatura.
	 *
	 *******************************************************************/

	/*******************************************************************
	 *
	 * TAREFA 5: Implemente um dos métodos de ordenação
	 * para ordenar em ordem crescente de hash code.
	 *
	 * Obrigatoriamente utilizando um dos algoritmos
	 * de ordenação estudados no 1º semestre.
	 *
	 *******************************************************************/	

	/*******************************************************************
	 *
	 * TAREFA 6: Implemente o método de busca binária para
	 * pesquisar asmedidas de 1 boia a partir do hash code.
	 *
	 * Obrigatoriamente utilizando o algoritmo
	 * de busca binária estudado no 1º semestre.
	 *
	 *******************************************************************/

	public static void main(String[] args)
	{
		// declaração das variáveis necessárias para a aplicação
		
		// criação do menu
		int opcao;

		do
		{
			System.out.println("0 - Sair");
			System.out.println("1 - Apresentação das boias");
			System.out.println("2 - Insere mais 1 boia");
			System.out.println("3 - Atualiza medidas");
			System.out.println("4 - Pesquisa medidas");
			System.out.print("Digite a opção desejada: ");
			opcao = teclado.nextInt();
			switch (opcao)
			{
				case 0:
					System.out.println("\nEncerrando o programa...");
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Opção INVÁLIDA!");
			}
		} while (opcao != 0);

		// fecha o objeto da classe Scanner
		teclado.close();
	}
}
