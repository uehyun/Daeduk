package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeService {

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);

	public ServiceResult insertNotice(Map<String, Object> map);

	public NoticeVO selectNotice(int boNo);

	public void updateHit(int boNo);

	public ServiceResult noticeUpdate(Map<String, Object> map);

	public ServiceResult noticeDelete(int boNo);

}
