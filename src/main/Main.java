package main;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;
import util.FileHandler;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler("videos.txt");
        FileVideoRepository videoRepository = new FileVideoRepository(fileHandler);
        VideoServiceImpl videoService = new VideoServiceImpl(videoRepository);
        VideoController videoController = new VideoController(videoService);
        videoController.run();
    }
}