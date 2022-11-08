import java.util.Scanner;

import java.text.DecimalFormat;

public class Gradebook {

	public static void main(String[] args) {
		/*Create format for returning grade to have a decimal point and 2 integers to the right of it.*/
		DecimalFormat f = new DecimalFormat("#.##");
		
		Scanner scanner = new Scanner(System.in);
		
		/* Creating prompt for teachers to import the students name,credit, and grades*/
		System.out.println("This is the interactive grade book. What is the students name?");
		String userName = scanner.nextLine();
		
		System.out.println("Did the student receive participation credit? (yes/no)");
		String userPar = scanner.nextLine();
		
		System.out.println("Enter Project 1 grade.");
		int projOne = scanner.nextInt();
		
		System.out.println("Enter Project 2 grade.");
		int projTwo = scanner.nextInt();
		
		System.out.println("Enter Midterm 1 grade.");
		int midOne = scanner.nextInt();
		
		System.out.println("Enter Midterm 2 grade.");
		int midTwo = scanner.nextInt();
		
		System.out.println("Enter Midterm 3 grade.");
		int midThree = scanner.nextInt();
		
		System.out.println("Enter Final Exam grade.");
		int finalExam = scanner.nextInt();
		
		/* The "* * * *" were used to separated previous prompt from output */
		System.out.println("* * * * *");
		System.out.println();
		
		System.out.println("This is the grade summary for " + userName + ".");
		
		/* If statement was made to determine if the student received participation credit by utilizing userPar to evaluate the string */
		if(userPar.equals("yes")) {
			System.out.println("Participation score: 100");
		}
		else {
			System.out.println("Participation score: 0");
		}
		
		/* The following are functions to accumulate to the final grade */
		
		/* This function adds the two project scores and divides them in half to get the final project score */
		double projScore = (projOne + projTwo) / 2;
		System.out.println("Project score: " + (f.format(projScore)));
		
		/* This function calculates the midterm score and substituting the lowest one for the final grade if it is higher by utilizing if statements*/
		double midtermScore;
		if(finalExam > midOne && midOne < midTwo && midOne < midThree) {
			midOne = finalExam;
			midtermScore = (midOne + midTwo + midThree) / 3;
			System.out.println("Midterm score: " + (f.format(midtermScore)));
			System.out.println("A midterm grade was replaced by the final exam grade.");
		}
		else if(finalExam > midTwo && midTwo < midOne && midTwo < midThree) {
			midTwo = finalExam;
			midtermScore = (midOne + midTwo + midThree) / 3;
			System.out.println("Midterm score: " + (f.format(midtermScore)));
			System.out.println("A midterm grade was replaced by the final exam grade.");
		}
		else if(finalExam > midThree && midThree < midOne && midThree < midTwo) {
			midThree = finalExam;
			midtermScore = (midOne + midTwo + midThree) / 3;
			System.out.println("Midterm score: " + (f.format(midtermScore)));
			System.out.println("A midterm grade was replaced by the final exam grade.");
		}
		/* If the final grade was lower than all of the midterm scores none of them would switch*/
		else {
			midtermScore = (midOne + midTwo + midThree) / 3;
			System.out.println("Midterm score: " + (f.format(midtermScore)));
		}
		
		/*Printing of the final exam score previously provided*/
		System.out.println("Final Exam score: " + finalExam);
		
		/* This function is to tally all the scores together to get the final grade*/
		
		 double totalScore;
		 if(userPar.equals("yes")) {
			 totalScore = (0.1 * 100) + (.35 * projScore) + (.3 * midtermScore) + (.25 * finalExam);
			 System.out.println("Total score: " + (f.format(totalScore)));
		 }
		 else {
			 totalScore = (0.1 * 0) + (.35 * projScore) + (.3 * midtermScore) + (.25 * finalExam);
			 System.out.println("Total score: " + (f.format(totalScore)));
		 }
		 
		    /* The following if statements are made to determine the letter grade depending on the total score */
		    if (totalScore > 100) {
				System.out.println("Invalid");
				return;
			}
			if(totalScore >= 90) {
				System.out.println("Final grade: A");
			}
			else if(totalScore >= 80) {
				System.out.println("Final grade: B");
			}
			else if(totalScore >= 70) {
				System.out.println("Final grade: C");
			}
			else if(totalScore >= 60) {
				System.out.println("Final grade: D");
			}
			else {
				System.out.println("Final grade: F");
			}
			System.out.println("* * * * *");
	}

}
