/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arquivos;

/**
 *
 * @author Gustavo Motta
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class ManipulaTxt {

    public final String NOME_ARQUIVO = "cfgbanco.txt";

    public void escreverEmTxt(String serverhost, String database, String porta, String usuario, String senha) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {

            writer.write(serverhost);
            writer.newLine();
            writer.write(database);
            writer.newLine();
            writer.write(porta);
            writer.newLine();
            writer.write(usuario);
            writer.newLine();
            writer.write(senha);
            writer.newLine();

            System.out.println("Dados escritos com sucesso no arquivo " + NOME_ARQUIVO);

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public ArrayList<String> lerTxt() throws FileNotFoundException, IOException {

        ArrayList<String> lista = new ArrayList<>();

        try (BufferedReader leitor = new BufferedReader(new FileReader(NOME_ARQUIVO))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                lista.add(linha);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return lista;
    }

    public boolean verificarSeArquivoExiste() {

        File arquivo = new File(NOME_ARQUIVO);
        return arquivo.exists();
    }

    public void excluirArquivo() {
        File arquivo = new File(NOME_ARQUIVO);

        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo " + NOME_ARQUIVO + " excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o arquivo " + NOME_ARQUIVO + ".");
            }
        } else {
            System.out.println("Arquivo " + NOME_ARQUIVO + " não encontrado.");
        }
    }
}

