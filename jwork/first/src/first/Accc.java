package first;

import java.util.*;

public class Accc {

	public static void main(String[] args) {

		Set<Integer> lottoOk = new TreeSet<Integer>();

		Random random = new Random();

		while (lottoOk.size() < 6) {
			int number = random.nextInt(46);
			lottoOk.add(number);

		}
		int bonus;

		do {
			bonus = random.nextInt(46);
		} while (lottoOk.contains(bonus));

		System.out.print(lottoOk);
		System.out.println(" " + bonus);

	}
}