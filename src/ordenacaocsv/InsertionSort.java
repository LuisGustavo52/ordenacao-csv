
package ordenacaocsv;

import java.util.Comparator;

public class InsertionSort<T extends Comparable> {
    private long contaComparacoes;

    public long getContaComparacoes() {
        return contaComparacoes;
    }
    
    
    private void insert(T[] v, int i, Comparator<T> comparador){
        T eleito = v[i];
        int indice_comp = i-1;
        while(indice_comp>=0 && comparador.compare(eleito, v[indice_comp])<0){
            this.contaComparacoes++;
            v[indice_comp+1] = v[indice_comp];
            indice_comp--;
        }
        this.contaComparacoes++;
        v[indice_comp+1] = eleito;
    }
    
    private void insert(T[] v, int i){
        T eleito = v[i];
        int indice_comp = i-1;
        
        while(indice_comp>=0 && eleito.compareTo( v[indice_comp])<0){
            this.contaComparacoes++;
            v[indice_comp+1] = v[indice_comp];
            indice_comp--;
        }
        this.contaComparacoes++;
        v[indice_comp+1] = eleito;
    }
    
    public void sort(T[] v, Comparator comparador){
        this.contaComparacoes = 0;
        for (int i = 1; i < v.length; i++) 
            insert(v, i, comparador);

    }
    
    public void sort(T[] v){
        this.contaComparacoes = 0;
        for (int i = 1; i < v.length; i++) 
            insert(v, i);

    }
    
    
    
    
}
