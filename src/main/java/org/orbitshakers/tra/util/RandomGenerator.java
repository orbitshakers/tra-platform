package org.orbitshakers.tra.util;

import java.util.Random;

public class RandomGenerator {

	public static String getAlphaNumeric(int len) {
		char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };

		char[] c=new char[len];
		Random random=new Random();
		for (int i = 0; i < len; i++) {
			c[i]=ch[random.nextInt(ch.length)];
		}

		return new String(c);
	}
}
