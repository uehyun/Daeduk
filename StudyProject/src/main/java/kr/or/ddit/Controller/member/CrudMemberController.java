package kr.or.ddit.Controller.member;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/crud/member")
@Slf4j
public class CrudMemberController {
	
	@Inject
	private IMemberService service;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String crudMemberRegisterForm() {
		log.info("crudMemberRegisterForm() 실행...!");
		return "crud/member/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String crudMemberRegister(MemberVO member, Model model) {
		log.info("crudMemberRegister() 실행...!");
		service.register(member);
		model.addAttribute("msg", "등록이 완료되었습니다.");
		return "crud/member/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String crudMemberList(Model model) {
		log.info("crudMemberList() 실행...!");
		List<MemberVO> memberList = service.list();
		model.addAttribute("memberList", memberList);
		return "crud/member/list";
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String crudMemberRead(int userNo, Model model) {
		log.info("crudMemberRead() 실행...!");
		MemberVO member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/read";
	}

}
