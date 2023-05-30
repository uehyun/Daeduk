package kr.or.ddit;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

/*
	@RestController는 @Controller와 @ResponseBody를 포함하고 있다.
*/

@RestController
@Slf4j
public class RestHomeController {

	// 반환값이 객체 타입이면 JSON 타입으로 자동 변환된다.
	@RequestMapping(value = "/goRestHome0301", method = RequestMethod.GET)
	public Member restHome0301() {
		log.info("restHome0301() 실행...!");
		return new Member();
	}
	
	// 반환값이 컬렉션 List 타입이면 JSON 객체 배열 타입으로 자동 변환된다.
	@RequestMapping(value = "/goRestHome0401", method = RequestMethod.GET)
	public List<Member> restHome0401() {
		log.info("restHome0401() 실행...!");
		List<Member> list = new ArrayList<Member>();
		
		Member member = new Member();
		Member member2 = new Member();
		list.add(member);
		list.add(member2);
		return list;
	}
	
	// 반환값이 컬렉션 Map 타입이면 JSON 객체 타입으로 자동 변환된다.
	@RequestMapping(value = "/goRestHome0501", method = RequestMethod.GET)
	public Map<String, Member> restHome0501() {
		log.info("restHome0501() 실행...!");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		Member member2 = new Member();
		map.put("key1", member);
		map.put("key2", member2);
		return map;
	}
	
	// 200 OK 상태코드를 전송한다.
	// Void 타입은 아무런 형태가 아닌데 제네릭타입의 뭔가는 채워야겠어서 채우는 placeholder같은 느낌
	@RequestMapping(value = "/goRestHome0601", method = RequestMethod.GET)
	public ResponseEntity<Void> restHome0601() {
		log.info("restHome0601() 실행...!");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// "SUCCESS" 메세지와 200 OK 상태코드를 전송한다.
	@RequestMapping(value = "/goRestHome0701", method = RequestMethod.GET)
	public ResponseEntity<String> restHome0701() {
		log.info("restHome0701() 실행...!");
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	// 객체의 JSON 타입의 데이터와 200 OK 상태코드를 전송한다.
	@RequestMapping(value = "goRestHome0801", method = RequestMethod.GET)
	public ResponseEntity<Member> restHome0801() {
		log.info("restHome0801() 실행...!");
		Member member = new Member();
		return new ResponseEntity<Member>(member, HttpStatus.OK);
	}
	
	// 객체의 JSON 객체 배열 타입의 데이터와 200 OK 상태코드를 전송한다.
	@RequestMapping(value = "/goRestHome0901", method = RequestMethod.GET)
	public ResponseEntity<List<Member>> restHome0901() {
		log.info("restHome0901() 실행...!");
		List<Member> list = new ArrayList<Member>();
		Member member = new Member();
		Member member2 = new Member();
		list.add(member);
		list.add(member2);
		return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	}
	
	// 객체의 JSON 객체 타입의 데이터와 200 OK 상태코드를 전송한다.
	@RequestMapping(value = "/goRestHome1001", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Member>> restHome1001() {
		log.info("restHome1001() 실행...!");
		Map<String, Member> map = new HashMap<String, Member>();
		Member member = new Member();
		Member member2 = new Member();
		map.put("key1", member);
		map.put("key2", member2);
		return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/goRestHome1101", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restHome1101() {
		log.info("restHome1101() 실행...!");
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try(InputStream in = new FileInputStream("D:/image/chopa.jpg")) {
			headers.setContentType(MediaType.IMAGE_JPEG);
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/goRestHome1102", method = RequestMethod.GET)
	public ResponseEntity<byte[]> restHome1102() {
		log.info("restHome1102() 실행...!");
		String fileName = "data.zip";
		ResponseEntity<byte[]> entity = null;
		
		HttpHeaders headers = new HttpHeaders();
		try(InputStream in = new FileInputStream("D:/image/" + fileName)) {
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" +
					new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
