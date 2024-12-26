package model;

public enum Category {
    FILM("Filme"),
    SERIE("Série"),
    DOCUMENTARY("Documentário"),
    ANIMATION("Animação"),
    INTERVIEW("Entrevista"),
    MUSIC("Clipe musicaL"),
    COURSE("Curso"),
    OTHER("Outra categoria");


    private String description;

    Category(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static boolean isValidCategory(String category) {
        for (Category cat : values()) {
            if (cat.toString().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }


}
