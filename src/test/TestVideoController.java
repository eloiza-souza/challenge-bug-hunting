package test;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoServiceImpl;
import util.FileHandler;

public class TestVideoController {
    public static void main(String[] args) {
        VideoController videoController =
                new VideoController(new VideoServiceImpl(new FileVideoRepository(new FileHandler("videos.txt"))));
        videoController.run();
    }
}
