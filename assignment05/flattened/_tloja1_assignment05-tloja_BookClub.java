package assignment05;

import java.util.HashSet;
import java.util.Set;

public class BookClub {
private Set<BookClubMember> members = new HashSet<>();
private Set<LeisureBook> readings = new HashSet<>();
public void addMember(BookClubMember bcm) {
for(var r : readings) {
bcm.addReading(r);
}
members.add(bcm);

}

public void addNewReading(LeisureBook book) {
readings.add(book);
for(var mem : members) {
mem.addReading(book);
}
}
public double getAveragePercentRead(Book book) {
int size = members.size();
if(members.isEmpty()) {
return 0.0;
}
double average = 0;
for(var m : members) {
average += m.getPercentRead(book);
}
return (average/size);
}
public double getCompletionPercentage() {
int size = readings.size();
double sum = 0;
for(var r : readings) {
sum+= getAveragePercentRead(r);
}
sum = sum/size;
return sum;
}
}
