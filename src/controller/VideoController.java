package controller;

import model.Menu;

import java.util.Scanner;

public class VideoController {
    final int EXIT = Menu.values().length + 1;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        showMenu();

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\nEscolha uma opção:");
        int index = 1;
        for (Menu option : Menu.values()) {
            System.out.println(index++ + ". " + option.getDescription());
        }
        System.out.println(EXIT + ". Sair");
    }

}
