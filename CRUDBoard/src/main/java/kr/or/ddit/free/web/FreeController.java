package kr.or.ddit.free.web;

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
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/free")
public class FreeController {
	
	@Inject
	private IFreeService freeService;
	
	@RequestMapping(value = "/list.do")
	public ModelAndView boardList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,
			Model model) {
		
			PaginationInfoVO<FreeVO> pagingVO = new PaginationInfoVO<FreeVO>();
			ModelAndView mav = new ModelAndView();
			
			if(StringUtils.isNotBlank(searchWord)) {
				pagingVO.setSearchType(searchType);
				pagingVO.setSearchWord(searchWord);
				model.addAttribute("searchType", searchType);
				model.addAttribute("searchWord", searchWord);
			}
			
			pagingVO.setCurrentPage(currentPage);
			int totalRecord = freeService.selectFreeCount(pagingVO);
			pagingVO.setTotalRecord(totalRecord);
			List<FreeVO> dataList = freeService.selectFreeList(pagingVO);
			pagingVO.setDataList(dataList);
			model.addAttribute("pagingVO", pagingVO);
			model.addAttribute("totalRecord", totalRecord);
			mav.setViewName("free/list");
			return mav;
			
	}
	
	
	
	@RequestMapping(value="/form.do", method = RequestMethod.GET)
	public ModelAndView formFree() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("free/form");
		return mav;
	}
	
	@RequestMapping(value="/insert.do", method = RequestMethod.POST)
	public ModelAndView insertFree(@RequestParam Map<String, Object> map, Model model) {
		
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
			model.addAttribute("free", map);
			mav.setViewName("free/form");
		} else {
			ServiceResult result = freeService.insertFree(map);
			if(result.equals(ServiceResult.OK)) {
				mav.setViewName("redirect:/free/detail.do?boNo=" + map.get("boNo").toString());
			} else {
				errors.put("msg", "서버에러! 다시 시도해주세요!");
				model.addAttribute("errors", errors);
				mav.setViewName("free/form");
			}
		}
		return mav;
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public ModelAndView freeDetail(int boNo, Model model) {
		ModelAndView mav = new ModelAndView();
		FreeVO freeVO = freeService.selectFree(boNo);
		freeService.updateHit(boNo);
		model.addAttribute("free", freeVO);
		mav.setViewName("free/view");
		return mav;
	}
	
	@RequestMapping(value="/updateform.do", method = RequestMethod.GET)
	public ModelAndView freeUpdateForm(Integer boNo, Model model) {
		ModelAndView mav = new ModelAndView();
		if(boNo == null) {
			mav.setViewName("redirect:/free/list.do");
			return mav;
		}
		FreeVO freeVO = freeService.selectFree(boNo);
		model.addAttribute("free", freeVO);
		model.addAttribute("status", "u");
		mav.setViewName("free/form");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public ModelAndView freeUpdate(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		ServiceResult result = freeService.freeUpdate(map);
		if(result.equals(ServiceResult.OK)) {
			mav.setViewName("redirect:/free/detail.do?boNo=" + map.get("boNo").toString());
		} else {
			mav.setViewName("redirect:/free/updateform.do?boNo=" + map.get("boNo").toString());
		}
		return mav;
	}
	
	@RequestMapping(value="/delete.do")
	public ModelAndView freeDelete(Integer boNo) {
		ModelAndView mav = new ModelAndView();
		if(boNo == null) {
			mav.setViewName("redirect:/free/list.do");
			return mav;
		}
		ServiceResult result = freeService.freeDelete(boNo);
		if(result.equals(ServiceResult.OK)) {
			mav.setViewName("redirect:/free/list.do");
		} else {
			mav.setViewName("redirect:/free/detail.do?boNo=" + boNo);
		}
		return mav;
	}

}
