package kr.or.ddit.free.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.dao.IFreeDAO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class FreeServiceImpl implements IFreeService {
	
	@Inject
	private IFreeDAO freeDao;

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return freeDao.selectFreeCount(pagingVO);
	}

	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		return freeDao.selectFreeList(pagingVO);
	}

	@Override
	public ServiceResult insertFree(Map<String, Object> map) {
		ServiceResult result = null;
		int status = freeDao.insertFree(map);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public FreeVO selectFree(int boNo) {
		return freeDao.selectFree(boNo);
	}

	@Override
	public void updateHit(int boNo) {
		freeDao.updateHit(boNo);
		
	}

	@Override
	public ServiceResult freeDelete(int boNo) {
		ServiceResult result = null;
		int status = freeDao.freeDelete(boNo);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

	@Override
	public ServiceResult freeUpdate(Map<String, Object> map) {
		ServiceResult result = null;
		int status = freeDao.freeUpdate(map);
		if(status>0) {
			result = ServiceResult.OK;
		} else {
			result = ServiceResult.FAILED;
		}
		return result;
	}

}
