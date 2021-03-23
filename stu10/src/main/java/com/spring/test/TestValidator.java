package com.spring.test;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.test.domain.WriteDTO;

import lombok.var;

public class TestValidator implements Validator {

	// 이 board validator가 제공된 Class의 인스턴스(clazz)를 유효성 검사를 할 수 있는가?	
	@Override
	public boolean supports(Class<?> clazz) { 	
		// class는 키워드라서 변수로 사용 불가능함. 그래서clazz로 한거니까 그냥 참고만 하세염 ㅇㅇ
		System.out.println("supports(" + clazz.getName() + ")");
		return WriteDTO.class.isAssignableFrom(clazz);
	}

	// 주어진 객체(target)에 대해서 유효성 검사를 하고
	// 이 유효성 검사에 오류가 있는 경우, 
	// 주어진 객체에 이 오류들을 errors에 등록합니다. 
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		WriteDTO dto = (WriteDTO)target;
		
		String name = dto.getName();
		if (name == null || name.trim().isEmpty()) {
			System.out.println("음식 이름 error : 이름은 반드시 한 글자라도 입력해야해유");
			errors.rejectValue("name", "emptyName"); 
		} else if (name.trim().length() >= 20) {
			System.out.println("음식 이름 error : 20글자이하로 입력 해주세요.");
			errors.rejectValue("name", "invalidName");
		} else {
			System.out.println("음식 이름 okay");
		}
		
		// 단순히 비었을 때 체크하는거
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "con", "emptyCon");
		//그렇다면 '한식','중식','일식'이 아닐 때 에러는 어떻게 잡나? 
		String con = dto.getCon();
		if (("한식".equals(con.trim())) || ("일식".equals(con.trim())) || ("중식".equals(con.trim()))) {
			System.out.println("음식 타입 okay");
		} else if (con == null || con.trim().isEmpty()) {
			System.out.println("음식 타입 error : 음식 타입 비었슈");
			errors.rejectValue("con", "emptyCon"); 
		} else {
			System.out.println("음식 타입 error : 음식 타입은 '한식','중식','일식' 중 택1 하슈");
			errors.rejectValue("con", "invalidCon"); 
		}
			
		Integer price = dto.getPrice();
		if(price != null && price >= 0) {
			System.out.println("음식 가격 okay");
		} else {
			System.out.println("가격은 0원 이상으로 설정해야 합니다.");
			errors.rejectValue("price", "invalidPrice"); 
		}
//		if (price < 0 || isNaN(price)) {
//			System.out.println("가격은 0원 이상으로 설정해야 합니다.");
//			errors.rejectValue("price", "invalidPrice"); 
//		} else {
//			System.out.println("음식 가격 okay");
//		}
	}

	private boolean isNaN(Object price1) {
		return false;
	}
}




