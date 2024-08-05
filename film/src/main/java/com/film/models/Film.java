package src.main.java.com.film.models;

public class Film {
    private int idFilm;
    private String name;
    private int year;
    private String director;
    private String synopsis;
    private double ranking;
    private String reviews;

    public Film(int idFilm, String name, String director, String synopsis, double ranking, String reviews, int year) {
        this.idFilm = idFilm;
        this.name = name;
        this.director = director;
        this.synopsis = synopsis;
        this.ranking = ranking;
        this.reviews = reviews;
        this.year = year;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public double getRanking() {
        return ranking;
    }

    public void setRanking(double ranking) {
        this.ranking = ranking;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

}
