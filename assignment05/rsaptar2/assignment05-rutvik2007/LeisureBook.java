package assignment05;
import java.util.ArrayList;
import java.util.List;

public class LeisureBook extends Book{
    Genre genre;
    List<Person> recommended=new ArrayList<>();
    public LeisureBook(String authorFirstName,String authorLastName, int numPages, String publisher, int publicationYear, String title, Genre genre){
        super(authorFirstName, authorLastName, numPages,publisher,publicationYear,title);
        this.genre=genre;
    }
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Person> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<Person> recommended) {
        this.recommended = recommended;
    }

    public void addRecommendation(Person p){
        recommended.add(p);
    }
    @Override
    public String toString(){
        return super.toString()+"\n"+this.genre;
    }

}