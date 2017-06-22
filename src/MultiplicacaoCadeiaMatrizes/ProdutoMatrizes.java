/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultiplicacaoCadeiaMatrizes;

/**
 *
 * @author Bruno Pandolfi
 */
public class ProdutoMatrizes {
    
    public static void calcularProdMatrizes(int matA[][], int matB[][])
    {
        int [][] matR = new int [matA[0].length][matB.length];
        for (int i = 0; i < matA.length; i++)
        {
            for (int j = 0; j < matB[0].length; j++)
            {
                matR[i][j] = 0;
                for (int k = 0; k < matA[0].length; k++)
                    matR[i][j] = matR[i][j] + (matA[i][k] * matB[k][j]);
            }     
        }
    }
}
