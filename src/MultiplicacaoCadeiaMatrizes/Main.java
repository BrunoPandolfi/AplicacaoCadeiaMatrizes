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
public class Main {
    
    public static void main (String[] args)
    {
        int p[] = {30,35,15,5,10};
        Scanner leitor;
        int opcao;
        //int p[] = {30,35,15,5,10,20,25};
        ProdutoCadeiaMatrizes prod = new ProdutoCadeiaMatrizes();
        System.out.println ("Escolher opção do metodo de achar melhor custo: ");
        System.out.println ("1 - Programação dinâmica ");
        System.out.println ("2 - Metodo Recursivo ");
        System.out.print("Opcao Escolhida: ");
        leitor = new Scanner(System.in);
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
                System.exit(1);
        }
    }
}
