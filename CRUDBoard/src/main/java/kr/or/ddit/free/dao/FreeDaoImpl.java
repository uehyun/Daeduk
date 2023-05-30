package kr.or.ddit.free.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class FreeDaoImpl implements IFreeDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		return sqlSession.selectOne("Free.selectFreeCount", pagingVO);
	}

	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		return sqlSession.selectList("Free.selectFreeList", pagingVO);
	}

	@Override
	public int insertFree(Map<String, Object> map) {
		return sqlSession.insert("Free.insertFree", map);
	}

	@Override
	public FreeVO selectFree(int boNo) {
		return sqlSession.selectOne("Free.selectFree", boNo);
	}

	@Override
	public void updateHit(int boNo) {
		sqlSession.update("Free.updateHit", boNo);
	}

	@Override
	public int freeDelete(int boNo) {
		return sqlSession.delete("Free.freeDelete", boNo);
	}

	@Override
	public int freeUpdate(Map<String, Object> map) {
		return sqlSession.update("Free.freeUpdate", map);
	}

}
