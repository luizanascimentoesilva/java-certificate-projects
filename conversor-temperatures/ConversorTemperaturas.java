import java.util.Scanner;

public class ConversorTemperaturas {
    static double toFarenheit(double value){
        return value * 9/5 + 32;
    }

    static double toCelsius(double value){
        return (value - 32) * 5/9;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        try {
            do {
                String line = scan.nextLine();
                String[] lineParsed = line.split("[CF]");
                lineParsed[0] = lineParsed[0].replace(",", ".");
                
                if(line.contains("C")) {
                        System.out.printf("%,.2fF%n",toFarenheit(Double.parseDouble(lineParsed[0])));
                } else if(line.contains("F")) {
                        System.out.printf("%,.2fC%n", toCelsius(Double.parseDouble(lineParsed[0])));
                } else {
                    throw new Exception("Opção inexistente");
                }
            }while(scan.hasNext());
        } catch (NumberFormatException e) {
            System.out.println("Um dos valores não é um número");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        scan.close();
    }
}
