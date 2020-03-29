package retrofitrestapi.com.ouz.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import retrofitrestapi.com.ouz.domain.Il;
import retrofitrestapi.com.ouz.domain.Ilce;
import retrofitrestapi.com.ouz.domain.Mahalle;
import retrofitrestapi.com.ouz.util.NetworkUtil;

@Controller
public class MyController {

	private String message = "Hello World !!!";

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping("/about")
	public String aboutReq(Model model) {
		model.addAttribute("message", "Turan");
		return "hello";
	}
	
	@GetMapping("/getProvince")
	public String getProvince(Model model) throws Exception {
		
		NetworkUtil networkUtil = NetworkUtil.getInstance();
		
		List<Il> illerList = networkUtil.getProvinces();
		
		model.addAttribute("ilAdi",illerList.get(0).getNAME());
		
		
		return "hello";
	}
	
	
	@GetMapping("/getTowns/{parentId}")
	public String getTowns(@PathVariable("parentId")String parentId, Model model) throws Exception {
		
		NetworkUtil networkUtil = NetworkUtil.getInstance();
		
		List<Ilce> ilceList = networkUtil.getTownWithParentId(Integer.valueOf(parentId));
		
		model.addAttribute("ilAdi",ilceList.get(0).getNAME());
		
		
		return "hello";
	}

	
	@GetMapping("/getQuarters/{parentId}")
	public String getQuarters(@PathVariable("parentId")String parentId, Model model) throws Exception {
		
		NetworkUtil networkUtil = NetworkUtil.getInstance();
		
		List<Mahalle> mahalleList = networkUtil.getQuartersWithParentId(Integer.valueOf(parentId));
		
		model.addAttribute("ilAdi",mahalleList.get(0).getNAME());
		
		return "hello";
	}

}
