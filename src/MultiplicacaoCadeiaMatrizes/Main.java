/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiplicacaoCadeiaMatrizes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Akiro
 */
public class Main {
    
    public static void main (String[] args)
    {
        int p[] = {30,35,15,5, 10};
        ProdutoCadeiaMatrizes prod = new ProdutoCadeiaMatrizes();
        prod.matrix_chain_order(p);
        System.out.println("Sequência ótima: " + prod.print_optimal_parens(1, p.length - 1));
    }
}
