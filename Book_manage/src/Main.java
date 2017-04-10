
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {

		Engine e = new Engine();
		
		int choice = -1;

		while (choice != 0){
			
			e.diplayMenu();
		choice = e.inputChoice();
		
		switch (choice) {

		case 1:

			e.printBooks();

			break;

		case 2:

			e.searchBook();

			break;

		case 3:

			e.insertBook();

			break;

		case 4:

			e.deleteBook();

		case 0:

			System.out.println("종료 합니다");
			System.exit(0);
			break;
		default:

			System.out.println("다시 입력해주세요");

		}
		}
	}

	

}
