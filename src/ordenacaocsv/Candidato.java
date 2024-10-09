
package ordenacaocsv;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Candidato implements Comparable<Candidato>{
    private static List<Candidato> listaDeCandidatos = new ArrayList<>();
    private Integer identificador;
    private String nome;
    private LocalDate dataNascimento;
    private Integer nota;

    public Candidato(Integer identificador, String nome, LocalDate dataNascimento, Integer nota) {
        this.identificador = identificador;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nota = nota;
    }

    public Integer getNota() {
        return nota;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    

    public static List<Candidato> getListaDeCandidatos() {
        List<Candidato> copiaDeLista = listaDeCandidatos;
        return copiaDeLista;
    }
    
    public static void adicionarCandidatosArquivo(String caminhoArquivo, int linhasPuladas) throws Exception{
        List<String> dadosCandidatos = new ArrayList<>();
        dadosCandidatos = Arquivo.lerArquivo(caminhoArquivo,linhasPuladas);
        
        for (int i = 0; i < dadosCandidatos.size(); i+=4) {
            Integer identificador = Integer.valueOf(dadosCandidatos.get(i));
            
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(dadosCandidatos.get(i+2), formatador);
            
            String stringNota = dadosCandidatos.get(i+3);
            String notaFormatada = "";
            for (int j = 0; j < stringNota.length(); j++) {
                try{
                    notaFormatada = notaFormatada + String.valueOf(Integer.valueOf(String.valueOf(stringNota.charAt(j))));
                }catch(Exception e){
                     
                }
            }
            Integer nota = Integer.valueOf(notaFormatada);
            
            Candidato candidato =  new Candidato(identificador,dadosCandidatos.get(i+1),dataNascimento, nota);
            
            
            listaDeCandidatos.add(candidato);
        }
    }

    @Override
    public String toString() {
        String data = this.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return String.format("Identificador: %s, Nome: %s, Nota: %s, Data de Nascimento: %s",this.identificador,this.nome,this.nota,data);
    }

    @Override
    public int compareTo(Candidato o) {
        int resultadoComparacao = this.nota.compareTo(o.getNota());
        if(resultadoComparacao == 0){
            resultadoComparacao = o.getDataNascimento().compareTo(this.getDataNascimento());
        }
        
        return resultadoComparacao;
    }
    
    
    
}
