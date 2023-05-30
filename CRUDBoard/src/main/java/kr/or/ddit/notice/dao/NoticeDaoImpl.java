package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class NoticeDaoImpl implements INoticeDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;

	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		return sqlSession.selectOne("Notice.selectNoticeCount", pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		return sqlSession.selectList("Notice.selectNoticeList", pagingVO);
	}

	@Override
	public int insertNotice(Map<String, Object> map) {
		return sqlSession.insert("Notice.insertNotice", map);
	}

	@Override
	public NoticeVO selectNotice(int boNo) {
		return sqlSession.selectOne("Notice.selectNotice", boNo);
	}

	@Override
	public void updateHit(int boNo) {
		sqlSession.update("Notice.updateHit", boNo);
	}

	@Override
	public int noticeUpdate(Map<String, Object> map) {
		return sqlSession.update("Notice.noticeUpdate", map);
	}

	@Override
	public int noticeDelete(int boNo) {
		return sqlSession.delete("Notice.noticeDelete", boNo);
	}

}
