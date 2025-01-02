package main;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;
import util.FileHandler;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler(new File("videos.txt"));
        FileVideoRepository videoRepository = new FileVideoRepository(fileHandler);
        VideoServiceImpl videoService = new VideoServiceImpl(videoRepository);
        VideoController videoController = new VideoController(videoService);
        videoController.run();
    }
}