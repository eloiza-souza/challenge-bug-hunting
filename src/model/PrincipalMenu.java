package model;

public enum Menu {

    ADD ("Adicionar vídeo"),
    LIST ("Listar vídeos"),
    SEARCH_BY_TITLE ("Pesquisar vídeo por título"),
    EXIT ("Sair");

    private String description;

    Menu(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return description;
    }


}
