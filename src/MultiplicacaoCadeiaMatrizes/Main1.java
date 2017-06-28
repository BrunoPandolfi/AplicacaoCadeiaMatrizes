/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiplicacaoCadeiaMatrizes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @authors Bruno Pandolfi, Lorenzo Vescovi e Tiago Giuliatte
 */
public class Main1 {
    
    public static void main (String[] args)
    {
        Random random;
        int n;
        Scanner leitor;
        int opcao = -1;
        StringBuilder vetor = new StringBuilder();
        ProdutoCadeiaMatrizes prod = new ProdutoCadeiaMatrizes();
        leitor = new Scanner (System.in);
        System.out.print("Digite a quantidade de matrizes que deseja multiplicar: ");
        n = leitor.nextInt();
        
        int p[] = new int[n+1];
        random = new Random();
        for (int i = 0; i < p.length; i++)
        {
            p[i] = 1 + random.nextInt(100);
        }
        
        vetor.append("[");
        for (int j = 0; j < p.length; j++)
        {
           vetor.append(p[j]); 
           if (j < p.length - 1)
               vetor.append(",");
        }
        vetor.append("]");
        
        System.out.println("Vetor de dimensões: " + vetor.toString() + "\n");
        while (opcao != 0)
        {
            System.out.println ("Escolher opção do metodo de achar melhor custo: ");
            System.out.println ("1 - Programação dinâmica ");
            System.out.println ("2 - Metodo Recursivo ");
            System.out.print("Opcao Escolhida: ");
            opcao = leitor.nextInt();
            switch (opcao)
            {
                case 1:
                    System.out.println("Método Programação Dinâmica:\n");
                    prod.matrix_chain_order(p);
                    System.out.println("Sequência ótima: " + prod.print_optimal_parens(1, p.length - 1));
                    prod.imprimirMelhorCusto(p);
                    prod.imprimirTabelaCustos(p);
                    prod.imprimirTabelaSequenciaOtima(p);
                    break;
                case 2:
                    prod.imprimirMelhorCustoRec(p);
                    break;
                default:
            }
        }
    }
}
