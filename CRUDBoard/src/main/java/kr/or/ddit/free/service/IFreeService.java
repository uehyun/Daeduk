package kr.or.ddit.free.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeService {

	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	public ServiceResult insertFree(Map<String, Object> map);

	public FreeVO selectFree(int boNo);

	public void updateHit(int boNo);

	public ServiceResult freeDelete(int boNo);

	public ServiceResult freeUpdate(Map<String, Object> map);

}
