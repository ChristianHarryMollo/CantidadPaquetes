package com.wootion.algorithmic;

public class CantPaquetes
{
	public static void main(String[] args) {
		CantPaquetes c = new CantPaquetes(10, new int[]{1,3,4});
		int a=0;
		for(int i=0;i<c.getVectorSeleccion().length;i++)
        {
            a=a+c.getVectorSeleccion()[i];
        }
		System.out.println(a);
	}
    private int[][] matrizCambio;
    private int[] vectorPesos;
    private int pesTotal;
    private int[] vectorSeleccion;

    CantPaquetes(int pesTotal, int[]  paquetes){
        this.pesTotal = pesTotal;
        this.vectorPesos = paquetes;
        matrizCambio = calcularPaquetes(pesTotal, paquetes);
        vectorSeleccion = seleccionarPesos(pesTotal, paquetes, matrizCambio);
    }
    public int[] getVectorSeleccion(){
        return this.vectorSeleccion;
    }
    private int[][] calcularPaquetes(int pesTotal, int[]  pesPaq){

        int[][] matrizCambio = new int[pesPaq.length + 1][pesTotal + 1];

        for (int i = 0; i < pesPaq.length; i++)
            matrizCambio[i][0] = 0;

        for (int j = 1; j <= pesTotal; j++)
            matrizCambio[0][j] = 99;

        for (int i = 1; i <= pesPaq.length; i++)
            for (int j = 1; j <= pesTotal; j++) {
                if (j < pesPaq[i - 1]) {

                    matrizCambio[i][j] = matrizCambio[i - 1][j];
                } else {

                    int minimo = 0;

                    minimo = min(matrizCambio[i - 1][j] , matrizCambio[i][j- pesPaq[i - 1]] + 1);
                    matrizCambio[i][j] = minimo;

                }
            }

         return matrizCambio;
        }
    private int[] seleccionarPesos(int c, int[] paquetes, int[][]tabla ){
        int i,j;
        int[] seleccion = new int[paquetes.length];
        for(i = 0; i< paquetes.length; i++){             seleccion[i]=0;         }         i= paquetes.length;         j= c;         while(j>0){
            if(i>1 && tabla[i][j]==tabla[i-1][j]){
                i--;
            }
            else{
                seleccion[i-1]++;
                j = j - paquetes[i-1];
            }
        }

        return seleccion;
    }

    private int min(int a, int b){
        if(a<b)
            return a;

        else 
            return b;
    }

}