package kr.or.ddit.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Board;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

	/*
		1. 요청 경로 매핑
		@ RequestMapping의 value속성에 요청 경로를 설정한다.
		
		- 요청 경로는 반드시 설정해야 하는 필수 정보이다.
		- 속성이 하나일 때는 속성명이 생략할 수 있다.
		- 컨트롤러의 클래스 레벨과 메서드 레벨로 지정할 수 있다.
		- 클래스 레벨로 요청 경로를 지정하면 메소드 레벨에서 지정한 경로의 기본 경로로 취급된다.
		- 클래스 레벨의 요청 경로에 메소드 레벨의 요청 경로를 덧붙인 형태가 최종 경로가 된다.
	*/
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@RequestMapping(value = "/register")
	public void registerForm() {
		logger.info("registerForm() 실행...!");
	}
	
	@RequestMapping(value = "/modify")
	public void modifyForm() {
		logger.info("modifyForm() 실행...!");
	}
	
	@RequestMapping(value = "/list")
	public void list() {
		logger.info("list() 실행...!");
	}
	
	/*
		2. 경로 패턴 매핑
		@RequestMapping(value="/board/read/{boardNo}")
		
		- 해당 경로로 요청 시, board폴더에 read.jsp를 찾아서 페이지를 출력해주는거 같지만,
		 경로상으로만 보면 board/read/boardNo라는 파일까지 찾게된다.
		 
		 - URL 경로상의 변하는 값을 경로 변수로 취급한다.
		 - 경로 변수에 해당하는 값을 파라미터 변수에 설정할 수 있다.
	 */
	
	@RequestMapping(value = "/read/{boardNo}")
	public String read(@PathVariable("boardNo") int boardNo) {
		logger.info("read() 실행...!");
		logger.info("read boardNo : " + boardNo);
		return "board/read";
	}
	
	/*
		3. HTTP 메소드 매핑
		method 속성을 사용하여 HTTP 메소드를 매핑 조건으로 지정할 수 있다.
		화면으로 응답하는 경우에는 HTTP 메소드로 GET방식과 POST방식 두 가지를 사용할 수 있다.
	*/
