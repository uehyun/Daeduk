package kr.or.ddit.main.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

public interface IMainDAO {
	
	public List<BoardVO> selectBoardList();

	public List<FreeVO> selectFreeList();

	public List<NoticeVO> selectNoticeList();

	public int selectBoardCount();

	public int selectFreeCount();

	public int selectNoticeCount();

}
