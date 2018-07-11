package laffan.marc;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONArray;
import org.json.JSONTokener;

public class JsonParser {

	public List<Integer> readFromFile(String filePath) throws Throwable {
		JSONTokener tokener;
		List<Integer> custNumEntList = new ArrayList<Integer>();
		try {
			tokener = new JSONTokener(new FileReader(filePath));   
			JSONArray jsonArray = new JSONArray(tokener);
			
			for(int current = 0; current < jsonArray.length(); current++) {
				try {
					String numString = (String) jsonArray.getJSONObject(current).get("number").toString();
					if(!NumberUtils.isCreatable(numString)) {
						throw new NumberFormatException("Non-numeric data (" + numString + ")");
					}
					custNumEntList.add(new Integer(numString));
				}
				catch(Exception e) {
					System.out.println("Could not read data row. The following data was not added: " + e.getMessage());
				}
				
			}
        }
		catch (Throwable t) {
			System.out.println("Could not read file");
			t.printStackTrace();
			throw t;			
		}
		
		return custNumEntList;
	}
	
}
