package main;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileVideoRepository videoRepository = new FileVideoRepository("videos.txt");
        VideoServiceImpl videoService = new VideoServiceImpl(videoRepository);
        VideoController videoController = new VideoController(videoService);
        videoController.run();
    }
}