package service;

import model.Video;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoManager {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    public Video createVideo(String title, String description, String duration, String category, String publicationDate)
            throws IllegalArgumentException, ParseException {

        VideoValidator.validateTitle(title);
        VideoValidator.validateDescription(description);
        VideoValidator.validateCategory(category);

        int validatedDuration = VideoValidator.validateDuration(duration);
        Date validatedDate = VideoValidator.validateDate(publicationDate);

        return new Video(title, description, validatedDuration, category, validatedDate);
    }

    public Video fromString(String line) throws ParseException {
        String[] split = line.split(";");
        if (split.length != 5) {
            throw new IllegalArgumentException("A string fornecida não está no formato esperado.");
        }
        return createVideo(split[0], split[1], split[2], split[3], split[4]);
    }
}
