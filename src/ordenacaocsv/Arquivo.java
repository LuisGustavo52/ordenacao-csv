
package ordenacaocsv;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    public static List<String> lerArquivo(String caminhoArquivo) throws Exception{
        List<String> dadosCSV = new LinkedList<>();
        Scanner scanner = 
                new Scanner(new File(caminhoArquivo));
        scanner.useDelimiter(",\n");
        int i = 1;
        while(scanner.hasNext()){
            if(i>=4){
                dadosCSV.add(scanner.next());
            }else{
                scanner.next();
            }
            i++;
        }
        scanner.close();
        
        return dadosCSV;
    }
}
