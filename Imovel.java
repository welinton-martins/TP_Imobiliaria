// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
import java.io.FileOutputStream;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileNotFoundException;
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
        // Scanner in = new Scanner(System.in);
        // int op = 0;
        // do {
        // try {
        // System.out.println("Imobiliária");
        // System.out.println("<1> Importar imóveis");
        // System.out.println("<2> Exportar imóveis");
        // System.out.println("<3> Listar imóveis");
        // System.out.println("<4> Mostrar detalhe do imóvel");
        // System.out.println("<5> Inserir novo imóvel");
        // System.out.println("<6> Remover imóvel");
        // System.out.println("<0> Sair");
        // System.out.print("Opção: ");
        // op = in.nextInt();
        // switch (op) {
        // case 1: ImportarImoveis();
        // break;
        // case 2: ExportarImoveis();
        // break;
        // case 3: ListarImoveis();
        // break;
        // case 4: MostrarDetalheDoImovel();
        // break;
        // case 5: InserirNovoImovel();
        // break;
        // case 6: RemoverImovel();
        // break;
        // case 0: break;
        // default: System.out.println("Opção inválida!");
        // }
        // } catch (NoSuchElementException e) {
        // e.printStackTrace();
        // }
        // } while (op != 0);
        // in.close();
    }

    private static void ImportarImoveis() {
        // Imovel i = new Imovel();
        // Scanner in = new Scanner(System.in);

        // // System.out.print("Informe o nome do arquivo: ");
        // // File arquivo = new File(in.next());
        // File arquivo = new File("imovel.csv");
        // try {
        //     if (!arquivo.exists()) {
        //         arquivo.createNewFile();
        //     }
        //     FileReader fr = new FileReader(arquivo);
        //     BufferedReader br = new BufferedReader(fr);

        //     String l = "";
        //     String[] c = new String[5];
        //     while (br.ready()) {
        //         l = br.readLine();
        //         c = l.split(",");
        //         if(!c[0].equals("Referencia")) {
        //             i.referencia = Integer.parseInt(c[0]);
        //             i.tipo = c[1];
        //             i.quartos = Integer.parseInt(c[2]);
        //             i.bairro = c[3];
        //             i.valor = Float.parseFloat(c[4]);
        //         }
        //     }
        //     br.close();
        //     fr.close();
        //     System.out.println(i.referencia+"\n"+i.tipo+"\n"+i.quartos+"\n"+i.bairro+"\n"+i.valor);
        // } catch (FileNotFoundException e) {
        //     System.out.println("Arquivo não encontrado!");
        // } catch (IOException e) {
        //     System.out.println("Erro de leitura/escrita");
        // }
    }

    private static void ExportarImoveis() {

    }

    private static void ListarImoveis() {
        // File f = new File(NOME_ARQUIVO);
        // FileReader fr = new FileReader(f);
        // BufferedReader br = new BufferedReader(fr);
        // br.readLine(); // cabeçalho
        // System.out.println("|Referencia|Valor   |");
        // while (br.ready()) {
        //     String[] tokens = br.readLine().split(",");
        //     System.out.printf("|%-10s|%10.2f|\n", tokens[0], Float.parseFloat(tokens[4]));
        // }
        // br.close();
        // fr.close();
        // To em duvida se e esse comentado ou o de cima
        // ObjectInputStream input = null;
        // try {
        //     // input = new ObjectInputStream(Files.newInputStream(Paths.get("imovel.csv")));
        //     while (true) {
        //         final Imovel i = (Imovel) input.readObject();
        //         System.out.printf("%d - %10.2f\n", i.referencia, i.valor);
        //         return;
        //     }
        // } catch (final EOFException e) {
        //     System.out.println("Fim dos registros");
        // } catch (final ClassNotFoundException e) {
        //     System.out.println("Tipo de objeto inválido");
        // } catch (final IOException e) {
        //     System.out.println("Erro de leitura no arquivo");
        // } finally {
        //     if (input != null) {
        //         try {
        //             input.close();
        //         } catch (final IOException e) {
        //             System.out.println("Erro ao fechar o arquivo!");
        //         }
        //     }
        // }
    }

	private static void MostrarDetalheDoImovel(String ref) throws IOException {
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
            // FileWriter fw = new FileWriter(NOME_ARQUIVO, true);
            // BufferedWriter bw = new BufferedWriter(fw);
            Scanner in = new Scanner(System.in);
            System.out.print("Referencia: ");
            i.referencia = in.nextInt();
            System.out.print("Tipo");
            in.nextLine();
            i.tipo = in.nextLine();
            System.out.print("Quartos: ");
            i.quartos = in.nextInt();
            System.out.print("Bairro: ");
            in.nextLine();
            i.bairro = in.nextLine();
            System.out.print("Valor: R$ ");
            i.valor = in.nextFloat();
            Path path = Paths.get("contas.dat");
            if (Files.exists(path)) {
                FileOutputStream fos = new FileOutputStream(NOME_ARQUIVO, true);
                AppendingObjectOutputStream output = new AppendingObjectOutputStream(fos);
                output.writeObject(i);
                output.close();
            } else {
                ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(path));
                output.writeObject(i);
                output.close();
            }
        } catch (IOException e) {
            System.out.println("Erro de escrita no arquivo!");
        }

        // bw.write(String.format("%d;%s;%d;%s;%.2f\n", i.referencia, i.tipo, i.quartos, i.bairro, i.valor));
        // bw.close();
        // fw.close();
	}

	private static void RemoverImovel(String ref) throws IOException {
		// Files.copy(Path.get(NOME_ARQUIVO), Paths.get("copia.csv"), StandardCopyOption.REPLACE_EXISTING);
        // File f = new File("copia.csv");
        // FileReader fr = new FileReader(f);
        // BufferedReader br = new BufferedReader(fr);
        // FileWriter fw = new FileWriter(NOME_ARQUIVO);
        // BufferedWriter bw = new BufferedWriter(fw);
        // boolean achou = false;
        // while (br.ready()) {
        //     String[] tokens = br.readLine().split(",");
        //     if (!ref.equals(tokens[0])) {
        //         bw.write(String.format("%s,%s,%s,%s,%s\n", tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]));
        //     } else {
        //         achou = true;
        //     }
        // }
        // if (!achou) {
        //     System.out.println("\nImovel nao encontrado!");
        // }
        // br.close();
        // fr.close();
        // bw.close();
        // br.close();
	}
}