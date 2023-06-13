package kr.or.ddit.Controller.exception;

public class ExceptionController {

	/*
		16장 예외처리
		
		1. 예외처리
		
			일반적으로 프로그램이 처리되는 동안 특정한 문제가 일어났을 때, 처리를 중단하고 다른 처리 하는 것을 예외처리라고 한다.
			웹 컨테이너는 기본적으로 예외처리를 하여 기본 에러 페이지를 표시
			하지만, 페이지에 애플리케이션 서버의 내부 정보가 일반 사용자들에게 노출되어 프레임워크의 보안 취약점을 노린 공격을 받을 수 있다.
			이런 점을 고려하여 최대한 사용자가 직접 예외를 처리하여 사용자가 정의한 에러 페이지를 표시하게 해야 함.
			
			1-1) 예외 종류
			- 스프링 프레임워크 예외
			- 사용자 정의 예외
			- 의존 라이브러리에서 발생한 예외
			- 시스템 예외
			
			1-2) 이번 장에서 가상한 예외 상황
			- A. 등록할 때 제목에 빈 값을 입력하여 유효성 검증 예외 발생
			- B. 수정 화면 생성하고 뷰 파일에서 수정 진행할 때 예외 발생
			- C. 삭제할 때, 매핑 파일에서 예외 발생
			- D. 존재하지 않는 게시물을 조회할 때, 사용자가 정의한 예외 발생
			- E. 존재하지 않는 페이지  URL 요청 시 예외 발생
			
			1-3) 예외처리 불가 기준
			- 사용자가 정의한 예외 처리기를 거치지 않는 예외로 프레임워크에서 이러한 예외를 처리한 기본적인 내용은 아래와 같다.
				> Http Status 400 - Bad Request
			
		2. 예외 상황
		
			2-1) 예외 발생 상황
			
				- 등록할 때 제목에 빈 값을 입력하여 유효성 검증 예외 발생
					> Http Status 400
					> [예외 상황 만들 위치]
						- kr.or.ddit.controller.board.CrudBoardController crudRegister() post
						- vo.Board title 필드에 @NotBlank 설정
						
				- 수정 화면 생성하고 수정 진행할 때 예외 발생
					> Http Status 500
					> [예외 상황 만들 위치]
						- views/crud/register.jsp input type="text" id가 title인 Element의 id와 name을 title2로 수정
				
				- 삭제할 때 매핑 파일에서 예외 발생
					> Http Status 500
					> [예외 상황 만들 위치]
						- sqlmap/boardMapper_SQL.xml id가 delete인 삭제 기능을 가진 태그에서 board_no를 board_no2로 수정
						
				- 존재하지 않는 게시물을 조회할 때 사용자가 정의한 예외 발생
					> Http Status 500
					> [예외 상황 만들 위치]
						- kr.or.ddit.service.impl.BoardServiceImpl read() 수정
						
				- 존재하지 않는 페이지 URL 요청 시 예외 발생
					> Http Status 404
					> [요청 URL]
						/crud/board/retry
						 
		3. 상태 코드 사용한 에러 페이지 설정
		- 웹 컨테이너 설정 파일 (web.xml)의 <error-code> 요소에 상태 코드를 설정하고 <location> 요소에 이동 대상 페이지를 지정한다.
		
			예외 처리 방법
			- 웹 컨테이너 설정 (web.xml)
				> <error-page></error-page> 400 코드 설정
				> <error-page></error-page> 404 코드 설정
				> <error-page></error-page> 500 코드 설정
				
			- 처리할 수 있는 예외
			
			- 처리할 수 없는 예외
	*/
	
	
}
