package com.xpertgroup.cubesummation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class MatrixRepository {
	
	private int[][][] matrix;
			
	public int[][][] construirMatrix(int lenght) {
		matrix = new int[lenght][lenght][lenght];
		return matrix;
	}
	
	public void update(int x1, int y1, int z1, int value) {
		matrix[x1][y1][z1] = value;
	}
	
	public int query(int x1, int x2, int y1, int y2, int z1, int z2) {
		int suma = 0;
	    for (int i = x1; i <= x2; i++) {
	        for (int j = y1; j <= y2; j++) {
	            for (int k = z1; k <= z2; k++) {
	                suma += matrix[i][j][k];
	            }
	        }
	     }
	    return suma;
	}
	
}
