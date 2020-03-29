package retrofitrestapi.com.ouz.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @RequestMapping(path="/message/{name}/{age}")
    public String getMessage(@PathVariable("name") String name, @PathVariable("age") String age) {
        
        String msg = String.format("%s is %s years old", name, age);
        
        return msg;
    }
    
	@RequestMapping(path="/getImage/{imagePath}")
	public String getImage(@PathVariable(value = "imagePath") String path) {
		
		return String.format("Hello %s!", path);
	}
	
}