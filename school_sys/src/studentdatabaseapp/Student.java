package studentdatabaseapp;

import java.util.Scanner;

public class Student {
	
	private String first_name;
	private String last_name;
	private int grade_year;
	private String student_id;
	private String courses = "";
	private int tuition_balance = 0;
	private static int cost_of_course = 600;
	private static int id = 1000;
	private static Scanner in = new Scanner(System.in);
	
	public Student() {
		System.out.print("Enter student first name: ");
		this.first_name = in.nextLine();
		
		System.out.print("Enter student last name: ");
		this.last_name = in.nextLine();
		
		System.out.print("1 - Freshman\n2 - Sophmore\n3 - Junior\n4- Senior\nEnter student grade level: ");
		this.grade_year = in.nextInt();
		
		set_student_id();	
	}
	
	private void set_student_id() {
		id++;
		this.student_id = grade_year + "" + id;
	}
	
	public void enroll() {
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			String course = in.nextLine();
			if(!course.equals("Q")) {
				courses = courses + "\n " + course;
				tuition_balance += cost_of_course;
			} else {
				break;
			}
		} while (1 != 0);
	}

	public void view_balance() {
		System.out.print("Your balance is: " + tuition_balance);
	}
	
	public void pay_tuition() {
		view_balance();
		System.out.print("Enter your payment: $");
		int payment = in.nextInt();
		tuition_balance -= payment;
		System.out.println("Thank you for your payment of $" + payment);
		view_balance();
	}
	
	public String show_info() {
		return "\nName: " + first_name + " " + last_name + 
				"\nGrade Level: " + grade_year +
				"\nStudent ID: " + student_id + 
				"\nCourses Enrolled: " + courses + 
				"\nBalance: $" + tuition_balance;
	}
	
}
