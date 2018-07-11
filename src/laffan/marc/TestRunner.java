package laffan.marc;

import java.util.List;

public class TestRunner {
	
	public static void main(String args[]) {
		JsonParser jspr = new JsonParser();
		List<Integer> listOfNums = null;
		try {
			listOfNums = jspr.readFromFile("src\\laffan\\marc\\data.json");
		    System.out.println(listOfNums);
		} catch (Throwable e) {
			e.printStackTrace();
		}
				                             
	}

}
