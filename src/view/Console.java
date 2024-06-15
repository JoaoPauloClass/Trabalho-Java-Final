import java.util.Scanner;

public class Console {
    

    public static Scanner scanner = new Scanner(System.in);


    public static int lerInt(String a){
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

    public static String lerString(String a){
        System.out.print(a);
        return scanner.nextLine();
        
    }
}
