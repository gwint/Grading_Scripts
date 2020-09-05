package assignment05;

import java.util.ArrayList;
import java.util.List;


public class LeisureBook extends Book{
    private Genre genre;
    private List<Person> recommended = new ArrayList<>();

    public LeisureBook(String authorfirst, String authorlast, int num_pages, int pub_year, String pub, String book_title, Genre gen){
        super(authorfirst, authorlast, num_pages, pub_year, pub, book_title);
        genre = gen;
    }

    public Genre getGenre(){
        return genre;
    }

    public List<Person> getRecommended(){
        return recommended;
    }

    public void addRecommendation(Person p){
        recommended.add(p);
    }
}
