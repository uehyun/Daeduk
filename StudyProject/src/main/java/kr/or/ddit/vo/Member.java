package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	@NotBlank(message = "안녕하세요~")
	@NotEmpty
	private String userId = "a001";
	@NotBlank
	@Size(max = 3)
	private String userName = "hongkd";
	@NotBlank
	private String password = "1234";
	private int coin = 100;
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	@Email
	private String email;
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private boolean foreigner;
	private String developer;
	private String nationality;
	// 중첩된 자바빈즈의 입력값 검증을 지정한다.
	@Valid
	private Address address;
	// 중첩된 자바빈즈의 입력값 검증을 지정한다.
	@Valid
	private List<Card> cardList;
	private String cars;
	private String[] carrArray;
	private List<String> carList;
	
	private String introduction;
	private String birthDay;
	
}
