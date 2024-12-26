package controller;

import model.PrincipalMenu;
import service.VideoManager;
import service.VideoService;
import util.MenuUtil;
import util.ScannerUtil;

import java.util.Scanner;

public class VideoController {

    VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    public void run() {

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    showPrincipalMenu();

                    PrincipalMenu choice = getUserChoice(scanner);

                    switch (choice) {
                        case ADD -> addVideo(scanner);
                        case LIST -> listAllVideos(scanner);
                        case SEARCH_BY_TITLE -> searchByTitle(scanner);
                        case EXIT -> {
                            System.out.println("Encerrando o programa...");
                            return;
                        }
                        default -> System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void showPrincipalMenu() {
        System.out.println("Escolha uma opção: ");
        MenuUtil.showMenu(PrincipalMenu.class);
    }

    private PrincipalMenu getUserChoice(Scanner scanner) {
        int choice;
        do {
            choice = ScannerUtil.readInt(scanner, "Opção:");
            if (choice < 1 || choice > PrincipalMenu.values().length) {
                System.out.println("Opção inválida. Escolha um número entre 1 e " + PrincipalMenu.values().length + ".");
            }
        } while (choice < 1 || choice > PrincipalMenu.values().length);
        return PrincipalMenu.values()[choice - 1];
    }

    private void addVideo(Scanner scanner) {
        videoService.addVideo(VideoManager.createVideo(scanner));
        System.out.println("Vídeo adicionado com sucesso!");
    }

    private void searchByTitle(Scanner scanner) {
    }

    private void listAllVideos(Scanner scanner) {
    }


}
