import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        // вводим выражение
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(Main.calc(expression));
    }

    public static String calc(String expression) throws Exception {
        String[] signs = {"+", "-", "*", "/"};
        int counter = -1;
        // ищем индекс арифметического знака
        for (int i = 0; i < signs.length; i++) {
            if (expression.contains(signs[i])) {
                counter = i;
                break;
            } else if (i == 3) {
                throw new Exception();
            }
        }
        // получаем два числа из выражения
        String[] strNumbers = expression.split("[-+*/]");
        int[] intNumbers = new int[strNumbers.length];
        // проверяем, являются ли оба числа римскими
        boolean roman;
        if (RomanNumbers.check(strNumbers[0]) && RomanNumbers.check(strNumbers[1])) {
            roman = true;
            // переводим римские числа в арабские
            for (int i = 0; i < strNumbers.length; i++) {
                intNumbers[i] = Integer.parseInt(RomanNumbers.romanToArabic(strNumbers[i]));
            }
            // проверяем, являются ли оба числа арабскими
        } else if (!RomanNumbers.check(strNumbers[0]) && !RomanNumbers.check(strNumbers[1])) {
            roman = false;
            for (int i = 0; i < strNumbers.length; i++) {
                intNumbers[i] = Integer.parseInt(strNumbers[i]);
            }
            // если одно число римское, а другое - арабское
        } else {
            throw new Exception();
        }
        // задаем интервал чисел от 0 до 10
        for (int i = 0; i < intNumbers.length; i++) {
            if (intNumbers[i] >= 1 && intNumbers[i] <= 10) {
            } else {
                throw new Exception();
            }
        }
        String result;
        if (roman) {
            int resultInt = calculation(intNumbers[0], intNumbers[1], signs[counter]);
            if (resultInt < 1) {
                throw new Exception();
            } else {
                result = RomanNumbers.arabicToRoman(resultInt);
                return result;
            }
        } else {
            int resultInt = calculation(intNumbers[0], intNumbers[1], signs[counter]);
            result = String.valueOf(resultInt);
            return result;
        }
    }

    static int calculation(int number1, int number2, String sign) throws Exception {
        switch (sign) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                return number1 / number2;
            default:
                throw new Exception();
        }
    }
}
class RomanNumbers {
    static String[] romanNumbers = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    static boolean check(String number) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (number.equals(romanNumbers[i])) {
                return true;
            }
        }
        return false;
    }

    static String romanToArabic(String number) {
        for (int i = 0; i < romanNumbers.length; i++) {
            if (number.equals(romanNumbers[i])) {
                number = String.valueOf(i);
            }
        }
        return number;
    }

    static String arabicToRoman(int number) {
        return romanNumbers[number];
    }
}
