package javaprograms;

public class StringManipulation {

	public static void main(String[] args) {
		String str1 = "Hellow";
		String str2 = "LOLOLOLO";
		String spaces = " Hey Dude ! ";
		String txt = "Welcome to Test Leaf";
		StringManipulation obj = new StringManipulation();
		
		
		
		if (obj instanceof Object)
		{
			System.out.println("obj is an object of class StringManipulation");
		}
		System.out.println(obj instanceof StringManipulation);
		// Printing String
		System.out.println("Actual String:" + spaces);
		// trim
		System.out.println("Trimming:" + spaces.trim());
		// Method 1
		String removingWS = spaces.replaceAll(" ", "");
		System.out.println("Method1: ReplaceAll:" + removingWS);
		// Method 2
		String[] afterSplit = spaces.split("( )");
		StringBuilder builder = new StringBuilder();
		for (String s : afterSplit) {
			builder.append(s);
		}
		System.out.println("Method2: Builder without space:" + builder);
		
		//Finding occurence of character in string
		String charS = "e";
		int count = txt.split(charS).length-1;
		System.out.println("The character"+"\""+charS+"\""+"available in String"+"\""+txt+"\""+" "+count);

		boolean test = checkString(str1);
		if (test) {
			System.err.println("The String Holds Number: " + str1);
		} else {
			System.err.println("The string holds Alphabets  " + str1);
		}
		clipLetter(str2);

	}

	public static boolean checkString(String sample) {
		try {
			Integer.parseInt(sample);
			return true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	public static void clipLetter(String str2) {
		char clip[] = str2.toUpperCase().toCharArray();
		int charLength = clip.length;
		boolean firstValue = true;
		String x = new String();
		for (int i = 0; i < charLength; i++) {
			for (int y = i + 1; y < charLength; y++) {
				if (y == charLength - 1 && charLength > 3) {
					i = charLength;
					break;
				}
				if (clip[i] == clip[y]) {
					firstValue = true;
					break;
				} else {
					if (firstValue) {
						x = clip[i] + "";
						firstValue = false;
					}
				}
			}
		}
		System.out.println("The Non repeated first value of String is: " + x);
	}

}
