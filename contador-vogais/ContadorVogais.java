import java.util.Scanner;
public class ContadorVogais {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            do {
                String text = scan.nextLine();

                if(text.length < 5000){
                    text = text.toUpperCase();
                    int count = 0;

                    count = (int) text.chars().filter(num -> (num == 'A' || num == 'E' || num == 'I' || num == 'O' || num == 'U') ).count();
                    System.out.println("Número de vogais: " + count);
                } else {
                    throw new Exception("Número de caracteres acima do permitido!");
                }
            }while(scan.hasNext());
        }  catch (Exception e){
            System.out.println(e.getMessage());
        }

        scan.close();
    }

}
