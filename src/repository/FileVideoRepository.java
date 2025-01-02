package repository;

import model.Video;
import service.VideoManager;
import util.FileHandler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileVideoRepository implements VideoRepository {
    private final FileHandler fileHandler;

    public FileVideoRepository(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void save(Video video) {
        this.fileHandler.writeInFile(video.toString());
    }

    @Override
    public List<Video> findAll() {
        return convertList(this.fileHandler.readLinesFromFile());
    }

    @Override
    public void editVideo(int index, Video newVideo) {
        this.fileHandler.updateLine(index, newVideo.toString());
    }

    @Override
    public void deleteVideo(int index) {
        this.fileHandler.deleteLine(index);
    }

    private List<Video> convertList(List<String> lines) {
        List<Video> videos = new ArrayList<>();
        for (String line : lines) {
            try {
                videos.add(VideoManager.createVideo(line));
            } catch (ParseException e) {
                System.err.println("Data inválida");
                ;
            }
        }
        return videos;
    }
}