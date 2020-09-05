package assignment05;

import java.util.ArrayList;
import java.util.List;

public class TextBook extends Book {
		private String courseName;
		private List<Integer> assignedChapters = new ArrayList<>();
		public TextBook(String frstNm, String ltNm, int nmPgs, String pblshr,
				int pblcYr, String ttl, String crsNm) {
			super(frstNm, ltNm, nmPgs, pblshr, pblcYr, ttl);
			courseName = crsNm;
		}
		public String getCourseName() {
			return courseName;
		}
		public List<Integer> getAssignedChapters() {
			return assignedChapters;
		}
		public void addChapter(int chap) {
			assignedChapters.add(chap);
		}
		
		@Override
		public String toString() {
			String toString = super.toString() + "\n" + courseName +
					" " + assignedChapters;
			return toString;
		}
}
