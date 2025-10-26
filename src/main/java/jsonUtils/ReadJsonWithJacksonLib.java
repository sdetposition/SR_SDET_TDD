package jsonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJsonWithJacksonLib {
	
	
	public static void readCollegeJson(String jsonFilePath) throws StreamReadException, DatabindException, IOException {		
		ObjectMapper objMapper = new ObjectMapper();
		File file = new File(jsonFilePath);
		
		College college =  objMapper.readValue(file, College.class);
		List<Students> students = college.getStudents();
		for(Students s : students) {
			if(s.getId().equals("A2")) {
				int val = s.getGrade().getMath();
				System.out.println("Math Markes of A2 Is : "+val);
				break;
			}
			
		}
	}
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		String jsonFilePath = System.getProperty("user.dir")+"\\src\\main\\resources\\jsonFiles\\college.json";
		
		readCollegeJson(jsonFilePath);
		
		
	}

}
