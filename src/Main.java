import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        FileManager fileManager = new FileManager();
        LogicGame logic = new LogicGame();
        InputManager input = new InputManager();

        String secret = logic.numberGenerator(logic.listGenerator(10), 4);

        String head = "Game №" + fileManager.findNumberGame() + " " +
                fileManager.writeDate() + " " +
                "Загаданная строка " + secret;
        fileManager.writeFile(head);

        int count = 0;
        while (true) {
            String answer = input.numberCheck();

            String r = logic.gameProgress(logic.matchCheck(secret, answer));
            System.out.println(r);

            fileManager.writeFile("    Запрос: " + answer + " Ответ: " + r);

            count++;
            if (secret.equals(answer)) {
                break;
            }
        }

        fileManager.writeFile(logic.gameResult(count));

    }
}