/*	
	// formHome 경로에 GET 방식
	@RequestMapping(value = "/formHome", method = RequestMethod.GET)
	public String formHome() {
		return "formHome";
	}
	
	// register 경로에 GET 방식
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm1() {
		logger.info("registerForm() 실행...!");
		return "success";
	}
	
	// register 경로에 POST 방식
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register() {
		logger.info("register() 실행...!");
		return "success";
	}
	
	// modify 경로에 GET 방식
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyForm1() {
		logger.info("modifyForm() 실행...!");
		return "success";
	}
	
	// modify 경로에 POST 방식
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify() {
		logger.info("modify() 실행...!");
		return "success";
	}
	
	// remove 경로에 POST 방식
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove() {
		logger.info("remove() 실행...!");
		return "success";
	}
	
	// list 경로에 GET 방식
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list1() {
		logger.info("list() 실행...!");
		return "success";
	}
*/	
	/*
		4. Params 매핑
		@RequestMapping(value="/board/get", method=RequestMethod.GET, params="register")
		- 요청 파라미터를 매핑 조건으로 지정하는 경우에는 params 속성을 사용한다.
		 버튼이나 링크에 따라 호출할 메서드를 바꿔야 할 때 사용한다.
		 
		 확인 페이지 : views/board/list,modify,register,read 등
	*/
	
	
	// /board/get 경로, GET방식, "register" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "register")
	public String registerFormParamsGet() {
		logger.info("registerFormParamsGet() 실행...!");
		return "board/register";
	}
	
	// /board/post 경로, POST방식, "register" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "register")
	public String registerParamsPost() {
		logger.info("registerParamsPost() 실행...!");
		return "board/list";
	}
	
	// /board/get 경로, GET방식, "modify" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/get",method = RequestMethod.GET, params = "modify")
	public String modiftFormParamsGet() {
		logger.info("modifyFormParamsGet() 실행...!");
		return "board/modify";
	}
	
	// /board/post 경로, POST방식, "modify" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "modify")
	public String modifyParamsPost() {
		logger.info("modifyParamsPost() 실행...!");
		return "board/list";
	}
	
	// /board/get 경로, GET방식, "remove" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "remove")
	public String removeFormParamsGet() {
		logger.info("removeFormParamsGet() 실행...!");
		return "board/remove";
	}
	
	// /board/post 경로, POST방식, "remove" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "remove")
	public String removeParamsPost() {
		logger.info("removeParamsPost() 실행...!");
		return "board/list";
	}
	
	// /board/list 경로, GET방식, "list" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "list")
	public String listParamsGet() {
		logger.info("listParamsGet() 실행...!");
		return "board/list";
	}
	
	// /board/read 경로, GET방식, "read" 요청 파라미터에 대한 처리
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "read")
	public String readParamsGet() {
		logger.info("readParamsGet() 실행...!");
		return "board/read";
	}
	
	/*
		5. Headers 매핑
		- 요청 헤더를 매핑 조건으로 지정하는 경우에는 headers 속성을 사용한다.
	*/
	
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		logger.info("ajaxHome() 실행...!");
		return "ajaxHome";
	}
	
	// Headers 매핑이지만, headers 설정을 하지 않고 요청
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT)
	public ResponseEntity<String> modifyPut(@PathVariable("boardNo") int boardNo, 
			@RequestBody Board board,
			Model model) {
		log.info("modifyPut() 실행...!");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		model.addAttribute("boardNo", boardNo);
		return entity;
	}
	
	// headers 속성에 설정되어 있는 header정보를 매핑으로 요청
	// headers 속성을 통해서 좀 더 정확한 요청을 보낼 수 있다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyByHeader(
			@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByHeader() 실행...!");
		log.info("boardNo : " + boardNo);
		log.info("title : " + board.getTitle());
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	/*
		6. Content Type 매핑
		- 요청의 ContentType 헤더 값을 매핑 조건으로 지정하는 경우에는 consumes속성을 사용한다.
	 */
	
	// 응답 상태코드와 값을 제네릭에 설정되어 있는 타입에 따라서 내 마음대로 내보낼 수 있다.
	// 응답 상태코드 : HttpStatus라는 객체 안에 있는 여러 상태 코드를 선택해서 내보낼 수 있다.
	// 결과값 : 제네릭 타입에 설정되어 있는 해당 타입의 값으로 결과의 값을 설정해서 내보낼 수 있다.
	
	// consumes 속성값을 지정하지 않고 테스트
	// consumes 속성값을 지정하지 않으면 기본값으로 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.POST)
	public ResponseEntity<String> ModifyContentType(
			@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyContentType() 실행...!");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// consumes 속성 값에 "application/json" 미디어 타입을 지정한다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> modifyByJson(
			@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyByJson() 실행...!");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.PUT, consumes = "application/xml")
	public ResponseEntity<String> modifyContentTypeByXml(
			@PathVariable("boardNo") int boardNo, @RequestBody Board board) {
		log.info("modifyContentTypeByXml() 실행...!");
		log.info("boardNo : " + boardNo);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	/*
		7. Accept 매핑 사용
		- produces 속성값을 지정해서 요청하는 미디어 타입을 설정한다.
	*/
	
	// produces 속성값을 지정하지 않고 테스트
	// produces 속성값을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정된다.
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> readAccept(@PathVariable("boardNo") int boardNo) {
		log.info("readAccept() 실행...!");
		
		Board board = new Board();
		board.setTitle("제목1");
		board.setContent("내용1");
		board.setWriter("작성자1");
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
	
	// produces를 사용하려면 headers의 "Accept"라는 키값으로 설정하여 해당 응답으로 이동
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo) {
		log.info("readToJson() 실행...!");
		
		String addStr = "_json";
		Board board = new Board();
		board.setTitle("제목1" + addStr);
		board.setContent("내용1" + addStr);
		board.setWriter("작성자1" + addStr);
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo) {
		log.info("readToJson() 실행...!");
		
		String addStr = "_xml";
		Board board = new Board();
		board.setTitle("제목1" + addStr);
		board.setContent("내용1" + addStr);
		board.setWriter("작성자1" + addStr);
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board, HttpStatus.OK);
		return entity;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "board/search";
	}
	
}


