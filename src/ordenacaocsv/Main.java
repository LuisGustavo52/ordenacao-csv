
package ordenacaocsv;

public class Main {

    public static void main(String[] args) throws Exception {
        Candidato.adicionarCandidatos("C:\\Users\\Luis Gustavo\\OneDrive\\Documentos\\NetBeansProjects\\OrdenacaoCSV\\assets\\dadosConcurso.csv");
        
        for(Candidato candidato : Candidato.getListaDeCandidatos())
            System.out.println(candidato.toString());
    }
    
}
