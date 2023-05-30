package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeDAO {

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public int insertNotice(Map<String, Object> map);

	public NoticeVO selectNotice(int boNo);

	public void updateHit(int boNo);

	public int noticeUpdate(Map<String, Object> map);

	public int noticeDelete(int boNo);

}
