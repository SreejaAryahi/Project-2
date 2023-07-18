package crorepati;

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

class que {
	String[] qs = new String[] {
			"What is the name of our Country ?","What is the name of our national Bird ?",
			"What is the color of Sky ?", "Who is our prime minister ?","What is the chemical formula for Water ?",
			"What is the name of our national Fruit ?","What is the name of our national Animal ?","On which year IPL started ?",
			"What is the full form of RCB ?","How many times RCB Won IPL ?"		
	};
	
	static String[][] opts = new String[][] {
		{"India","Australia","Dubai","Iran"},
		{"Chicken","Peacock","Pegion","Duck"},
		{"Red","White","Blue","Yellow"},
		{"Narendra Modi","Dibya kumar","Ujjwal","Sajal"},
		{"N2O","CH4","NH3","H2O"},
		{"Banana","Lichi","Mango","Apple"},
		{"Elephant","Tiger","Lion","Fox"},
		{"2001","2018","2020","2008"},
		{"Royal challengers Banglore","Royal chance Bhutan ","Rabel Chalengers Bengaluru","Red Color Blood"},
		{"13","4","1","None"}
	};
	static int[] ans = new int[] {1,2,3,1,4,3,2,4,1,4};
}

class userDetails {
	private String name;
	private int age;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

class check extends que {
	Scanner sc = new Scanner(System.in);
	que qn = new que();
	String ll;
	int f = 1;
	int a = 1;
	int clf = 2;
	int count_que = 1;
	int won = 0000;
	int option;

	int ip;

	void choose() {
		if (clf == 0) {
			System.out.println("\nNO LIFE LINE");
			System.out.println("\nEnter your answer");
			option = sc.nextInt();
			check_ans(option);
		}
		System.out.println("\nAvailable LIFE-LINES :\n");
		if (f == 1 && a == 1) {
			System.out.println("1. 50-50\n2. Audience Poll");
			System.out.println("\nEnter your choice -->");
			ip = sc.nextInt();
			if (ip == 1) {
				clf--;
				f--;
				ff();
			} else {
				clf--;
				a--;
				ap();
			}
		} else if (f == 0) {

			System.out.println("\n2. Audience Poll");
			System.out.println("\nLife line ? Y/N");
			ll = sc.next();
			if (ll.equalsIgnoreCase("y")) {
				clf--;
				System.out.println("\nEnter your choice -->");
				ip = sc.nextInt();
				ap();
			} else {

				System.out.println("\nEnter your answer");
				option = sc.nextInt();
				check_ans(option);
			}

		} else if (a == 0) {

			System.out.println("\n1. 50-50");
			System.out.println("\nLife line ? Y/N");
			ll = sc.next();
			if (ll.equalsIgnoreCase("y")) {
				clf--;
				System.out.println("\nEnter your choice -->");
				ip = sc.nextInt();
				ff();
			} else {

				System.out.println("\nEnter your answer");
				option = sc.nextInt();
				check_ans(option);
			}
		}
	}

	void ff() {
		System.out.println("\nYou have choosen 50-50");
		System.out.println("\nQ" + (count_que) + ". " + qn.qs[count_que - 1] + "\n");
		System.out.println((que.ans[count_que - 1]) + ". " + opts[count_que - 1][que.ans[count_que - 1] - 1]);// right
																												// answer
		System.out.println((5 - que.ans[count_que - 1]) + ". " + opts[count_que - 1][4-que.ans[count_que - 1]]);// wrong
																														// answer
		choose();

	}

	void ap() {
		System.out.println("\nYou have choosen Audiance poll");
		Random random = new Random();
		int totalVotes = 100; // Total number of audience votes

		// Generate random percentage for each option
		int[] percentages = new int[opts[count_que - 1].length];
		int remainingPercentage = 100;
		int max = -1;
		for (int i = 0; i < opts[count_que - 1].length - 1; i++) {
			int percentage = random.nextInt(remainingPercentage);
			percentages[i] = percentage;
			remainingPercentage -= percentage;
			max = Math.max(percentages[i], max);
		}

		percentages[opts[count_que - 1].length - 1] = remainingPercentage;
		max = Math.max(percentages[opts[count_que - 1].length - 1], max);
		//System.out.println("max - " + max);
		// Display the audience poll results
		int x = -1;
		int temp;
		//System.out.println("Audience Poll Results:");
		for (int i = 0; i < opts[count_que - 1].length; i++) {
			if (percentages[i] == max) {
				x = i;

			}
			//System.out.println((i + 1) + ": " + percentages[i] + "%");
		}
		//System.out.println("max - index " + (x + 1));
		temp = percentages[x];
		percentages[x] = percentages[que.ans[count_que - 1] - 1];
		percentages[que.ans[count_que - 1] - 1] = temp;
		//System.out.println("Audience Poll Results: after");
		for (int i = 0; i < opts[count_que - 1].length; i++) {

			System.out.println((i + 1) + ": " + percentages[i] + "%");
		}

		System.out.println("\nQ" + (count_que) + ". " + qn.qs[count_que - 1] + "\n");
		for (int i = 0; i < opts[count_que - 1].length; i++) {
			System.out.println((i + 1) + ". " + opts[count_que - 1][i]);
		}
		choose();

	}

	void check_ans(int answ) {
		if (answ == que.ans[count_que - 1]) {
			System.out.println("\nC  O  N  G  R  A  T  U  L  A  T  I  O  N  S");
			won = won + 1000000;
			System.out.println("\n   Y O U  H A V E  W O N  Rs " + won);

			if (count_que == 10) {
				System.out.println("\nT H A N K S  F O R  P L A Y I N G");
				System.exit(0);
			}
			System.out.println("\nNEXT QUESTION ");
			count_que++;
			ques();

		} else {
			System.out.println("\nW R O N G  A N S W E R");
			System.out.println("\nY O U  H A V E  W O N  Rs " + won);
			System.out.println("\nT H A N K S  F O R  P L A Y I N G");
			System.exit(0);

		}
	}

	void ques() {

		int option;
		System.out.println("\nQ" + (count_que) + ". " + qn.qs[count_que - 1] + "\n");
		for (int i = 0; i < opts[count_que - 1].length; i++) {
			System.out.println((i + 1) + ". " + opts[count_que - 1][i]);
		}

		System.out.println("\nLife line ? Y/N");
		ll = sc.next();

		if (ll.equalsIgnoreCase("y")) {
			choose();
		} else {
			System.out.println("\nEnter your answer");
			option = sc.nextInt();
			check_ans(option);
		}
	}

}


public class KBC {
	public static void main(String[] args) {
		userDetails u = new userDetails();
		final String name;
		final int age;
		final String gender;
		System.out.println("PLEASE ENTER YOUR DETAILS HERE");
		Scanner sc = new Scanner(System.in);
		System.out.println("NAME :");
		name = sc.nextLine();
		u.setName(name);
		System.out.println("AGE :");
		age = sc.nextInt();
		u.setAge(age);
		System.out.println("GENDER :");
		gender = sc.next();
		u.setGender(gender);
		System.out.println("\nWELCOME " + u.getName() + " IN KBC GAME");
		System.out.println("\nHERE IS YOUR DETAILS");
		System.out.println("\nNAME - " + u.getName() + "\nAGE - " + u.getAge() + "\nGENDER - " + u.getGender());
		System.out.println("\n\nNOW YOU CAN START ANSWERING QUESTIONS");
		
		//questions q=new questions();
		//q.question1();
		check q=new check();
		q.ques();
		sc.close();
		
		

	}
}


