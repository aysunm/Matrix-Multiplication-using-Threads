/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matris;

/**
 *
 * @author aysun
 */
public class CarpimThread extends Thread {
    int[][] A, B, C;
    int n, m, k, i;
    
    public CarpimThread(int[][] _A, int[][] _B, int[][] _C, int _n, int _m, int _k, int _i)
    {
        A = _A;
        B = _B;
        C = _C;
        n = _n;
        m = _m;
        k = _k;
        i = _i;
    }
    
    
    @Override
    public void run()
    {
        int[] satir = A[i];
        for (int j = 0; j < k; j++)
        {
            int sonuc = 0;
            for (int l = 0; l < m; l++)
            {
                sonuc += satir[l] * B[l][j];
            }
            C[i][j] = sonuc;
        }
    }
}
