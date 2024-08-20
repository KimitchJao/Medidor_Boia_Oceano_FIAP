package fiapOMS_ToDo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Boia {
    private static int contador = 1; // Contador estático para garantir IDs únicos e sequenciais
    private int id;
    private String coordenadas;
    private int hashCode;
    private double salinidade;
    private double temperatura;

    public Boia(String coordenadas) {
        this.id = contador++;
        this.coordenadas = coordenadas;
        this.hashCode = generateHashCode(coordenadas);
    }

    private int generateHashCode(String coordenadas) {
        // Gera o hash code usando os caracteres 1, 2, 8 e 9 da string da coordenada
        char c1 = coordenadas.charAt(1);
        char c2 = coordenadas.charAt(2);
        char c8 = coordenadas.charAt(8);
        char c9 = coordenadas.charAt(9);
        return Integer.parseInt("" + c1 + c2 + c8 + c9);
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public int getHashCode() {
        return hashCode;
    }

    public double getSalinidade() {
        return salinidade;
    }

    public void setSalinidade(double salinidade) {
        this.salinidade = salinidade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Boia [id=" + id + ", coordenadas=" + coordenadas + ", hashCode=" + hashCode + ", salinidade=" + salinidade
                + ", temperatura=" + temperatura + "]";
    }
}

public class FIAPOceanMonitoringSystem {

    public static List<Boia> readCoordenadas(String filename) throws IOException {
        List<Boia> boias = new ArrayList<>();
        BufferedReader br = null;
        try {
            File file = new File(filename);
            System.out.println("Tentando ler o arquivo: " + file.getAbsolutePath());
            if (file.exists() && file.isFile()) {
                System.out.println("Arquivo encontrado: " + file.getAbsolutePath());
                br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    Boia boia = new Boia(line);
                    boias.add(boia);
                }
            } else {
                System.out.println("Arquivo não encontrado ou não é um arquivo: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de coordenadas: " + e.getMessage());
            throw e;
        } finally {
            if (br != null) {
                br.close();
            }
        }
        return boias;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Boia> boias;
        
        try {
            // Caminho absoluto do seu arquivo coordenadas.txt
            String filePath = "C:\\Users\\l1lg4\\Desktop\\Facul\\fiapOMS_ToDo@GS.1-2024\\fiapOMS_ToDo\\src\\fiapOMS_ToDo\\coordenadas.txt";
            System.out.println("Lendo arquivo de coordenadas: " + filePath);
            boias = readCoordenadas(filePath);
            if (boias.isEmpty()) {
                System.out.println("Nenhuma boia foi lida do arquivo.");
            } else {
                System.out.println("Arquivo de coordenadas lido com sucesso.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de coordenadas.");
            return;
        }

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Apresentação das Boias");
            System.out.println("2. Inserção de Boia");
            System.out.println("3. Atualização de Medidas");
            System.out.println("4. Pesquisa Medidas");
            System.out.println("0. Encerrar o programa");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir a quebra de linha

            switch (opcao) {
                case 1:
                    apresentarBoias(boias);
                    break;
                case 2:
                    inserirBoia(scanner, boias);
                    break;
                case 3:
                    atualizarMedidas(scanner, boias);
                    break;
                case 4:
                    pesquisarMedidas(scanner, boias);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private static void apresentarBoias(List<Boia> boias) {
        for (Boia boia : boias) {
            System.out.println(boia);
        }
    }

    private static void inserirBoia(Scanner scanner, List<Boia> boias) {
        System.out.println("Digite as coordenadas da boia:");
        String coordenadas = scanner.nextLine();
        
        // Verificar se a coordenada já existe
        for (Boia boia : boias) {
            if (boia.getCoordenadas().equals(coordenadas)) {
                System.out.println("Boia com essas coordenadas já existe.");
                return;
            }
        }

        Boia novaBoia = new Boia(coordenadas);
        System.out.println("Digite a salinidade:");
        novaBoia.setSalinidade(scanner.nextDouble());
        System.out.println("Digite a temperatura:");
        novaBoia.setTemperatura(scanner.nextDouble());
        boias.add(novaBoia);
        System.out.println("Boia inserida com sucesso.");
    }

    private static void atualizarMedidas(Scanner scanner, List<Boia> boias) {
        System.out.println("Digite as coordenadas da boia para atualizar:");
        String coordenadas = scanner.nextLine();

        for (Boia boia : boias) {
            if (boia.getCoordenadas().equals(coordenadas)) {
                System.out.println("Digite a nova salinidade:");
                boia.setSalinidade(scanner.nextDouble());
                System.out.println("Digite a nova temperatura:");
                boia.setTemperatura(scanner.nextDouble());
                System.out.println("Medidas atualizadas com sucesso.");
                return;
            }
        }

        System.out.println("Boia não encontrada.");
    }

    private static void pesquisarMedidas(Scanner scanner, List<Boia> boias) {
        System.out.println("Digite o hash code da boia para pesquisar:");
        int hashCode = scanner.nextInt();

        Collections.sort(boias, (b1, b2) -> Integer.compare(b1.getHashCode(), b2.getHashCode())); // Ordenar as boias

        int index = binarySearch(boias, hashCode);
        if (index >= 0) {
            System.out.println(boias.get(index));
        } else {
            System.out.println("Boia não encontrada.");
        }
    }

    private static int binarySearch(List<Boia> boias, int hashCode) {
        int left = 0, right = boias.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (boias.get(mid).getHashCode() == hashCode) {
                return mid;
            }
            if (boias.get(mid).getHashCode() < hashCode) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Não encontrado
    }
}
