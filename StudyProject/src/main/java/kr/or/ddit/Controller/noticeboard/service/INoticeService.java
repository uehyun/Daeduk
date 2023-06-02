package kr.or.ddit.Controller.noticeboard.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;

public interface INoticeService {

	public ServiceResult insertNotice(NoticeVO noticeVO);

	public NoticeVO selectNotice(int boNo);

	public ServiceResult updateNotice(NoticeVO noticeVO);

}
