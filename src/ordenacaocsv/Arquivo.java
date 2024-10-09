
package ordenacaocsv;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Arquivo {
    public static List<String> lerArquivo(String caminhoArquivo, int linhasPuladas) throws Exception{
        List<String> dadosCSV = new LinkedList<>();
        Scanner scanner = 
                new Scanner(new File(caminhoArquivo));
        scanner.useDelimiter("\n");
        
        for (int i = 0; i < linhasPuladas; i++) {
            scanner.next();
        }
        
        while(scanner.hasNext()){
            String[] vetorStrings = scanner.next().split(",");
            for(String string : vetorStrings){
                dadosCSV.add(string);
                //System.out.println(string);
            }
                
        }
        
        //for(String string: dadosCSV)
          //  System.out.println(string);    
        scanner.close();
  
        return dadosCSV;
    }
    
    
}
