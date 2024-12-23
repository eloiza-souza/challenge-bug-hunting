package test;

import model.Video;
import service.VideoManager;

public class TestVideoManager {
    public static void main(String[] args) {
        VideoManager videoManager = new VideoManager();

        try {
            Video video = videoManager.createVideo("Aprendendo Java", "Curso completo de Java", "120", "curso", "15/10/2023");
            System.out.println("Vídeo criado com sucesso: " + video);
        } catch (Exception e) {
            System.err.println("Erro ao criar vídeo: " + e.getMessage());
        }

        try {
            Video videoFromString = videoManager.fromString("Aprendendo Java;Curso completo de Java;120;curso;15/10/2023");
            System.out.println("Vídeo criado a partir de string: " + videoFromString);
        } catch (Exception e) {
            System.err.println("Erro ao criar vídeo a partir de string: " + e.getMessage());
        }
    }
}
