import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class LogicGame {

    public ArrayList<Integer> listGenerator (int lengthList) {
        // список [0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ... n]
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < lengthList; i++) {
            list.add(i);
        }
        return list;
    }

    public String numberGenerator (ArrayList<Integer> list, int lengthNumber) {
        // генерация четырехзначного числа
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int y = 0;
        for (int i = 0; i < lengthNumber; i++) {
            int rnd = random.nextInt(list.size());
            sb.append(list.get(rnd));
            y = y * 10 + list.get(rnd);
            list.remove(rnd);
        }
        return String.valueOf(sb);
    }

    public String endingCow (int cow) {
        String strCow;
        if (cow == 0) {
            strCow = " коров ";
        } else if (cow == 1) {
            strCow = " корова ";
        } else {
            strCow = " коровы ";
        }
        return strCow;
    }

    public String endingBull (int bull) {
        String strBull;
        if (bull == 0) {
            strBull = " быков";
        } else if (bull == 1) {
            strBull = " бык";
        } else {
            strBull = " быка";
        }
        return strBull;
    }

    public int[] matchCheck (String secret, String answer) {
        // проверка на совпадения
        String[] secretToArray = secret.split("");
        String[] answerToArray = answer.split("");

        int cow = 0;
        int bull = 0;
        for (int i = 0; i < secretToArray.length; i++) {
            if (secretToArray[i].equals(answerToArray[i])) {
                bull++;
            } else {
                for (String s : answerToArray) {
                    if (secretToArray[i].equals(s)) {
                        cow++;
                    }
                }
            }

        }
        return new int[]{cow, bull};
    }

    public String gameProgress (int[] check) {
        // результат подбора числа в коровах и быках
        int cow = check[0];
        int bull = check[1];

        return cow + endingCow(cow) + bull + endingBull(bull);
    }

    public String gameResult (int count) {
        // вывод итога игры
        String attempt;
        if (count%10 == 1) {
            attempt = " попытку.";
        } else if ((Arrays.asList(2, 3, 4).contains(count%10))) {
            attempt = " попытки.";
        } else {
            attempt = " попыток.";
        }
        return "Строка была угадана за " + count + attempt;
    }

}
