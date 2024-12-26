package service;

import model.Category;
import model.Video;
import util.MenuUtil;
import util.ScannerUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class VideoManager {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static Video createVideo(Scanner scanner) {
        return new Video(getVideoTitle(scanner),
                getVideoDescription(scanner),
                getVideoDuration(scanner),
                getVideoCategory(scanner),
                getVideoDate(scanner));
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

    private static String getVideoTitle(Scanner scanner) {
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

    private static String getVideoDescription(Scanner scanner) {
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

    private static int getVideoDuration(Scanner scanner) {
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

    private static String getVideoCategory(Scanner scanner) {
        MenuUtil.showMenu(Category.class, "Escolha uma categoria: ");
        while (true) {
            int option = ScannerUtil.readInt(scanner, "Categoria: ");
            if (option >= 1 && option <= Category.values().length) {
                return Category.values()[option - 1].toString();
            }
            System.out.println("Opção inválida. Escolha um número entre 1 e " + Category.values().length + ".");
        }
    }

    private static Date getVideoDate(Scanner scanner) {
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
}
