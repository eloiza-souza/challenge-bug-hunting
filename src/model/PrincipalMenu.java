package model;

public enum PrincipalMenu {

    ADD("Adicionar vídeo"),
    LIST("Listar vídeos"),
    SEARCH_BY_TITLE("Pesquisar vídeo por título"),
    EXIT("Sair");

    private String description;

    PrincipalMenu(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }


}
