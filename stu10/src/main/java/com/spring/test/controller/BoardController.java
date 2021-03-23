package com.spring.test.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.WebDataBinder;

import com.spring.test.TestValidator;
import com.spring.test.domain.WriteDTO;
import com.spring.test.service.BoardService;

// 컨테이너 Bean 자동처리 ㄱㄱ
@Controller
@RequestMapping("/board")
public class BoardController {
	
	private BoardService boardService;
	
	@Autowired
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}	
	// server 가동 중에 bean 객체로 나오는지 확인하기 위한 코드
	public BoardController() {
		System.out.println("BoardController() 생성");
	}		

	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("list", boardService.list());
		return "board/list";
	}	

	@RequestMapping("/write.do")
	public String write(Model model) {
		return "board/write";
	} 		

	@RequestMapping("/writeOk.do")
	public String writeOk(@ModelAttribute("w") @Valid WriteDTO dto
			, BindingResult bindingresult
			, Model model) {
		
		System.out.println("입력된 값: \n음식 이름: "+dto.getName()+"\n음식 종류: "+ dto.getCon()+"\n음식 가격: "+dto.getPrice()+"\n");		
		System.out.println("validate 적용 후");
		showErrors(bindingresult);					
		
		String page;
		if (bindingresult.hasErrors()) { // 에러가 있으면 write화면으로 돌아가기			
			page = "board/write";
		} else {
			page = "board/writeOk";
			model.addAttribute("result", boardService.write(dto));
		}
		return page; // 에러 없으면 writeOk로 가!		
	}			
	@GetMapping("/view.do")
	public String view(int uid, Model model) {
		model.addAttribute("list", boardService.viewByUid(uid));
		return "board/view";
	}	
	@RequestMapping("/update.do") 
	public String update(int uid, Model model){
		model.addAttribute("list", boardService.selectByUid(uid));
		return "board/update";
	}	
	@RequestMapping("/updateOk.do")
	public String updateOk(@Valid WriteDTO dto
			, BindingResult bindingresult
			, Model model) {

		System.out.println("입력된 값: \n음식 이름: "+dto.getName()+"\n음식 종류: "+ dto.getCon()+"\n음식 가격: "+dto.getPrice()+"\n");
		System.out.println("validate 적용 후");
		showErrors(bindingresult);
		
		String page;
		if (bindingresult.hasErrors()) {
			page = "board/update";
		} else {
			page = "board/updateOk";
			model.addAttribute("result", boardService.update(dto));
		}
		return page;		
	}	
	@RequestMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model) {
		model.addAttribute("result", boardService.deleteByUid(uid));
		return "board/deleteOk";
	}
	
	
	// 에러 출력 도우미 메소드
	private void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("validate 후 에러 개수: "+ errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			errors.getFieldErrors();
			List<FieldError> errList = errors.getFieldErrors();
			
			for(FieldError err : errList) {
				System.out.println("\t"+err.getField() + "\t|" + err.getCode());
			}			
		} else {
			System.out.println("에러가 업슝 '3')/\n");
		}		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new TestValidator());
	}
	
	
}





