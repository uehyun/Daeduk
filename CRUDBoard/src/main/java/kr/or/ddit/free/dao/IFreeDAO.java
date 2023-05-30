package kr.or.ddit.free.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeDAO {

	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);

	public int insertFree(Map<String, Object> map);

	public FreeVO selectFree(int boNo);

	public void updateHit(int boNo);

	public int freeDelete(int boNo);

	public int freeUpdate(Map<String, Object> map);

}
