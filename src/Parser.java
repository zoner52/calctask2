import java.util.Arrays;

import static java.lang.System.*;

public class Parser {
    Character[] signs = {'+', '-', '*', '/'};
    String[] Arab_number = {"1","2","3","4","5","6","7","8","9","10"};
    String[] Roman_number = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    String parser_str = new String();

    public Parser(){};
    public Parser(String str){
        parser_str =str.replaceAll("\\s+","");
    }

    public void parser(){
        int i = 0;
        String left = "";
        String right = "";
        Character sign = null;

        try{
            while(!Arrays.asList(signs).contains(parser_str.charAt(i))){
                left += parser_str.charAt(i);
                i++;

                if (i == parser_str.length())
                    throw new Exception();
            }
        } catch (Exception e){
            out.println("Ввод некорректный!");
            exit(-1);
        }


        sign = parser_str.charAt(i);
        i++;

        while (i != parser_str.length()){
            right += parser_str.charAt(i);
            i++;
        }

        definition(left, right, sign);

    }

    public void definition (String left, String right, Character symbol){
        Integer fl_number = 0;
        Integer int_left = null;
        Integer int_right = null;
        try{
            for (int i = 0; i < Arab_number.length; i++) {
                if (Arab_number[i].equals(left)){
                    int_left = i + 1;
                    fl_number = 1;
                    break;
                }

                if (Roman_number[i].equals(left)){
                    int_left = i + 1;
                    break;
                }
            }

            if (int_left == null)
                throw new Exception();

            for (int i = 0; i < Arab_number.length; i++) {
                if (Arab_number[i].equals(right) && fl_number == 1){
                    int_right = i + 1;
                    break;
                }

                if (Roman_number[i].equals(right) && fl_number == 0){
                    int_right = i + 1;
                    break;
                }
            }

            if (int_right == null)
                throw new Exception();

            Num num = new Num(int_left, int_right, symbol);
            num.operation();

            if (fl_number == 1)
                num.print_result_arab();
            else
                num.print_result_roman();

        } catch (Exception e){
            out.println("Ошибка");
            exit(-1);
        }
    }
}