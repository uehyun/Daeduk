package kr.or.ddit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/modelattribute")
public class ModelAttributeMemberController {
	
	// 3. @ModelAttribute 어노테이션
	// - 매개변수로 전달받은 데이터를 전달할 때 사용한다.
	@RequestMapping(value="/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm() 실행...!");
		return "member/registerModelAttributeForm";
	}
	
	// 1) 기본 자료형은 매개변수로 선언했을 때 전달되는지 확인합니다.
	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId, String password) {
		log.info("register01() 실행...!");
		log.info("userId : " + userId);
		return "result";
	}

	// 2) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정하여 데이터를 전달한다.
	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(
			@ModelAttribute("userId") String userId,
			@ModelAttribute("password") String password
			) {
		log.info("register02() 실행...!");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "result";
	}
	@RequestMapping(value = "register03", method = RequestMethod.POST)
	public String register03(Member member) {
		log.info("register03() 실행...!");
		log.info("member.userId : " + member.getUserId());
		log.info("member.password : " + member.getPassword());
		return "result";
	}
}
