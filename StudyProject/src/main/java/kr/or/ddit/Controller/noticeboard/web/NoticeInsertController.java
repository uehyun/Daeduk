package kr.or.ddit.Controller.noticeboard.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.Controller.noticeboard.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice")
@Slf4j
public class NoticeInsertController {
	
	@Resource(name="uploadPath")
	public String resourcePath;
	
	@Inject
	private INoticeService noticeService;

	@RequestMapping(value = "/form.do", method = RequestMethod.GET)
	public String noticeInsertForm() {
		return "notice/form";
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, Model model) {
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {
			errors.put("boTitle", "제목을 입력해주세요.");
		}
		if(StringUtils.isBlank(noticeVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요.");
		}
		
		if(errors.size()>0) {	// 에러가 발생
			model.addAttribute("errors", errors);
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		} else {
			noticeVO.setBoWriter("a001");	// 임시로 넣어둔다.
			ServiceResult result = noticeService.insertNotice(noticeVO);
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/notice/detail.do?boNo=" + noticeVO.getBoNo();
			} else {
				model.addAttribute("message", "서버에러, 다시 시도해주세요!");
				goPage = "notice/form";
			}
		}
		return goPage;
	}
	
	// 요청 URI : /notice/generalForm
	// 요청방식 : get
	@GetMapping("/generalForm")
	public String generalForm() {
		// forwarding
		return "notice/generalForm";
	}
	
	/*
		요청 URI : /notice/generalFormPost
		요청 방식 : post
		요청 파라미터 : {boTitle=제목, boContent=내용, boWriter=작성자, boFile=파일}
		
		@ResponseBody : json을 text로 return 할 때 사용
	 */
	
	@ResponseBody
	@PostMapping("/generalFormPost")
	public String generalFormPost(NoticeVO notice) {
		log.info("noticeVO : " + notice);
		// 파일을 업로드할 대상
		MultipartFile[] boFile = notice.getBoFile();
		
		for(MultipartFile multipartFile : boFile) {
			log.info("----------------------------------");
			log.info("원본이름 : " + multipartFile.getOriginalFilename());
			log.info("파일 크기 : " + multipartFile.getSize());
			log.info("파일 타입 : " + multipartFile.getContentType());
			
			// File 객체 복사 설계(복사할 대상 경로, 파일명)
			File saveFile = new File(resourcePath, multipartFile.getOriginalFilename());
			
			// 연/월/일 폴더 생성
			
			// UUID처리(파일명 중복 방지)
			
			// 파일 복사 실행(파일원본.transferTo(설계))
			try {
				multipartFile.transferTo(saveFile);
				return "Success";
			} catch (IllegalStateException | IOException e) {
				log.error(e.getMessage());
				return "Failed";
			}
		}
		this.noticeService.insertNotice(notice);
		
		return "Success";
	}
}
