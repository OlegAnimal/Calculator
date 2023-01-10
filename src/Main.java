import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input:");
        String expression = scanner.nextLine();
        System.out.println("Output:\n" + calc(expression));


    }


    public static String calc(String input) {
        int result = 0;
        String numberStr1;
        String numberStr2;
        int number1, number2;
        String operand;
        boolean isItRoman = false;

        input = input.replaceAll(" ", "");
        String[] value = input.split("[-+*/]");
        if (value.length != 2)
            throw new NumberFormatException("Неверное количество операндов");  //Должно делиться на два массива

        numberStr1 = value[0];
        numberStr2 = value[1];
        operand = input.replaceAll(numberStr1, "");
        operand = operand.replaceAll(numberStr2, "");  //получаем операнд

        try {
            number1 = Integer.parseInt(numberStr1);
            number2 = Integer.parseInt(numberStr2);
            if (!(checkArabNum(number1) && checkArabNum(number2)))
                throw new NumberFormatException("Неправильный формат");
            isItRoman = false;
        } catch (NumberFormatException e) {
            if ((Roman.isItRoman(numberStr1)) && (Roman.isItRoman(numberStr2))) {
                isItRoman = true;
                number1 = Roman.getArabNum(numberStr1);
                number2 = Roman.getArabNum(numberStr2);

            } else throw new NumberFormatException("Неправильный формат");
        }


        switch (operand) {
            case ("+"):
                result = number1 + number2;
                break;
            case ("-"):
                result = number1 - number2;
                break;
            case ("*"):
                result = number1 * number2;
                break;
            case ("/"):
                result = number1 / number2;
                break;
        }

        if ((result <= 0) && (isItRoman)) throw new NumberFormatException("Римские цифры должны быть больше нуля");
        else return isItRoman ? Roman.getRomanNum(result) : result + "";

    }


    private static boolean checkArabNum(int number) {
        return ((number > 0) && (number <= 10)) ? true : false;
    }
}
