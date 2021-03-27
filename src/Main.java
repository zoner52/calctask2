import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Помните условия: цифры могут быть арабскими или римскими от 1 до 10 включительно");
        System.out.print("Ваш пример: ");
        Scanner in = new Scanner(System.in);
        Parser pars = new Parser(in.nextLine());
        pars.parser();
    }
}