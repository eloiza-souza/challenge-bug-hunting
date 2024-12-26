package test;

import controller.VideoController;
import repository.FileVideoRepository;
import service.VideoService;
import service.VideoServiceImpl;

public class TestVideoController {
    public static void main(String[] args) {
        VideoService videoService = new VideoServiceImpl(new FileVideoRepository("videos.txt"));
        VideoController videoController = new VideoController(videoService);
        videoController.run();
    }
}
