package assignment05;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BookClubTester {

LeisureBook L1 = new LeisureBook("smith","john",400,"penguin",1999,"The Rainbow",Genre.FANTASY);
LeisureBook L2 = new LeisureBook("johnson","joe",300,"scholastic",2012,"ALIENS",Genre.SCIENCE_FICTION);
Person A = new Person("Jack", "Prince", "123456789");
Person B = new Person("Tom", "Sawyer", "123456789");
BookClubMember BM1 = new BookClubMember(A);
BookClubMember BM2 = new BookClubMember(B);
BookClub BC1 = new BookClub();
@BeforeEach
@Test
void Initialize() {
BC1.addMember(BM1);
BC1.addMember(BM2);
BC1.addNewReading(L1);
BC1.addNewReading(L2);
BC1.getAveragePercentRead(L1);
BC1.getAveragePercentRead(L2);
BC1.getCompletionPercentage();
}
}