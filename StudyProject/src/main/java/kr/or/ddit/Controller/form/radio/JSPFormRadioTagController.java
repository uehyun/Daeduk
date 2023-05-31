package kr.or.ddit.Controller.form.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.CodeLabelValue;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/radio")
@Slf4j
public class JSPFormRadioTagController {

	/*
		8장 스프링 폼 태그
		
		9. 여러 개의 라디오 버튼 요소
		- HTML 라디오 버튼을 출력하려면 <form:radiobuttons> 요소를 사용한다.
	*/
	
	// 1) 모델에 Map타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadios01", method = RequestMethod.GET)
	public String registerFormRadios01(Model model) {
		log.info("registerFormRadios01() 실행...!");
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		
		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios01";
	}
	
	// 2) 모델에 List타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadios02", method = RequestMethod.GET)
	public String registerFormRadios02(Model model) {
		log.info("registerFormRadios02() 실행...!");
		
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
	
		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios02";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String registerFormRadioResult(Member member, Model model) {
		log.info("registerFormRadioResult() 실행...!");
		log.info("member.gender : " + member.getGender());
		
		model.addAttribute("gender", member.getGender());
		return "form/radio/result";
	}
	
	// 단일 radio 버튼
	
	/*
		8장 스프링 폼 태그
		
		10. 라디오 버튼 요소
		- HTML 라디오 버튼을 출력하려면 <form:radiobutton> 요소를 사용한다.
	*/
	
	@RequestMapping(value = "/registerFormRadio01", method = RequestMethod.GET)
	public String registerFormRadio01(Model model) {
		log.info("registerFormRadio01() 실행...!");
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadio01";
	}
	
	@RequestMapping(value = "/registerFormRadio02", method = RequestMethod.GET)
	public String registerFormRadio02(Model model) {
		log.info("registerFormRadio02() 실행..!");
		Member member = new Member();
		member.setGender("female");
		model.addAttribute("member", member);
		return "form/radio/registerFormRadio01";
	}
}
