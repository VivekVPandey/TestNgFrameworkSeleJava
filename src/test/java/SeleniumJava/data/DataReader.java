package SeleniumJava.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	//read json to string
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
	String jsonConetent= FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\SeleniumJava\\data\\PurchaseOrder.json")
			,StandardCharsets.UTF_8);
	
	//String to json
	
	ObjectMapper mapper= new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonConetent, new TypeReference<List<HashMap<String,String>>>() {
	//asf
});
	return data;
}
}