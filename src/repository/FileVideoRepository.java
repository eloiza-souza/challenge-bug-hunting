package repository;

import model.Video;
import service.VideoManager;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private final File file;

    public FileVideoRepository(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void save(Video video) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(video.toString());
            bw.newLine();
        } catch (IOException e) {
            // Ignorar erros por enquanto
        }
    }

    @Override
    public List<Video> findAll() {
        List<Video> videos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Video video = new VideoManager().fromString(line);
                if (video != null) {
                    videos.add(video);
                }
            }
        } catch (IOException e) {
            // Ignorar erros por enquanto
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return videos;
    }
}