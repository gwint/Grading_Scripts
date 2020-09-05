package lab05;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.FileWriter;

class Lab05_Grader {

	public static void main(String[] args) throws IOException{
 
		double grade = 0;
	
		FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/Lab05/report.txt", true);
		


        Division set = new Division(new double[]{1,2,3,0,4,5,0,6,0,7,8,9,0});

    	try{
	        set.removeZeroes(); //1 point
    	}catch(Exception e){
    		fw.write("EXCEPTION ");
    	}

        String answer1 = "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]";
        if(set.toString().equals(answer1)){
        	grade += 1;
        }else{
        	fw.write("removeZeroes() failed -1\n");
        }

    	try{
	        set.divide(2); //1 point
    	}catch(Exception e){
    		fw.write("EXCEPTION ");
    	}

        String answer2 = "[0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]";
        if(set.toString().equals(answer2)){
        	grade += 1;
        }else{
        	fw.write("divide() failed -1\n");
        }

        try{
        	set.divide(0); //0.5 points
        	fw.write("Failed to throw exception divide by zero -0.5\n");
        }catch(IllegalArgumentException e){
        	if(e.getMessage().equals("cannot divide by zero")){
        		grade += 0.5;
        	}
        }catch(Exception e2){
        	fw.write("Failed divide by zero -0.5\n");
        }

        try{
        	set = new Division(null); //0.5 points
        	fw.write("Failed to throw exception Division object null check -0.5\n");
        }catch(IllegalArgumentException e){
        	if(e.getMessage().equals("need to enter an array with at least one double")){
        		grade += 0.5;
        	}
        }catch(Exception e2){
        	fw.write("Failed Division object null check -0.5\n");
        }
        try{
        	set = new Division(new double[0]); //0.5 points
        	fw.write("Failed to throw exception Division empty array check -0.5\n");
        }catch(IllegalArgumentException e){
        	if(e.getMessage().equals("need to enter an array with at least one double")){
        		grade += 0.5;
        	}
        }catch(Exception e2){
        	fw.write("Failed Division empty array check -0.5\n");
        }

        
        
    	List<String> list1 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", "fire"));
    	List<String> list2 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", "red"));


		List<String> result1 = new ArrayList<String>(Arrays.asList("to", "delicious", "truck", "fire"));
    	List<String> result2 = new ArrayList<String>(Arrays.asList("cellphone", "copper", "blue", "red"));


    	try{
    		FunWithStrings.swapMaxes(list1, list2); //1 point
    	}catch(Exception e){
    		fw.write("EXCEPTION ");
    	}

    	if(list1.equals(result1) && list2.equals(result2)){
    		grade +=1;
    	}else{
    		fw.write("Failed swapMaxes() case 1: -1\n");
    	}

    	List<String> list3 = new ArrayList<String>(Arrays.asList("to", "cellphone", null, "fire"));
    	List<String> list4 = new ArrayList<String>(Arrays.asList(null, "copper", "blue", "red"));

		List<String> result3 = new ArrayList<String>(Arrays.asList("to", "copper", null, "fire"));
    	List<String> result4 = new ArrayList<String>(Arrays.asList(null, "cellphone", "blue", "red"));

    	try{
    		FunWithStrings.swapMaxes(list3, list4); // 1 point
    	}catch(Exception e){
    		fw.write("EXCEPTION ");
    	}

    	if(list3.equals(result3) && list4.equals(result4)){
    		grade +=1;
    	}else{
    		fw.write("Failed swapMaxes() case 1: -1\n");
    	}


    	try{
    		FunWithStrings.swapMaxes(null, list4); //0.5 points
    		fw.write("swapMaxes() failed to throw exception on null case -0.5\n");
    	}catch(IllegalArgumentException e){
        	if(e.getMessage().equals("cannot swap maxes of empty lists, null lists, or lists with all null elements")){
        		grade += 0.5;
        	}else{
        		fw.write("swapMaxes() wrong null message -0.25\n");
        		grade += 0.25;
        	}
        }catch(Exception e){
    		fw.write("swapMaxes() failed null case -0.5\n");
    	}


    	int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
    	int[] arr2 = new int[]{7, 8, 9, 10, 11, 12};
    	int[] result5 = new int[]{7, 1, 8, 2, 9, 3, 10, 4, 11, 5, 12, 6};

    	try{
    		int[] arr3 = Zipper.zip(arr2, arr1); //2 points
    		if(Arrays.equals(arr3, result5)){
    			grade += 2;
    		}else{
    			fw.write("zip() failed normal case -2\n");
    		}
    	}catch(Exception e){
    		fw.write("Exception zip() failed normal case -2\n");
    	}

    	try{
    		int[] arr4 = Zipper.zip(new int[0], new int[0]); //1 point
    		if(arr4.length == 0){
    			grade += 1;
    		}else{
    			fw.write("zip() failed empty case -1\n");
    		}
    	}catch(Exception e){
    		fw.write("zip() EXCEPTION failed empty case -1\n");
    	}

    	try{
    		int[] arr4 = Zipper.zip(new int[]{1,2,3}, new int[]{1,2}); //1 point
    		fw.write("zip() failed to throw exception mismatching lengths -1\n");
    	}catch(IllegalArgumentException e){
        	if(e.getMessage().equals("bad input")){
        		grade += 1;
        	}else{
        		fw.write("zip() wrong mismatching lengths exception message -0.25\n");
        		grade += 0.75;
        	}
        }catch(Exception e){
    		fw.write("zip() EXCEPTION failed mismatching lengths case -1\n");
    	}



		fw.write("Grade: " + grade + "\n");
		fw.close();


	}

	
}
