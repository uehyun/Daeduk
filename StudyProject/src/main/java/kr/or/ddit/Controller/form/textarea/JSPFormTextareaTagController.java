package kr.or.ddit.Controller.form.textarea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/formtag/textarea")
@Slf4j
public class JSPFormTextareaTagController {
	
	/*
		8장. 스프링 폼 태그
		
		6. 텍스트 영역 요소 (textarea)
		- HTML 텍스트 영역을 출력하려면 <form:textarea> 요소를 사용한다.
	*/
	
	// 1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01() 실행...!");
		model.addAttribute("member", new Member());
		return "form/textarea/registerForm01";
	}
	
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02() 실행...!");
		Member member = new Member();
		member.setIntroduction("반갑습니다\n 안녕히계세요");
		model.addAttribute("member", member);
		return "form/textarea/registerForm01";
	}

}
