package test;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;
import util.FileHandler;

import java.io.File;

public class TestVideoController {
    public static void main(String[] args) {
        VideoController videoController =
                new VideoController(new VideoServiceImpl(new FileVideoRepository(new FileHandler(new File("videos.txt")))));
        videoController.run();
    }
}
