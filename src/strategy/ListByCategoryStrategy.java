package strategy;

import model.Video;

import java.util.List;
import java.util.stream.Collectors;

public class ListByCategoryStrategy implements SearchStrategy{
    @Override
    public List<Video> search(List<Video> videos, String category) {
        return videos.stream()
                .filter(video -> video.getCategory().toLowerCase().contains(category.toLowerCase()))
                .collect(Collectors.toList());
    }
}
