
package ordenacaocsv;

public class Main {

    public static void main(String[] args) throws Exception {
        Candidato.adicionarCandidatosArquivo("dadosConcurso.csv",1);
        InsertionSort<Candidato> iSort = new InsertionSort<>();
        
        Candidato[] vetorDeCandidatos = new Candidato[Candidato.getListaDeCandidatos().size()];

        int i=0;
        for(Candidato candidato : Candidato.getListaDeCandidatos()){
            vetorDeCandidatos[i] = candidato;
            i++;
        }
        iSort.sort(vetorDeCandidatos);
        for(Candidato candidato : vetorDeCandidatos)
            System.out.println(candidato.toString());
    }
    
}
