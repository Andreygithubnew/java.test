import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        boolean isArabic = true;
        String[] elements = input.split(" ");
        if (elements.length != 3){
            throw new Exception("Неправильный формат ввода");
        }

        int a;
        try {
            a = Integer.parseInt(elements[0]);
        } catch (Exception e) {
            isArabic = false;
            a = translateFromRomanToArabic(elements[0]);
        }
        if (a > 10) {
            throw new Exception("т.к. числа не соответствуют правилу");
        }
        int b;
        try {
            b = Integer.parseInt(elements[2]);
        } catch (Exception e) {
            if (isArabic) throw new Exception ("т.к. используются одновременно разные системы счисления");
            b = translateFromRomanToArabic(elements[2]);
        }
        if (b > 10) {
            throw new Exception("т.к. числа не соответствуют правилу");
        }

        String action = elements[1];

        switch (action) {
            case ("+"):
                if (isArabic) {
                    return String.valueOf(a + b);
                } else {
                    return translateFromArabicToRoman(a + b);
                }
            case ("-"):
                if (isArabic) {
                    return String.valueOf(a - b);
                } else {
                    return translateFromArabicToRoman(a - b);
                }
            case ("*"):
                if (isArabic) {
                    return String.valueOf(a * b);
                } else {
                    return translateFromArabicToRoman(a * b);
                }
            case ("/"):
                if (isArabic) {
                    return String.valueOf(a / b);
                } else {
                    return translateFromArabicToRoman(a / b);
                }
            default:
                throw new Exception("Операция не поддерживается");
        }
    }

    public static String translateFromArabicToRoman(int value){
        if(value == 100){
            return "C";
        }
        if (value < 10){
            return translate(value);
        }
        String result = translateDouble(value/10);
        value = value % 10;
        result = result + translate(value);
        return result;

    }
    public static String translate(int number){
        String value = String.valueOf(number);
        switch (value){
            case ("1") : return "I";
            case ("2") : return "II";
            case ("3") : return "III";
            case ("4") : return "IV";
            case ("5") : return "V";
            case ("6") : return "VI";
            case ("7") : return "VII";
            case ("8") : return "VIII";
            case ("9") : return "IX";
            default: return "";
        }
    }

    public static String translateDouble(int numer){
        String value = String.valueOf(numer);
        switch (value){
            case ("1") : return "X";
            case ("2") : return "XX";
            case ("3") : return "XXX";
            case ("4") : return "XL";
            case ("5") : return "L";
            case ("6") : return "LX";
            case ("7") : return "LXX";
            case ("8") : return "LXXX";
            case ("9") : return "XC";
            default: return "";
        }
    }



    public static int translateFromRomanToArabic(String number) {
        switch (number) {
            case ("I"):
                return 1;
            case ("II"):
                return 2;
            case ("III"):
                return 3;
            case ("IV"):
                return 4;
            case ("V"):
                return 5;
            case ("VI"):
                return 6;
            case ("VII"):
                return 7;
            case ("VIII"):
                return 8;
            case ("IX"):
                return 9;
            case ("X"):
                return 10;

            default: return 0;
        }
    }
}