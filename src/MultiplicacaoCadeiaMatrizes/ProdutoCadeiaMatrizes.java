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
 * @authors Bruno Pandolfi, Lorenzo Vescovi e Tiago Giuliatte
 */


public class ProdutoCadeiaMatrizes 
{
    private Map<String, Integer> m;
    private Map<String, Integer> s;
    
    public void matrix_chain_order(int p[])
    {
        this.m = new HashMap();
        this.s = new HashMap();
        int n = p.length - 1;
        for (int i = 1; i < n + 1; i++)
            m.put(getChave(i, i),0);
        for (int h = 2; h < n + 1; h++)
        {
            for (int i = 1; i < n - h + 2; i++)
            {
                int j = i + h - 1;
                m.put(getChave(i, j), Integer.MAX_VALUE);
                for (int k = i; k < j; k++)
                {
                    int q = m.get(getChave(i, k)) + m.get(getChave(k + 1, j)) + p[i - 1]*p[k]*p[j];
                    if (q < m.get(getChave(i, j)))
                    {
                        m.put(getChave(i, j), q);
                        s.put(getChave(i, j), k);
                    }
                }
            }
        }
    }
    
     public int matrix_chain_order_rec(int p[], int i, int j)
    {
        
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        for (int k=i; k<j; k++)
        {
            int count = matrix_chain_order_rec(p, i, k) +
                        matrix_chain_order_rec(p, k+1, j) +
                        p[i-1]*p[k]*p[j];
 
            if (count < min)
                min = count;
        }
 
        // Return minimum count
        return min;
    }

    public String print_optimal_parens(int i, int j)
    {
        String res = "";
        if (i == j)
            return "A"+j;
        res += "(";
        res += String.valueOf(print_optimal_parens(i, s.get(getChave(i,j))));
        res += String.valueOf(print_optimal_parens(s.get(getChave(i,j)) + 1, j));
        res += ")";
        return res;
    }

    private String getChave(int i, int j)
    {
        return String.valueOf(i)+","+String.valueOf(j);
    }
    
    public void imprimirTabelaCustos (int p[])
    {
        StringBuilder tabela = new StringBuilder();
        int n = p.length - 1;
        for (int i = 1; i < n+1; i++)
        {
            int j = 1;
            while (i != j)
            {
                tabela.append(m.get(getChave(j,i))).append("\t");
                j++;
            }
            tabela.append(m.get(getChave(j,i))).append("\n");
        }
        System.out.println("\nTabela de Operações Ótimas:\n");
        System.out.println(tabela.toString());
    }
    
    public void imprimirTabelaSequenciaOtima (int p[])
    {
        StringBuilder tabela = new StringBuilder();
        int n = p.length - 1;
        for (int i = 1; i < n+1; i++)
        {
            int j = 1;
            while (i != j)
            {
                tabela.append(s.get(getChave(j,i))).append("\t");
                j++;
            }
            tabela.append("\n");
        }
        System.out.println("\nTabela de Sequencia Ótima:");
        System.out.println(tabela.toString());
    }
}
