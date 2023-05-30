package kr.or.ddit.Controller.form.textfield;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/textfield")
@Slf4j
public class JSPFormTextFieldTagController {

	/*
		4. 텍스트 필드 요소
		- HTML 텍스트 필드를 출력하려면 <form:input> 요소를 사용한다.
	*/
	
	// 1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() 실행...!");
		model.addAttribute("member", new Member());
		return "form/textfield/registerForm01";
	}
}
