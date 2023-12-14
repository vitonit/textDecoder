import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.lang.String.valueOf;


public class Main {
    public static void main(String[] args) {

        char[] alphabetArr = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '?', '.', ',', ' ', '\n'};
        double[] codesAlphabet = {22, 15, 33, 45, 98, 27, 67, 90, 77, 43, 55, 82, 66, 91, 93, 81, 83, 56, 88, 35, 68, 11, 21, 14, 41, 23, 32, 57, 75, 19, 29, 44, 99, 72, 47, 74, 85,};
        String[] functions = {"+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "-", "/", "*", "+", "*"};
        double[] functionsArg = {2.0, 3.0, 3.0, 3.0, 5.0, 4.0, 2.0, 10.0, 20.0, 8.0, 8.0, 4.0, 6.0, 10.0, 20.0, 5.0, 6.0, 7.0, 8.0, 7.0, 8.0, 1.0, 3.0, 4.0, 5.0, 7.0, 2.0, 4.0, 5.0, 10.0, 10.0, 11.0};

        System.out.println("Insert your text code"); // insert the received text code
        Scanner scanner = new Scanner(System.in);
        String textCodes = scanner.nextLine();

       String[] textCodesValuesString = textCodes.split(" "); // Строку преобразуем в массив
       String[] textCodesValuesStringFinal = new String[textCodesValuesString.length - 1];

        double dataShiftResultDouble = Double.valueOf(textCodesValuesString[0]);
        int dataShiftResult = Integer.valueOf((int) dataShiftResultDouble); // первый член массива преобразуем в integer
        double[] textCodesValues = new double[(textCodesValuesString.length)];

        for (int k = 1; k < textCodesValuesString.length; k++) {
            textCodesValues[k] = Double.parseDouble(valueOf(textCodesValuesString[k]));
        }
        String[] finalText = new String[(textCodesValuesString.length)];  // Create Array for storing the final a text
        String[] parameterOne = {"+", "-", "/", "*"};

        int indexFunction = 0;
        for (int j = 0; j < parameterOne.length; j++) {
            if (parameterOne[j].equals(functions[dataShiftResult])) {

                indexFunction = j;
            }
            switch (indexFunction) {

                case 0:
                    for (int k = 0; k < textCodesValuesStringFinal.length; k++) {
                        double v = textCodesValues[k + 1] - functionsArg[dataShiftResult];
                        for (int e = 0; e < codesAlphabet.length; e ++ ) {
                            if (v == codesAlphabet[e]) {
                                int alphabetIndex = e;
                                finalText[k] = valueOf(alphabetArr[alphabetIndex]);
                                System.out.print(finalText[k]);
                                break;
                            }
                        }
                    }
                case 1:
                    for (int k = 0; k < textCodesValuesStringFinal.length; k++) {
                        double v = textCodesValues[k + 1] + functionsArg[dataShiftResult];
                        for (int e = 0; e < codesAlphabet.length; e ++) {
                            if (v == codesAlphabet[e]) {
                                int alphabetIndex = e;
                                finalText[k] = valueOf(alphabetArr[alphabetIndex]);
                                System.out.print(finalText[k]);
                                break;
                            }
                        }
                    }
                case 2:
                    for (int k = 0; k < textCodesValuesStringFinal.length; k++) {
                        double v = textCodesValues[k +  1] * functionsArg[dataShiftResult];
                        int intPart = (int)Math.round(v);
                        for (int e = 0; e < codesAlphabet.length; e ++) {
                            if (intPart == codesAlphabet[e]) {
                                int alphabetIndex = e;
                                finalText[k] = valueOf(alphabetArr[alphabetIndex]);
                                System.out.print(finalText[k]);
                                break;
                            }
                        }
                    }
                case 3:
                    for (int k = 0; k < textCodesValuesStringFinal.length; k++) {
                        double v = textCodesValues[k + 1] / functionsArg[dataShiftResult];
                        int intPart = (int)Math.round(v);
                        for (int e = 0; e < codesAlphabet.length; e ++) {
                            if (intPart == codesAlphabet[e]) {
                                int alphabetIndex = e;
                                finalText[k] = valueOf(alphabetArr[alphabetIndex]);
                                System.out.print(finalText[k]);
                                break;
                            }
                        }
                    }
            }
            break;
        }
    }
}
