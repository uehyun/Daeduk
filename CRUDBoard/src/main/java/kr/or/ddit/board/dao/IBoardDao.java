package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IBoardDao {

	public int insertBoard(BoardVO boardVO);

	public BoardVO selectBoard(int boNo);

	public void incrementHit(int boNo);

	public int updateBoard(BoardVO boardVO);

	public int deleteBoard(int boNo);

	public List<BoardVO> selectBoardList();

	public int selectBoardCount(PaginationInfoVO<BoardVO> pagingVO);

	public List<BoardVO> selectBoardList2(PaginationInfoVO<BoardVO> pagingVO);

}
