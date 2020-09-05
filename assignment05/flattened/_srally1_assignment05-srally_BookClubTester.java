package assignment05;

public class BookClubTester {

public static void main(String[] args) {
LeisureBook lsBook1 = new LeisureBook("Jimmy", "John", 400, "Pendant", 2010, "Murders in the Marsh", Genre.HORROR);
LeisureBook lsBook2 = new LeisureBook("Carey", "Wick", 170, "Del Rey", 2011, "Rock Lock", Genre.SCIENCE_FICTION);

BookClubMember bcm1 = new BookClubMember(new Person("Nick", "Den", "013468321"));
bcm1.addReading(lsBook1);
bcm1.setPageCount(lsBook1, 25);
bcm1.addReading(lsBook2);
bcm1.setPageCount(lsBook2, 45);


BookClubMember bcm2 = new BookClubMember(new Person("Jamie", "Lancaster", "264374839"));
bcm2.addReading(lsBook2);
bcm2.setPageCount(lsBook2, 90);
bcm2.addReading(lsBook1);
bcm2.setPageCount(lsBook1, 50);


BookClub bc = new BookClub();
bc.addMember(bcm1);
bc.addMember(bcm2);
bc.addNewReading(lsBook1);
bc.addNewReading(lsBook2);




}

}
