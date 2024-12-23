package service;

import model.Category;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoValidator {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public static void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do vídeo não pode ser vazio ou nulo.");
        }
        if (title.length() > 100) {
            throw new IllegalArgumentException("O título do vídeo não pode ter mais de 100 caracteres. " +
                    "Valor fornecido: " + title);
        }
    }

    public static void validateDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do vídeo não pode ser vazia ou nula.");
        }
        if (description.length() < 20) {
            throw new IllegalArgumentException("A descrição do vídeo não pode ter menos de 20 caracteres. " +
                    "Valor fornecido: " + description);
        }
    }

    public static int validateDuration(String duration) {
        try {
            int time = Integer.parseInt(duration);
            if (time <= 0) {
                throw new IllegalArgumentException("O tempo do vídeo deve ser maior que zero. " +
                        "Valor fornecido: " + duration);
            }
            return time;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("A duração deve ser um número inteiro válido. " +
                    "Valor fornecido: " + duration, e);
        }
    }

    public static void validateCategory(String category) {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("A categoria do vídeo não pode ser vazia ou nula.");
        }
        if (!Category.isValidCategory(category)) {
            throw new IllegalArgumentException("Categoria inválida. Valor fornecido: " + category);
        }
    }

    public static Date parseAndValidateDate(String dateString) throws ParseException{
        DATE_FORMAT.setLenient(false);
        return DATE_FORMAT.parse(dateString);
    }
}
