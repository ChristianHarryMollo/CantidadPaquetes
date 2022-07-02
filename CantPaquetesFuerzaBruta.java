import java.util.ArrayList;
public class CantPaquetesFuerzaBruta {

   	/* Este método recibe ambas entradas, k: los kilos solicitados 
   	 * y paq[] que son los paquetes disponibles, la idea del algoritmo 
   	 * es sumar cada paquete, e ir guardando los resultados de la suma en 
   	 * un nuevo arraylist, que suma de nuevo con el arraylist inicial, hasta 
   	 * que llegue a k. */

   	 public static int calcularPaquetes(int k, int[] paq){
   		 ArrayList <Integer> input = new ArrayList<>(); // se pasan los datos del array recibido
   		 for(int i = 0; i < paq.length; i++)       	// a un arraylist para facilitar las operaciones
             input.add(paq[i]);
   		 int cont = 1;	// un contador, que va a retornar la cantidad mínima
   		 return mochilaRecursiva(input,input,k,cont); // se llama al siguiente método   	        	
   	 }
   	
/* Inicialmente recibe el input y se suma con ese mismo, de ahí sale un nuevo arraylist, a este se
* añade el valor de la suma si y solo si ese valor no está en el input original, por ejemplo, en el 1, 2, 5
* al sumar 1+1 = 2, no se contaría, ya que el 2 ya es parte del input. Se busca minimizar, por lo que no tendria sentido.
   	 * Se va a llamar a si mismo hasta que llegue a k.
   	  */
   	 public static int mochilaRecursiva(ArrayList <Integer> in , ArrayList <Integer> two, int k, int cont) {
          ArrayList <Integer> nuevo = new ArrayList<>();
          cont++;
       	  for(int i = 0; i < in.size(); i++) {
             int valor1 = in.get(i);
          	 for(int j = 0; j< two.size(); j++) {
                 int valor2 = two.get(j);
                 int suma = valor1 + valor2;
                 if(suma == k)
                    return cont;
                 else {
                    if(in.contains(suma)==false) { //Se verifica que no se encuentre en el input original
                       if(nuevo.contains(suma)==false) // ni en el segundo donde se hizo la suma
                    	   nuevo.add(suma); 	// si no es    el caso, se añade al nuevo arraylist
                    }
                 }
              }       	
       	  }
       	  return mochilaRecursiva(nuevo, two, k, cont); //Va a ser recursivo, hasta que se llegue al valor solicitado
   	 }
   	 public static void main(String [] args) {
   		 
         int[] paq = {1, 2, 5 };
         int k = 12;
         System.out.println("Prueba 1: \n	Input = 12 --- {1, 2, 5 }  ");
		 System.out.println("    Output: " + calcularPaquetes(k, paq) + "\n");         	
         int[] paq1 = {1, 3, 4 };
         int k1 = 10;
   		 System.out.println("Prueba 2:  \n    Input = 10 --- {1, 3, 4 }  ");
		 System.out.println("    Output: " + calcularPaquetes(k1, paq1) + "\n");              	
         int[] paq2= {1, 3, 4 };
         int k2 = 6;
         System.out.println("Prueba 3:  \n    Input = 6 --- {1, 3, 4 }  ");
         System.out.println("    Output: " + calcularPaquetes(k2, paq2) + "\n");              	
         int[] paq3 = {1, 3, 5, 6, 7 };
         int k3 = 18;
         System.out.println("Prueba 4:  \n    Input = 18 --- {1, 3, 5, 6, 7 }  ");
         System.out.println("    Output: " + calcularPaquetes(k3, paq3) + "\n");
         int[] paq4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
         int k4 = 360;
         System.out.println("Prueba 5:  \n    Input = 360 --- { 1, 2, 3, 4, 5, 6, 7, 8, 9 }  ");
         System.out.println("    Output: " + calcularPaquetes(k4, paq4) + "\n");                	
         int[] paq5 = {1 ,2 ,5 ,7 ,11 ,13 };
         int k5 = 360;
         System.out.println("Prueba 6:  \n    Input = 360 --- {1 ,2 ,5 ,7 ,11 ,13 }  ");
         System.out.println("    Output: " + calcularPaquetes(k5, paq5) + "\n");             	
         int[] paq6 = {1 ,2 ,5 ,7 ,11 ,13 };
         int k6 = 1360;
         System.out.println("Prueba 7:  \n    Input = 1360 --- {1 ,2 ,5 ,7 ,11 ,13 }  ");
         System.out.println("    Output: " + calcularPaquetes(k6, paq6));
         }
}
