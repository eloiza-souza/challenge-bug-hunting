package test;

import model.Video;
import service.VideoManager;

public class TestVideoManager {
    public static void main(String[] args) {

        try {
            Video video = VideoManager.createVideo("Aprendendo Java", "Curso completo de Java", "120", "curso", "25/12/2024");
            System.out.println("Vídeo criado com sucesso: " + video);
        } catch (Exception e) {
            System.err.println("Erro ao criar vídeo: " + e.getMessage());
        }

        try {
            Video videoFromString = VideoManager.createVideo("Aprendendo Java;Curso completo de Java;120;curso;15/10/2023");
            System.out.println("Vídeo criado a partir de string: " + videoFromString);
        } catch (Exception e) {
            System.err.println("Erro ao criar vídeo a partir de string: " + e.getMessage());
        }
    }
}
