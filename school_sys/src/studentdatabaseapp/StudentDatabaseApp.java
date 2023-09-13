package studentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
		
		System.out.print("Enter number of new students to enroll: ");
		Scanner in = new Scanner(System.in);
		int num_of_students = in.nextInt();
		in.close();
		Student[] students = new Student[num_of_students];
		
		for(int n = 0; n < num_of_students; n++) {
			students[n] = new Student();
			students[n].enroll();
			students[n].pay_tuition();
			System.out.println(students[n].show_info());
		}
	}

}
