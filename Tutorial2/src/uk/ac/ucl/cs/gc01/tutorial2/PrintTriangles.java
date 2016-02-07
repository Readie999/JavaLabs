package uk.ac.ucl.cs.gc01.tutorial2;

import java.util.Scanner;

public class PrintTriangles {
public static void main(String[] args) {
	Scanner scanner =new Scanner(System.in);
	System.out.println("Enter the number of rows required: ");
	int number = scanner.nextInt();
	printPascaltriangle(number -1);
	scanner.close();
	
}
public static void printPascaltriangle(int numRows) {
	int[][] array = new int[numRows+1][numRows+1]; 
	array[0][0]=1;
	if(numRows==0){
		System.out.println(array[0][0]);
	}
	else if(numRows ==1){
		array[0][1]=1;
		array[1][1]=1;
		System.out.println(array[0][0]+ " ");
		System.out.println(array[0][1] +" "+ array[1][1]);
	}
	else{
		array[0][1]=1;
		array[1][1]=1;
		
		for(int k=numRows; k>0; k--){
			System.out.print(" ");
		}
		System.out.println(array[0][0]+ " ");
		for(int k=numRows-1; k>0; k--){
			System.out.print(" ");}
		System.out.println(array[0][1] +" "+ array[1][1]);
		
		
	for(int j=2; j < numRows+1; j++){
		//the number of columns is the same as the number of rows
		array[0][j]=1;
		for(int k=numRows-j; k>0; k--){
			System.out.print(" ");
		}
		System.out.print(array[0][j]+" ");	
		for(int i=1; i<j+1; i++){

			array[i][j]= array[i-1][j-1]+array[i][j-1];
			array[i][i]=1;
			//first element on left is always 1 as is the last element on the right
			System.out.print(array[i][j]+ " ");
		}
		
		System.out.println();
		}		
	
	}
}
}
