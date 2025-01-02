package service;

import model.Category;
import util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class VideoValidator {
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

    public static Date validateDate(String dateString) {
        Date date = DateUtil.parseDate(dateString);
        if (date.before(new Date())) {
            return date;
        } else {
            throw new IllegalArgumentException("A data do vídeo deve ser anterior ao dia de hoje. " +
                    "Valor fornecido: " + DateUtil.toString(date));
        }
    }
}
