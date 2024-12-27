package service;

import model.Category;
import model.Video;
import util.MenuUtil;
import util.ScannerUtil;
import util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VideoManager {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Video createVideo(Scanner scanner) {
        return new Video(readVideoTitle(scanner),
                readVideoDescription(scanner),
                readVideoDuration(scanner),
                readVideoCategory(scanner),
                readVideoDate(scanner));
    }

    public static Video createVideo(String title, String description, String duration, String category,
                                    String publicationDate) throws IllegalArgumentException, ParseException {
        VideoValidator.validateTitle(title);
        VideoValidator.validateDescription(description);
        VideoValidator.validateCategory(category);
        int validatedDuration = VideoValidator.validateDuration(duration);
        Date validatedDate = VideoValidator.validateDate(publicationDate);
        return new Video(title, description, validatedDuration, category, validatedDate);
    }

    public static Video createVideo(String line) throws ParseException {
        String[] split = line.split(";");
        if (split.length != 5) {
            throw new IllegalArgumentException("A string fornecida não está no formato esperado.");
        }
        return createVideo(split[0], split[1], split[2], split[3], split[4]);
    }

    public static String readVideoTitle(Scanner scanner) {
        String title;
        while (true) {
            title = ScannerUtil.readString(scanner, "Digite o título do vídeo: ");
            try {
                VideoValidator.validateTitle(title);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
        return title;
    }

    public static String readVideoDescription(Scanner scanner) {
        String description;
        while (true) {
            description = ScannerUtil.readString(scanner, "Digite a descrição do vídeo: ");
            try {
                VideoValidator.validateDescription(description);
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
        return description;
    }

    public static int readVideoDuration(Scanner scanner) {
        int duration;
        while (true) {
            try {
                duration = VideoValidator.validateDuration(
                        ScannerUtil.readString(scanner, "Digite a duração do vídeo (em minutos): "));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
        return duration;
    }

    public static String readVideoCategory(Scanner scanner) {
        MenuUtil.showMenu(Category.class, "Escolha uma categoria: ");
        while (true) {
            int option = ScannerUtil.readInt(scanner, "Categoria: ");
            if (option >= 1 && option <= Category.values().length) {
                return Category.values()[option - 1].toString();
            }
            System.out.println("Opção inválida. Escolha um número entre 1 e " + Category.values().length + ".");
        }
    }

    public static Date readVideoDate(Scanner scanner) {
        Date date;
        while (true) {
            try {
                date = VideoValidator.validateDate(
                        ScannerUtil.readString(scanner, "Digite a data de publicação (dd/MM/yyyy): "));
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                System.out.println("Por favor, tente novamente.");
            }
        }
        return date;
    }

    public static void showVideoAttributes(Video video){
        System.out.println("1. Título: " + video.getTitle());
        System.out.println("2. Descrição: " + video.getDescription());
        System.out.println("3. Duração (minutos): " + video.getDuration());
        System.out.println("4. Categoria: " + video.getCategory());
        System.out.println("5. Data de publicação: " + DateUtil.toString(video.getPublicationDate()));
    }
}
