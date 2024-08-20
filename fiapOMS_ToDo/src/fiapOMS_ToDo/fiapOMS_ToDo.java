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
	// para poder ser utilizado em v�rios m�todos
	public static Scanner teclado = new Scanner(System.in);

	/*******************************************************************
	 *
	 * TAREFA 1: Defina a classe Boia que implemente o registro Boia.
	 *
	 *******************************************************************/
		
	/*******************************************************************
	 *
	 * TAREFA 2: Implemente uma fun��o que usando as coordenadas 
	 * informadas gere o hash code de cada Boia.
	 *
	 *******************************************************************/

	/*******************************************************************
	 *
	 * TAREFA 3: Altere a fun��o geraVetorBoias para que, usando o arquivo 
	 * coordenadas.txt obtenha as coordenadas onde cada boia foi instalada, 
	 * e da leitura do arquivo o atributo chamado de coordenadas � armazenado 
	 * em cada elemento do vetor de registros Boia. 
	 *
	 * A fun��o da TAREFA 2 deve ser chamada para gerar o hash code e este 
	 * ser armazenado no atributo correspondente.
	 *
	 * O vetor gerado deve ser usado no m�todo main, ou seja, "par�metros
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

			// la�o para ler linha por linha at� o final do arquivo
			while (leArq.hasNextLine())
			{
				// l� a pr�xima linha
				String linha = leArq.nextLine();

				/*
				 * Cria um registro para armazenar coordenadas e gera hash code.
				 * Armazena registro como n-�simo elemento do vetor boias.
				 */
				n++;
			}
		}
		catch (FileNotFoundException e)
		{
			// caso o arquivo n�o seja encontrado
			System.out.println("Arquivo n�o encontrado: " + e.getMessage());
		}

		return n;
	}

	/*******************************************************************
	 *
	 * TAREFA 4: Implemente uma fun��o que percorre todo o vetor de registros
	 * de boias lendo do teclado as medidas de salinidade e temperatura.
	 *
	 *******************************************************************/

	/*******************************************************************
	 *
	 * TAREFA 5: Implemente um dos m�todos de ordena��o
	 * para ordenar em ordem crescente de hash code.
	 *
	 * Obrigatoriamente utilizando um dos algoritmos
	 * de ordena��o estudados no 1� semestre.
	 *
	 *******************************************************************/	

	/*******************************************************************
	 *
	 * TAREFA 6: Implemente o m�todo de busca bin�ria para
	 * pesquisar asmedidas de 1 boia a partir do hash code.
	 *
	 * Obrigatoriamente utilizando o algoritmo
	 * de busca bin�ria estudado no 1� semestre.
	 *
	 *******************************************************************/

	public static void main(String[] args)
	{
		// declara��o das vari�veis necess�rias para a aplica��o
		
		// cria��o do menu
		int opcao;

		do
		{
			System.out.println("0 - Sair");
			System.out.println("1 - Apresenta��o das boias");
			System.out.println("2 - Insere mais 1 boia");
			System.out.println("3 - Atualiza medidas");
			System.out.println("4 - Pesquisa medidas");
			System.out.print("Digite a op��o desejada: ");
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
					System.out.println("Op��o INV�LIDA!");
			}
		} while (opcao != 0);

		// fecha o objeto da classe Scanner
		teclado.close();
	}
}
