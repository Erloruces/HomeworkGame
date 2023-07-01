import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {
    File file = new File("result.txt");

    public int findNumberGame () throws IOException {
        try (FileReader reader = new FileReader(file)) {
            // поиск номера игры
            int numberGame = 1;

            // чтение текстового файла
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer textResult = new StringBuffer();
            String cot;

            // проверка на пустоту файла
            if (file.length() != 0) {
                while ((cot = bufferedReader.readLine()) != null) {
                    textResult.append(cot);
                }
                // поиск последнего номера игры
                Pattern pattern = Pattern.compile("№\\d*");
                Matcher matcher = pattern.matcher(textResult);
                StringBuffer buffer = new StringBuffer();
                while (matcher.find()) {
                    buffer.replace(0, buffer.length(), textResult.substring(matcher.start(), matcher.end()));
                    numberGame = Integer.parseInt(buffer.deleteCharAt(0).toString());
                    numberGame++;
                }
            }
            return numberGame;
        }
    }

    public String writeDate() {
        // запись даты и номера игры
        Date dateNow = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        return sdf.format(dateNow);
    }

    public void writeFile (String str) throws IOException {
        // запись значений в файл
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(str + "\n");
        }
    }

}
