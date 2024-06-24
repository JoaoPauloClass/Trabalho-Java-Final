package view;
import java.util.Scanner;

public class Console {
    

    public static Scanner scanner = new Scanner(System.in);

    //Ler um inteiro
    public static int readInt(String a){
        System.out.print(a);
        int temp =0;
        while (true) {
            
        
        try{
            temp = scanner.nextInt();
            return temp;
        }catch(Exception e){
            System.out.println("Digite um numero inteiro, por favor!");

        }finally{
            scanner.nextLine();
        }
    }
    }
    //Le uma String
    public static String readString(String a){
        System.out.print(a);
        return scanner.nextLine();
        
    }
    //Printa as letras de forma mais lenta
    public static void printSlowly(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted, failed to complete operation");
            }
        }
    }
}
