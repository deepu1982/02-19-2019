package json;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jsondomain.Student;

public class DataBindingWrite {

	public static void main(String[] args) {
		
		ObjectMapper objMap = new ObjectMapper();
		
		Student stnt = new Student();
		stnt.setId(1001);
		stnt.setName("Deepu");
		stnt.setLastName("Vikraman");
		
		Student stnt1 = new Student();
		stnt1.setId(1002);
		stnt1.setName("Anil");
		stnt1.setLastName("Beeram");
		
		
		Map<String,Object> jsonMap = new LinkedHashMap<String,Object>();
		
		
		jsonMap.put("key1", "value1");
		jsonMap.put("array", new String[]{"a","b","c"});
		jsonMap.put("boolean", "true");
		jsonMap.put("StudentArray", new Student[]{stnt,stnt1});
		jsonMap.put("student", stnt);
		jsonMap.put("Integer", 1);
		jsonMap.put("Null", null);
		jsonMap.put("Date", LocalDateTime.now());
		
		try {
			System.out.println(objMap.writeValueAsString(jsonMap));
			try {
				objMap.writerWithDefaultPrettyPrinter().writeValue(new File("jsonObj.json"), jsonMap);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
