package json;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jsondomain.Student;

public class DataBindingRead {

	public static void main(String[] args) {
		ObjectMapper objMapper = new ObjectMapper();
		String stu = "{"+
    "\"id\" : 1001," +
    "\"name\" : \"Deepu\"," +
    "\"lastName\" : \"Vikraman\""+
  "}";
		
		try {
			
			/*Student student = objMapper.readValue(stu, Student.class);
			
			System.out.println("id:"+student.getId());
			System.out.println("Name:"+student.getName());
			System.out.println("Last Name:"+student.getLastName());*/
		
			ClassLoader classLoader = DataBindingRead.class.getClassLoader();
			Map<String, Object> map = objMapper.readValue(new File(classLoader.getResource("jsonObj.json").getFile()), 
					new TypeReference<Map<String,Object>>(){
				
			}					
			);
			
			
			for(Map.Entry<String, Object> entry: map.entrySet()){
				System.out.println(entry);
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
