
package ordenacaocsv;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Candidato implements Comparable<Candidato>{
    private static List<Candidato> listaDeCandidatos = new ArrayList<>();
    private String nome;
    private Integer nota;
    private Integer identificador;
    private LocalDate dataNascimento;

    public Candidato(String identificador, String nome, String nota, String dataNascimento) {
        this.identificador = Integer.parseInt(identificador);
        this.nota = Integer.parseInt(nota);
        this.dataNascimento = LocalDate.parse(dataNascimento);
        this.nome = nome;
    }

    public static List<Candidato> getListaDeCandidatos() {
        List<Candidato> copiaDeLista = listaDeCandidatos;
        return copiaDeLista;
    }
    
    public static void adicionarCandidatos(String caminhoArquivo) throws Exception{
        List<String> dadosCandidatos = new ArrayList<>();
        dadosCandidatos = Arquivo.lerArquivo(caminhoArquivo);
        
        for (int i = 0; i < dadosCandidatos.size(); i+=4) {
            Candidato candidato =  new Candidato(dadosCandidatos.get(i),dadosCandidatos.get(i+1), dadosCandidatos.get(i+2), dadosCandidatos.get(i+3));
            listaDeCandidatos.add(candidato);
        }
    }

    @Override
    public String toString() {
        String data = this.dataNascimento.toString();
        return String.format("Identificador: %s, Nome: %s, Nota: %s, Data de Nascimento: %s",this.identificador,this.nome,this.nota,data);
    }

    @Override
    public int compareTo(Candidato o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
