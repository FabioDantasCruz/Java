//Importa a classe Scanner para realizar leituras do teclado.
import java.util.Scanner;

/**
 * Este é um algoritmo que calcula a potencia de um número utilizando uma função.
 * 
 */
 
public class Potencia {
    
      /**
     * Este é um método estático que faz o calculo da potência de um número que é
     * passado como parâmetro jutamente com o expoente e retorna para a função principal o resultado.
    */
    
    public static void main(String[] args) {
        
         //Declara uma variável para guardar o número que o usuário digitar que será a base da potência
        int base;
         //Declara uma variável para guardar o número que o usuário digitar que sera o expoente
        int exp;
 
     //Instancia um objeto da classe Scanner para realizar a leitura do teclado (System.in)
    Scanner entrada = new Scanner(System.in);
        
     //Imprime na saída
        System.out.println("Digite a base da potencia: ");
        
           /**Aqui a variável 'base' irá receber a entrada que o usuário digitar.
         * A minha instancia de Scanner, no caso 'entrada', utilizará o método nextInt()
         * para ler o que vier do teclado como sendo um int.
         */
        base = entrada.nextInt();
        System.out.println("Digite o expoente: ");
        
        // o mesmo caso que o anterior.
        exp = entrada.nextInt();
        
        
        //imprime o resultado da potencia
        
        System.out.println("A potencia  de " + base + " elevado a " +exp + " e:" +potencia(base,exp) + ".");
    }
    
    
    public static int potencia(int base, int exp ){
    // Variavel para guardar o resultado
    int result = 1;
    for(int i = 1;i <= exp;i++){
    result = base * result; 
 }
 return result;
    }
}