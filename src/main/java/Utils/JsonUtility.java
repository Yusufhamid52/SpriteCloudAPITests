package Utils;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	
	private JSONParser parser = new JSONParser();
	
	Map <Long, String> petDetails = new HashMap<>();
	
	public Map<Long, String> getPetIDAndNameFromResponseJson(String response) throws ParseException {
		
		JSONArray jsonArray = (JSONArray) parser.parse(response);
		
		for (Object obj : jsonArray) {
			JSONObject jsonObj = (JSONObject) obj;
			
			if(jsonObj.containsKey("id") && (jsonObj.containsKey("name"))) {
				petDetails.put(Long.parseLong(jsonObj.get("id").toString()), jsonObj.get("name").toString());
			}
		}
		
		return petDetails;
	}

}
