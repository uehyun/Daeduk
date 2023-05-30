package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.dao.INoticeDAO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class NoticeServiceImpl implements INoticeService {
	
	@Inject
	private INoticeDAO noticeDao;

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeDao.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return noticeDao.selectNoticeList(pagingVO);
	}

	@Override
	public ServiceResult insertNotice(Map<String, Object> map) {
		ServiceResult result = null;
		int status = noticeDao.insertNotice(map);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		return noticeDao.selectNotice(boNo);
	}

	@Override
	public void updateHit(int boNo) {
		noticeDao.updateHit(boNo);
		
	}

	@Override
	public ServiceResult noticeUpdate(Map<String, Object> map) {
		ServiceResult result = null;
		int status = noticeDao.noticeUpdate(map);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult noticeDelete(int boNo) {
		ServiceResult result = null;
		int status = noticeDao.noticeDelete(boNo);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

}
