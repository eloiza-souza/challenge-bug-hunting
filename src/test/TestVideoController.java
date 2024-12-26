package test;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoService;
import service.VideoServiceImpl;

public class TestVideoController {
    public static void main(String[] args) {
        VideoController videoController =
                new VideoController(new VideoServiceImpl(new FileVideoRepository("videos.txt")));
        videoController.run();
    }
}
