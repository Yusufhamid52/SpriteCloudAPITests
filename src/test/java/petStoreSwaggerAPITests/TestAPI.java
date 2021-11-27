package petStoreSwaggerAPITests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.JsonUtility;

public class TestAPI extends APITestsSetUp {

	List<Long> petIDs = new ArrayList<>();
	JsonUtility jsonUtility = new JsonUtility();

	@Test(priority = 0)
	public void testGetAllAvailablePetDetails() throws IOException, InterruptedException, ParseException {
		String response = pullRequest(Constants.PetStoreAPI + Constants.GetPetsByStatus + Constants.AvailablePetStatus);
		Assert.assertFalse(response.equals("[]") || response.isEmpty());

		Map<Long, String> petIDNameMap = jsonUtility.getPetIDAndNameFromResponseJson(response);

		for (Map.Entry<Long, String> petDetail : petIDNameMap.entrySet()) {
			petIDs.add(petDetail.getKey());
			System.out.println(petDetail.getKey() + " : " + petDetail.getValue());
		}

	}

	@Test(priority = 1)
	public void testFindPetByID() throws IOException, InterruptedException, ParseException {
			
			String response = pullRequest(Constants.PetStoreAPI + Constants.PetIdStatus + petIDs.get(0));
			Assert.assertFalse(response.equals("[]") || response.isEmpty());
		}

	}
