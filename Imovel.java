import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Imovel implements Serializable {
	private int referencia;
	private String tipo;
	private int quartos;
	private String bairro;
	private float valor;

    public static final String NOME_ARQUIVO = "." + "/imovel.csv";

	public static void main(final String[] args) {
        Scanner in = new Scanner(System.in);
        int op = 0;
        do {
            try {
            System.out.println("Imobiliária");
            System.out.println("<1> Importar imóveis");
            System.out.println("<2> Exportar imóveis");
            System.out.println("<3> Listar imóveis");
            System.out.println("<4> Mostrar detalhe do imóvel");
            System.out.println("<5> Inserir novo imóvel");
            System.out.println("<6> Remover imóvel");
            System.out.println("<0> Sair");
            System.out.print("Opção: ");
            op = in.nextInt();
            switch (op) {
                case 1: ImportarImoveis();
                break;
                case 2: ExportarImoveis();
                break;
                case 3: ListarImoveis();
                break;
                case 4: 
                    System.out.print("Detalhes do Imovel\nReferencia do imóvel: ");
                    MostrarDetalheDoImovel(in.next());
                    break;
                case 5: InserirNovoImovel();
                break;
                case 6: 
                    System.out.print("\nRemover imóvel\nReferencia do imóvel: ");
                    RemoverImovel(in.nextInt());
                    break;
                case 0: break;
                default: System.out.println("Opção inválida!");
            }
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        } while (op != 0);
        in.close();
    }

    private static void ImportarImoveis() {
        Imovel i = new Imovel();
        File arquivoCSV = null;
        ObjectOutputStream output = null;
        try {
            arquivoCSV = new File("imovel.csv");
            FileReader fr = new FileReader(arquivoCSV);
            BufferedReader br = new BufferedReader(fr);
            Path path = Paths.get("imovel.dat");
            output = new ObjectOutputStream(Files.newOutputStream(path));
            while (br.ready()) {                
                String[] tokens = br.readLine().split(",");
                if (!(tokens[0] instanceof String)) {
                    System.out.println(tokens[0]);
                    i.referencia = Integer.parseInt(tokens[0]);
                    i.tipo = tokens[1];
                    i.quartos = Integer.parseInt(tokens[2]);
                    i.bairro = tokens[3];
                    i.valor = Float.parseFloat(tokens[4]);
                    System.out.println(i);
                    output.writeObject(i);
                }
            }
            output.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Erro de leitura");
        }
    }

    private static void ExportarImoveis() {

    }

    private static void ListarImoveis() {
        /*ObjectInputStream input = null;
        try {
            input = new ObjectInputStream(Files.newInputStream(Paths.get("imovel.dat")));
            while (true) {
                Imovel i = (Imovel) input.readObject();
                System.out.println(i.referencia + i.bairro);
            }
        } catch (EOFException e) {
            System.out.println("Fim dos registros");
        } catch (ClassNotFoundException e) {
            System.out.println("Fim dos registros");
        } catch (IOException e) {
            System.out.println("Erro de leitura do arquivo");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.out.println("Erro ao fechar arquivo");
                }
            }
        }*/
    }

	private static void MostrarDetalheDoImovel(String ref) {
        // boolean achou = false;
        // File f = new File(NOME_ARQUIVO);
        // FileReader fr = new FileReader(f);
        // BufferedReader br = new BufferedReader(fr);
        // while (br.ready()) {
        //     String[] tokens = br.readLine().split(",");
        //     if (ref.equals(tokens[0])) {
        //         System.out.println("Tipo: " + tokens[1]);
        //         System.out.println("Quartos: " + tokens[2]);
        //         System.out.println("Bairros: " + tokens[3]);
        //         System.out.printf("Valor: R$ %.2f\n", Float.parseFloat(tokens[4]));
        //         achou = true;
        //         break;
        //     }
        // }
        // if (!achou) {
        //     System.out.println("\nImovel nao encontrado!");
        // }
        // br.close();
        // fr.close();
	}

	private static void InserirNovoImovel() {
        Imovel i = new Imovel();
        try {
            Scanner in = new Scanner(System.in);
            System.out.print("Referencia: ");
            i.referencia = in.nextInt();
            System.out.print("Tipo: ");
            in.nextLine();
            i.tipo = in.nextLine();
            System.out.print("Quartos: ");
            i.quartos = in.nextInt();
            System.out.print("Bairro: ");
            in.nextLine();
            i.bairro = in.nextLine();
            System.out.print("Valor: R$ ");
            i.valor = in.nextFloat();
            Path path = Paths.get("imovel.dat");
            if (Files.exists(path)) {
                FileOutputStream fos = new FileOutputStream("imovel.dat", true);
                AppendingObjectOutputStream output = new AppendingObjectOutputStream(fos);
                output.writeObject(i);
                output.close();
            } else {
                ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path));
                output.writeObject(i);
                output.close();
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Erro de escrita no arquivo!");
        }
	}

	private static void RemoverImovel(int ref) {
        boolean achou = false;
        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        try {
            Files.copy(Paths.get("imovel.dat"), Paths.get("imovel.bak"), StandardCopyOption.REPLACE_EXISTING);
            input = new ObjectInputStream(Files.newInputStream(Paths.get("imovel.bak")));
            output = new ObjectOutputStream(Files.newOutputStream(Paths.get("imovel.dat")));
            while (true) {
                Imovel i = (Imovel) input.readObject();
                if (i.referencia != ref) {
                    output.writeObject(i);
                } else {
                    achou = true;
                }
            }
        } catch (EOFException e) {
            if (achou) {
                System.out.println("Imovel excluido com sucesso");
            } else {
                System.out.println("\nImovel nao encontrado!");
            }
        } catch (IOException e) {
            System.out.println("Erro ao fazer a copia do arquivo!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Erro de leitura!");
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar os arquivos!");
            }
        }
        
	}
}