package controller;

import model.PrincipalMenu;
import model.Video;
import service.VideoManager;
import service.VideoService;
import strategy.ListByCategoryStrategy;
import strategy.TitleSearchStrategy;
import util.MenuUtil;
import util.ScannerUtil;

import java.util.List;
import java.util.Scanner;

public class VideoController {

    VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    public void run() {
        System.out.println("\n=== Sistema de Gerenciamento de Vídeos ===");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    showPrincipalMenu();

                    PrincipalMenu choice = getUserChoice(scanner);

                    switch (choice) {
                        case ADD -> addVideo(scanner);
                        case LIST -> listAllVideos();
                        case SEARCH_BY_TITLE -> searchByTitle(scanner);
                        case EDIT -> editVideo(scanner);
                        case DELETE -> deleteVideo(scanner);
                        case VIDEOS_BY_CATEGORY -> filterByCategory(scanner);
                        case SORT_BY_DATE -> sortByDate();
                        case EXIT -> {
                            System.out.println("Encerrando o programa...");
                            System.exit(0);
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

    private void sortByDate() {
    }

    private void showPrincipalMenu() {
        MenuUtil.showMenu(PrincipalMenu.class, "Escolha uma opção: ");
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

    private void listAllVideos() {
        List<Video> videoList = videoService.listVideos();
        if (videoList.isEmpty())
            System.out.println("Sistema não tem vídeos cadastrados.");
        else {
            System.out.println("Vídeos cadastrados:");
            showVideos(videoList);
        }
    }

    private void showVideos(List<Video> videos) {
        for (int i = 0; i < videos.size(); i++) {
            System.out.println((i + 1) + ". " + videos.get(i));
        }
    }

    private void searchByTitle(Scanner scanner) {
        String query = ScannerUtil.readString(scanner, "Digite o título para busca: ");
        List<Video> resultList = new TitleSearchStrategy().search(videoService.listVideos(), query);
        if (resultList.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado com o título: '" + query + "'.");
        } else {
            System.out.println("Resultados encontrados para o título: '" + query + "':");
            showVideos(resultList);
        }
    }

    private void editVideo(Scanner scanner) {
        List<Video> videoList = videoService.listVideos();
        if (videoList.isEmpty()) {
            System.out.println("Não há vídeos cadastrados");
        } else {
            showVideos(videoList);
            int index = getValidVideoIndex(scanner, videoList.size());
            videoService.setVideo(index, editVideoByAttributes(scanner, videoList.get(index)));
            System.out.println("Vídeo editado com sucesso!");
        }
    }

    private void filterByCategory(Scanner scanner){
        String category = VideoManager.readVideoCategory(scanner);
        List<Video> resultList = new ListByCategoryStrategy().search(videoService.listVideos(), category);
        if (resultList.isEmpty()) {
            System.out.println("Nenhum vídeo encontrado com a categoria: '" + category + "'.");
        } else {
            System.out.println("Resultados encontrados para a categoria: '" + category + "':");
            showVideos(resultList);
        }
    }

    private void deleteVideo(Scanner scanner) {
        List<Video> videoList = videoService.listVideos();
        if (videoList.isEmpty()) {
            System.out.println("Não há vídeos cadastrados");
        } else {
            showVideos(videoList);
            int index = getValidVideoIndex(scanner, videoList.size());
            videoService.deleteVideo(index);
            System.out.println("Vídeo deletado com sucesso!");
        }
    }

    private int getValidVideoIndex(Scanner scanner, int size) {
        int index;
        while (true) {
            index = ScannerUtil.readInt(scanner, "Digite o número do vídeo: ") - 1;
            if (index >= 0 && index < size) {
                break;
            }
            System.out.println("Índice inválido. Por favor, insira um número entre 1 e " + size + ".");
        }
        return index;
    }

    private Video editVideoByAttributes(Scanner scanner, Video video) {
        VideoManager.showVideoAttributes(video);
        int option;
        do {
            option = ScannerUtil.readInt(scanner, "Digite o número do atributo a ser alterado (ou 0 para finalizar edição): ");
            switch (option) {
                case 0 -> System.out.println("Fim da edição.");
                case 1 -> video.setTitle(VideoManager.readVideoTitle(scanner));
                case 2 -> video.setDescription(VideoManager.readVideoDescription(scanner));
                case 3 -> video.setDuration(VideoManager.readVideoDuration(scanner));
                case 4 -> video.setCategory(VideoManager.readVideoCategory(scanner));
                case 5 -> video.setPublicationDate(VideoManager.readVideoDate(scanner));
                default -> System.out.println("Opção inválida. Por favor, insira um número entre 0 e 5.");
            }
        } while (option != 0);
        return video;
    }

}
