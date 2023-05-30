package kr.or.ddit.notice.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Inject
	private INoticeService noticeService;
	
	@RequestMapping(value = "/list.do")
	public ModelAndView noticeList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<NoticeVO>();
		ModelAndView mav = new ModelAndView();
		
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<NoticeVO> dataList = noticeService.selectNoticeList(pagingVO);
		pagingVO.setDataList(dataList);
		model.addAttribute("pagingVO", pagingVO);
		model.addAttribute("totalRecord", totalRecord);
		mav.setViewName("notice/list");
		return mav;
	}
	
	@RequestMapping(value ="/form.do", method = RequestMethod.GET)
	public ModelAndView formNotice() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/form");
		return mav;
	}
	
	@RequestMapping(value = "/insert.do", method = RequestMethod.POST)
	public ModelAndView insertNotice(@RequestParam Map<String, Object> map, Model model) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, String> errors = new HashMap<String, String>();
		
		if(StringUtils.isBlank(map.get("boTitle").toString())) {
			errors.put("boTitle", "제목을 입력해주세요!");
		}
		if(StringUtils.isBlank(map.get("boContent").toString())) {
			errors.put("boContent", "내용을 입력해주세요!");
		}
		if(errors.size()>0) {
			model.addAttribute("errors", errors);
			model.addAttribute("notice", map);
			mav.setViewName("notice/form");
		} else {
			ServiceResult result = noticeService.insertNotice(map);
			if(result.equals(ServiceResult.OK)) {
				mav.setViewName("redirect:/notice/detail.do?boNo=" + map.get("boNo").toString());
			} else {
				errors.put("msg", "서버에러! 다시 시도해주세요!");
				model.addAttribute("errors", errors);
				mav.setViewName("notice/form");
			}
		}
		return mav;
	}
	
	@RequestMapping(value = "/detail.do", method = RequestMethod.GET)
	public ModelAndView noticeDetail(int boNo, Model model) {
		ModelAndView mav = new ModelAndView();
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		noticeService.updateHit(boNo);
		model.addAttribute("notice", noticeVO);
		mav.setViewName("notice/view");
		return mav;
	}
	
	@RequestMapping(value = "/updateform.do",method = RequestMethod.GET)
	public ModelAndView noticeUpdateForm(Integer boNo, Model model) {
		ModelAndView mav = new ModelAndView();
		if(boNo == null) {
			mav.setViewName("redirect:/notice/list.do");
			return mav;
		}
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		mav.setViewName("notice/form");
		return mav;
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		ServiceResult result = noticeService.noticeUpdate(map);
		if(result.equals(ServiceResult.OK)) {
			mav.setViewName("redirect:/notice/detail.do?boNo=" + map.get("boNo").toString());
		} else {
			mav.setViewName("redirect:/notice/updateform.do?boNo=" + map.get("boNo").toString());
		}
		return mav;
	}
	
	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView noticeDelete(Integer boNo, Model model) {
		ModelAndView mav = new ModelAndView();
		if(boNo == null) {
			mav.setViewName("redirect:/notice/list.do");
			return mav;
		}
		ServiceResult result = noticeService.noticeDelete(boNo);
		if(result.equals(ServiceResult.OK)) {
			mav.setViewName("redirect:/notice/list.do");
		} else {
			mav.setViewName("redirect:/notice/detail.do?boNo=" + boNo);
		}
		return mav;
	}
}
