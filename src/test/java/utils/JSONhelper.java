package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import modal.Pet;

public class JSONhelper {

	public Pet JSONRequest() {
		Pet pet = new Pet();
		try {
			JSONParser parser = new JSONParser();		

			Object obj = parser.parse(new FileReader("src/test/resources/JSON/pet.json"));
			JSONObject jsonObject = (JSONObject) obj;

			Long id = (Long) jsonObject.get("id");
			pet.setId(id);
			
			String name = (String) jsonObject.get("name");
			pet.setName(name);

			String status = (String) jsonObject.get("status");
			pet.setStatus(status);

		}catch(FileNotFoundException e1)
		{
			e1.printStackTrace();
		}catch(IOException e2) {
			e2.printStackTrace();
		}catch(ParseException e3) {
			e3.printStackTrace();
		}
		return pet;
	}
}

