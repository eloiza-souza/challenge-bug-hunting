package repository;

import model.Video;
import service.VideoManager;
import util.FileHandler;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private final FileHandler file;

    public FileVideoRepository(String filePath) {
        this.file = new FileHandler(filePath);
    }

    @Override
    public void save(Video video) {
        this.file.writeInFile(video.toString());
    }

    @Override
    public List<Video> findAll() {
        return convertList(this.file.readLinesFromFile());
    }

    private List<Video> convertList(List<String> lines)  {
        List<Video> videos = new ArrayList<>();
        for(String line: lines){
            try {
                videos.add(new VideoManager().fromString(line));
            } catch (ParseException e) {
                System.err.println("Data inválida");;
            }
        }
        return videos;
    }
}