package kr.or.ddit.main.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class MainController {
	
	@Inject
	private IMainService mainService;
	
	@RequestMapping(value={"/","/main.do"}, method = RequestMethod.GET)
	public String main(Model model) {
		// 일반게시판 게시글 총 5개의 정보를 가져와서 메인화면에 뿌릴거임
		List<BoardVO> boardList = mainService.selectBoardList();
		List<FreeVO> freeList = mainService.selectFreeList();
		List<NoticeVO> noticeList = mainService.selectNoticeList();
		
		int totalBoard = mainService.selectBoardCount();
		int totalFree = mainService.selectFreeCount();
		int totalNotice = mainService.selectNoticeCount();
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("freeList", freeList);
		model.addAttribute("noticeList", noticeList);
		
		model.addAttribute("totalBoard", totalBoard);
		model.addAttribute("totalFree", totalFree);
		model.addAttribute("totalNotice", totalNotice);
		return "main";
	}
	
}
