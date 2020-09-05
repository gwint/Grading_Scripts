package lab01;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.io.IOException;
import java.io.FileWriter;

class Lab01_Grader {

	public static void main(String[] args) throws IOException{
 
		int grade = 0;
	
		FileWriter fw = new FileWriter("/home/mllab/Desktop/CS140/Grading_Scripts/lab-01/report.txt", true);
		Loanee l = new Loanee(100);

		//Check getMoney() Method
		try{

			Method getMoney = Loanee.class.getMethod("getMoney");
			if(getMoney.getGenericReturnType() == int.class){
				grade += 1;
				int getMoneyRet = (int) getMoney.invoke(l);
				if(getMoneyRet == 100){
					grade +=1;
				}else{
					fw.write("getMoney wrong return value: " + getMoneyRet + "\n");
				}
			}else{
				fw.write("getMoney wrong return type: " + getMoney.getGenericReturnType() + "\n");
			}




		}catch(NoSuchMethodException e){
			fw.write("getMoney method not found\n");
		}catch(IllegalAccessException e){
			fw.write("getMoney invoke failed\n");
		}catch(InvocationTargetException e){
			fw.write("getMoney invoke failed2\n");			
		}

		//Check Tests from LoanSimulation.java

		Loanee person1 = new Loanee(100);
        boolean person1CanPay = person1.canPayLoan(100, 0, 10);
        if(person1CanPay){
        	grade += 2;
        }else{
        	fw.write("LoanSimulation.java case 1 wrong\n");
        }

        Loanee person2 = new Loanee(100);
        boolean person2CanPay = person2.canPayLoan(100, 0.1, 1);
        if(!person2CanPay){
        	grade += 1;
        }else{
        	fw.write("LoanSimulation.java case 2 wrong\n");
        }

        Loanee person3 = new Loanee(110);
        boolean person3CanPay = person3.canPayLoan(100, 0.1, 1);
      	if(person3CanPay){
        	grade += 1;
        }else{
        	fw.write("LoanSimulation.java case 3 wrong\n");
        }



		fw.write("Grade: " + grade + "\n");
		fw.close();


	}

	
}