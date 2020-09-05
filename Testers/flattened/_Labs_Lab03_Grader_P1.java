package lab03;

import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.io.FileWriter;

import static lab03.VectorMath.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

class Lab03_Grader_P1 {

	public static void main(String[] args) throws IOException{
 
		double grade = 0; //1 point per math function
	
		FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/lab-03/report.txt", true);
		
		List<Double> vect1 = List.of(1.0, 2.0, 3.0, 4.0, 5.0, 3.0);

		//the other vectors are mutable so they can be altered by scalarProduct() below
		List<Double> vect2 = new ArrayList<>(Arrays.asList(7.0, 24.0));
		List<Double> vect3 = new ArrayList<>(Arrays.asList(12.0, 4.0, 3.0));
		List<Double> orthogonal_23 = new ArrayList<>(Arrays.asList(72.0, -21.0, -260.0));
		List<Double> singleton = new ArrayList<>(Arrays.asList(7.0));
		List<Double> emptyVect = new ArrayList<>();
		List<Double> nullVect = null;


		//TEST MAGNITUDE
		if(magnitude(vect1).get() == 8){
			grade += 0.25;
		}else{
			fw.write("magnitude() error Case 1\n");			
		}
		if(magnitude(vect2).get() == 25){
			grade += 0.25;
		}else{
			fw.write("magnitude() error Case 2\n");			
		}
		if(magnitude(singleton).get() == 7){
			grade += 0.25;
		}else{
			fw.write("magnitude() error Case 3\n");			
		}
		if(magnitude(emptyVect).get() == 0){
			grade += 0.25;
		}else{
			fw.write("magnitude() error Case 4\n");			
		}

		//TEST DOT PRODUCT
		if(dotProduct(vect1, vect2).get() == 55){
			grade += 0.25;
		}else{
			fw.write("dotProduct() error Case 1\n");			
		}
		if(dotProduct(vect2, vect3).get() == 180){
			grade += 0.25;
		}else{
			fw.write("dotProduct() error Case 2\n");			
		}
		if(dotProduct(singleton, singleton).get() == 49){
			grade += 0.25;
		}else{
			fw.write("dotProduct() error Case 3\n");			
		}
		if(dotProduct(emptyVect, vect2).get() == 0){
			grade += 0.25;
		}else{
			fw.write("dotProduct() error Case 4\n");			
		}

		//TEST ORTHOGONAL
		if(isOrthogonal(vect3, orthogonal_23)){
			grade += 0.25;
		}else{
			fw.write("isOrthogonal() error Case 1\n");			
		}
		if(isOrthogonal(vect2, orthogonal_23)){
			grade += 0.25;
		}else{
			fw.write("isOrthogonal() error Case 2\n");			
		}
		if(isOrthogonal(vect3, emptyVect)){
			grade += 0.25;
		}else{
			fw.write("isOrthogonal() error Case 3\n");			
		}
		if(!isOrthogonal(vect1, vect2)){
			grade += 0.25;
		}else{
			fw.write("isOrthogonal() error Case 4\n");			
		}

		//TEST VECTOR ADDITION
		List<Double> t1 = new ArrayList<Double>();
		List<Double> t2= new ArrayList<Double>();
		List<Double> t3= new ArrayList<Double>();

		try{
			t1 = vectorAddition(vect2, vect2).get();
			t2 = vectorAddition(vect2, vect3).get();
			t3 = vectorAddition(emptyVect, vect2).get();

		}catch(ArrayIndexOutOfBoundsException exception){
			fw.write("Vector Addition Array out of bounds\n");			
		}

		//List<Double> t4 = vectorAddition(nullVect, vect2).get();

		if(t1.size() == 2 && t1.get(0) == 14 && t1.get(1) == 48){
			grade += 0.5;
		}else{
			fw.write("vectorAddition() error Case 1\n");			
		}if(t2.size() == 3 && t2.get(0) == 19 && t2.get(1) == 28 && t2.get(2) == 3){
			grade += 0.25;
		}else{
			fw.write("vectorAddition() error Case 2\n");						
		}
		if(t3.size() == 2 && t3.get(0) == 7 && t3.get(1) == 24){
			grade += 0.25;
		}else{
			fw.write("vectorAddition() error Case 3\n");			
		}
		//if(t4 == Optional.empty()){
		//	grade += 0.25;
		//}else{
		//	fw.write("vectorAddition() error Case 4\n");			
		//}


		//TEST SCALAR PRODUCT
		scalarProduct(vect2, 3);
		scalarProduct(vect3, 1);
		scalarProduct(singleton, -1);
		scalarProduct(nullVect, 3);

		if(vect2.get(0) == 21 && vect2.get(1) == 72){
			grade += 0.25;
		}else{
			fw.write("scalarProduct() error Case 1\n");			
		}if(vect3.get(0) == 12 && vect3.get(1) == 4 && vect3.get(2) == 3){
			grade += 0.25;
		}else{
			fw.write("scalarProduct() error Case 2\n");						
		}
		if(singleton.get(0) == -7){
			grade += 0.25;
		}else{
			fw.write("scalarProduct() error Case 3\n");			
		}
		if(nullVect == null){
			grade += 0.25;
		}else{
			fw.write("scalarProduct() error Case 4\n");			
		}


		fw.write("Grade: " + grade + "\n");
		fw.close();


	}

	
}

/*
		
		System.out.println("\n**********Scalar Product of 3 Applied to VECTORS*********");
		//here is an example of a try catch block
		//we are catching an exception that we known will occur.
		//you will learn more about exceptions later on in the course.
		try{
			scalarProduct(vect1, 3);
		}
		catch(UnsupportedOperationException e){
			System.out.println(e);
			System.out.println("Error caught: Cannot alter vect1 since it was made immutable.");
		}
		
*/
