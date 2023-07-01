import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputManager {

    public String numberCheck () {
        // проверка вводимого числа
        Scanner scanner = new Scanner(System.in);
        String answer;
        while (true) {
            System.out.println("Введите четырехзначное число:");
            String i = scanner.next();
            if (i.length() == 4 && reg(i)) {
                answer = i;
                break;
            }
            System.out.println("Неверное число");
        }
        return answer;
    }


    private boolean reg(String s) {
        // регулярка для проверки ввода на цифры
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(s);

        return m.matches();
    }


}
