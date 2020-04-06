/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matris;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aysun
 */
public class Matris {

    /**
     * @param args the command line arguments
     */
    static int[][] matrisA = null;
    static int[][] matrisB = null;
    public static void main(String[] args) throws Exception {
        
        ArrayList <ArrayList <String>> degerler1 = new ArrayList<ArrayList<String>>();
        ArrayList <ArrayList <String>> degerler2 = new ArrayList<ArrayList<String>>();

        File m1 = new File("matris1.txt");
        File m2 = new File("matris2.txt"); 

  
        BufferedReader matris1 = new BufferedReader(new FileReader(m1)); 
        
        System.out.println("Matris 1");
        System.out.println("---------");
        String st1; 
        while ((st1 = matris1.readLine()) != null)
        {
            ArrayList<String> sayilar = new ArrayList<String>();
            String[] splt = st1.split(" ");
            for (int i = 0; i < splt.length; i++)
            {
                sayilar.add(splt[i]);
            }
            degerler1.add(sayilar);
            System.out.println(st1); 
        }
        
        BufferedReader matris2= new BufferedReader(new FileReader(m2)); 
        
        System.out.println("");
        System.out.println("Matris 2");
        System.out.println("---------");
        
        String st2; 
        while ((st2 = matris2.readLine()) != null) 
        {
            ArrayList<String> sayilar = new ArrayList<String>();
            String[] splt = st2.split(" ");
            for (int i = 0; i < splt.length; i++)
            {
                sayilar.add(splt[i]);
            }
            degerler2.add(sayilar);
            System.out.println(st2); 
        }

        
        int n;
        int m;
        int k = 0;
        
        n = degerler1.size();
        m = degerler2.size();
        matrisA = new int[n][m];
        
        for (int i = 0; i < degerler1.size(); i++)
        {
            ArrayList<String> sayilar = degerler1.get(i);       
            for (int j = 0; j < sayilar.size(); j++)
            {
                matrisA[i][j] = Integer.parseInt(sayilar.get(j));
            }
        }
        
        for (int i = 0; i < degerler2.size(); i++)
        {
            ArrayList<String> sayilar = degerler2.get(i);
            if (matrisB == null)
            {
                k = sayilar.size();
                matrisB = new int[m][k];
            }
            for (int j = 0; j < sayilar.size(); j++)
            {
                matrisB[i][j] = Integer.parseInt(sayilar.get(j));
            }
        }
        
        System.out.println("");
        System.out.println("Matris 1 * Matris 2 Sonucu");
        System.out.println("---------------------------");
        
        int[][] matrisC = new int[n][k];
        
        CarpimThread[] threads = new CarpimThread[n];
        for (int i = 0; i < n; i++)
        {
            threads[i] = new CarpimThread(matrisA, matrisB, matrisC, n, m, k, i);
            threads[i].start();
        }
        
        for (int i = 0; i < n; i++)
        {
            try {
                threads[i].join();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < k; j++)
            {
                System.out.print(matrisC[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}
