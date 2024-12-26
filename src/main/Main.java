package main;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;

public class Main {
    public static void main(String[] args) {
        VideoController videoController =
                new VideoController(new VideoServiceImpl(new FileVideoRepository("videos.txt")));
        videoController.run();
    }
}