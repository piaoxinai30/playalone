import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Sinae implements Serializable{

	Scanner sc = new Scanner(System.in);
	ArrayList<Diet> dlist = new ArrayList<Diet>();

	void add() {

		System.out.println("날짜");
		int da = sc.nextInt();
		sc.nextLine();

		System.out.println("메뉴");
		String mn = sc.nextLine();

		System.out.println("시간");
		String tm = sc.nextLine();

		dlist.add(new Diet(da, mn, tm));

	}

	void show() {
		for (int i = 0; i < dlist.size(); i++) {
			System.out.println(dlist.get(i));
		}
	}

	void modify() {
		for (int i = 0; i < dlist.size(); i++) {
			System.out.println("번호: " + i + dlist.get(i));
		}
		System.out.println("수정할 번호를 입력하세요");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.println("메뉴를 수정하세요");
		String correctMenu = sc.nextLine();
		System.out.println("수정되었습니다.");

		dlist.get(number).setMenu(correctMenu);

	}

	void saveFile() {
		String file = "Sinae.txt";

		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			// BufferedOutputStream bos = new BufferedOutputStream(fos);

			ObjectOutputStream ous = new ObjectOutputStream(fos);

			ous.writeObject(dlist);
			
			ous.close();
			fos.close();
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}

	}
	
	void loadFile() {
		
		//File file = new File("Sinae.txt");
		try {
			FileInputStream fis = new FileInputStream("Sinae.txt");
			// BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			dlist = (ArrayList)ois.readObject();
			
			ois.close();
			fis.close();
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			for(int i = 0; i < dlist.size(); i++) {
				System.out.println(dlist.get(i));
			}
		}
		/*
		 * private void load() {
		File file = new File("bmi.txt");
		try{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			map = (HashMap)oos.readObject();
			
			Set<Integer> set = map.keySet();
			System.out.println("번호\t키\t몸무게\t결과\t판정");
			for (Integer number : set) {
				double length = map.get(number).getLength();
				double weight = map.get(number).getWeight();
				double result = map.get(number).getResult();
				String you = map.get(number).getYou();

				System.out.printf("[%s]\t%.2f\t%.2f\t%.2f\t%s\n", number, length, weight, result, you);
			}
			oos.close();
			fis.close();
			
		}catch(Exception e){
			System.out.println("불러오는데 실패하였습니다.");
			e.printStackTrace();
		}
	}
		 */
	}

}
