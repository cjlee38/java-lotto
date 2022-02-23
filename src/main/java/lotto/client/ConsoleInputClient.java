package lotto.client;

import java.util.Scanner;

public class ConsoleInputClient implements InputClient {

    private final OutputClient outputClient;
    private final Scanner scanner;

    public ConsoleInputClient(OutputClient outputClient, Scanner scanner) {
        this.outputClient = outputClient;
        this.scanner = scanner;
    }

    @Override
    public String input(String prompt) {
        outputClient.output(prompt);
        return this.scanner.nextLine();
    }
}
