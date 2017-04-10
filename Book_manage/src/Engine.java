import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Engine {

	Scanner scan = new Scanner(System.in);
	String filePath = "c:\\Lee\\Book.txt";

	public void diplayMenu() {
		System.out.println("");
		System.out.println("���� ���� ���α׷��Դϴ�.");
		System.out.println("1. ��ü ��� ���");
		System.out.println("2. ���� �˻�");
		System.out.println("3. �ű� ���� �߰�");
		System.out.println("4. ���� ���� ���");
		System.out.println("0. ���α׷� ����");
		System.out.println("");
	}

	public int inputChoice() {

		int choice = -1;

		System.out.println("�޴��� ���� �ϼ��� : ");

		choice = scan.nextInt();

		scan.nextLine();
		System.out.println();

		return choice;

	}

	public void deleteBook() throws IOException {

		String tmpFilePath = filePath + ".tmp";
		int count = 1;

		System.out.print("������ å ��ȣ�� �Է��� �ּ��� : ");
		int deleteLineNumber = scan.nextInt();
		System.out.println("å ��ȣ : " + deleteLineNumber);

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		BufferedWriter bw = new BufferedWriter(new FileWriter(tmpFilePath));
		String str = "";

		while ((str = br.readLine()) != null) {
			if (count != deleteLineNumber) {

				bw.write(str);
				bw.write("\r\n");
			}
			count++;

		}

		bw.close();
		br.close();

		FileInputStream fis = new FileInputStream(tmpFilePath);
		FileOutputStream fos = new FileOutputStream(filePath);

		int data = 0;
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}

		fis.close();
		fos.close();
		File f = new File(tmpFilePath);
		f.deleteOnExit();

	}

	public void insertBook() throws IOException {

		Book b = new Book();
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		System.out.println("�߰��� å�� ������ �Է��� �ּ��� : ");

		System.out.println("å �̸� : ");
		b.setName(scan.nextLine());

		System.out.println("�� �� : ");
		b.setAuthor(scan.nextLine());

		System.out.println("���ǻ� : ");
		b.setPublisher(scan.nextLine());

		System.out.println("�� �� :");
		b.setCost(scan.nextLine());

		System.out.println(b.toString());

		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getCost());
		bw.newLine();
		bw.close();
	}

	public void searchBook() throws FileNotFoundException {

		System.out.println("�˻��� Ű���带 �Է��ϼ��� : ");
		String keyword = scan.nextLine();
		String str = "";

		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {
			while ((str = br.readLine()) != null) {

				if (str.contains(keyword)) {
					System.out.println(str);
				}

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printBooks() throws FileNotFoundException {

		int count = 1;
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String str = "";

		try {
			while ((str = br.readLine()) != null) {
				System.out.println("(" + count + ") \t" + str);
				count++;
			}
			br.close();

		} catch (IOException e) {
			System.out.println("å ������ �о� �� �� �����ϴ�.");
			System.out.println("����� ������ ã�� �� �����ϴ�..");
			e.printStackTrace();

		}
	}
}
