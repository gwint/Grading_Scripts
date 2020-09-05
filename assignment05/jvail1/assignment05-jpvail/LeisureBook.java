package assignment05;
import java.util.ArrayList; 
import java.util.List;

public class LeisureBook extends Book {
    private Genre genre; 

    private List<Person> recommended = new ArrayList<>(); 

     public  LeisureBook(String a, String b, int c, String d, int e, String f,  Genre g){
        super(a, b, c, d, e, f); 
        genre = g; 
    }

    public Genre getGenre(){
        return this.genre; 
    }

    public List<Person> getRecommended(){
        return this.recommended; 
    }

    public void addRecommendation(Person p){
        recommended.add(p); 
    }

    


    








    


}