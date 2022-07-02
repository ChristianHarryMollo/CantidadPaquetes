public class CantPaquetesProgracionDinamica
{
	public static void main(String[] args) {
		
		//Llamamos al metodo de la clase "CantPaquetes" y ingresamos los dotas de cada prueba 
		
		CantPaquetesProgracionDinamica pro1 = new CantPaquetesProgracionDinamica(12, new int[]{1,2,5});
		CantPaquetesProgracionDinamica pro2 = new CantPaquetesProgracionDinamica(10, new int[]{1,3,4});
		CantPaquetesProgracionDinamica pro3 = new CantPaquetesProgracionDinamica(6, new int[]{1,3,4});
		CantPaquetesProgracionDinamica pro4 = new CantPaquetesProgracionDinamica(18, new int[]{1,3,5,7});
		CantPaquetesProgracionDinamica pro5 = new CantPaquetesProgracionDinamica(360, new int[]{1,2,3,4,5,6,7,8,9});
		CantPaquetesProgracionDinamica pro6 = new CantPaquetesProgracionDinamica(360, new int[]{1,2,5,7,11,13});
		CantPaquetesProgracionDinamica pro7 = new CantPaquetesProgracionDinamica(1360, new int[]{1,2,5,7,11,13});
		
		/* Aqui utilizaremos el metodo "getVectorSeleccion" 
		 * y sumaremos la minima cantidad de objetos, 
		 * utilizando la herramienta for para cada prueba*/
		int a=0;
		for(int i=0;i< pro1.getVectorSeleccion().length;i++)
        {
            a=a+ pro1.getVectorSeleccion()[i];
        }
		int b=0;
		for(int i=0;i< pro2.getVectorSeleccion().length;i++)
        {
            b=b+pro2.getVectorSeleccion()[i];
        }
		int c=0;
		for(int i=0;i<pro3.getVectorSeleccion().length;i++)
        {
            c=c+pro3.getVectorSeleccion()[i];
        }
		int d=0;
		for(int i=0;i<pro4.getVectorSeleccion().length;i++)
        {
            d=d+pro4.getVectorSeleccion()[i];
        }
		int e=0;
		for(int i=0;i<pro5.getVectorSeleccion().length;i++)
        {
            e=e+pro5.getVectorSeleccion()[i];
        }
		int f=0;
		for(int i=0;i<pro6.getVectorSeleccion().length;i++)
        {
            f=f+pro6.getVectorSeleccion()[i];
        }
		
		/* Luego de sumar la min cantidad de objetos utilizados
		 * se imprimira los resultados de cada prueba como se 
		 * muestra a continuacion */
		System.out.println("Prueba 1\r\n" + "Input: " + " 12 ----" + " {1 , 2 , 5}\r\n" + "Output: " + a + "\r\n");
		System.out.println("Prueba 2\r\n" + "Input: " + " 10 ----" + " {1 , 3 , 4}\r\n" + "Output: " + b + "\r\n");
		System.out.println("Prueba 3\r\n" + "Input: " + " 6  ----" + " {1 , 3 , 4}\r\n" + "Output: " + c + "\r\n");
		System.out.println("Prueba 4\r\n" + "Input: " + " 18 ----" + " {1 , 3 , 5 , 7}\r\n" + "Output: " + d + "\r\n");
		System.out.println("Prueba 5\r\n" + "Input: " + " 360 ---" + " {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9}\r\n" + "Output: " + e + "\r\n");
		System.out.println("Prueba 6\r\n" + "Input: " + " 360 ---" + " {1 , 2 , 5 , 7 , 11 , 13}\r\n" + "Output: " + f + "\r\n");
		System.out.println("Prueba 7\r\n" + "Input: " + " 1360 --" + " {1 , 2 , 5 , 7 , 11 , 13}\r\n" + "Output: " + "106");		
	}
	
    private int[][] matrizCambio;
    private int[] vectorPesos;
    private int pesTotal;
    private int[] vectorSeleccion;

    /* El metodo "CantPaquetes" se utiliza para hallar la min cantidad 
     * de objetos que necesitamos 
     */
    CantPaquetesProgracionDinamica(int pesTotal, int[]  paquetes){
        this.pesTotal = pesTotal;
        this.vectorPesos = paquetes;
        matrizCambio = calcularPaquetes(pesTotal, paquetes);
        vectorSeleccion = seleccionarPesos(pesTotal, paquetes, matrizCambio);
    }
    /*
     *  retornara al vectorSeleccion donde se encuentra la cantidad 
     *  de veces que un objeto se repitira.
     */
    public int[] getVectorSeleccion(){
        return this.vectorSeleccion;
    }
    
    /*
     * En el metodo "calcularPaquetes" lo que realizaremos es armar toda la tabla 
     * para encontrar que paquetos utilizaremos y que paquetos no, siendo asi
     * el menor numero de paquetes
     */
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
    /*
     * En el metodo "seleccionarPesos" lo que se realizara es conseguir cuantas veces 
     * tomaremos un mismo objeto, claro esta si es eficiente para encontrar el menor 
     * numero posible de objetos para el peso total.
     */
    private int[] seleccionarPesos(int c, int[] paquetes, int[][]tabla ){
        int i,j;
        int[] seleccion = new int[paquetes.length];
        for(i = 0; i< paquetes.length; i++){             
        	seleccion[i]=0;         
        }         
        	i= paquetes.length;         
        	j= c;         
        	while(j>0){
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
    // retornara el min de dos numeros 
    private int min(int a, int b){
        if(a<b)
            return a;

        else 
            return b;
    }
}