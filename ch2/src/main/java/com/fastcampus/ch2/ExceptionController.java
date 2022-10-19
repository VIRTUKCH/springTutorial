package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController
{
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) // 앞으로 해당 예외 발견시 일괄처리.
	public String catcher2(Exception ex, Model m) // NullPointerException이 발생하면
	{
		m.addAttribute("ex",ex);
		System.out.println("catcher() in ExceptionController catch NullPointer || FileNotFound Exception");
		return "error"; // error.jsp를 반환하도록.
	}
	
	@ExceptionHandler(Exception.class) // 앞으로 Exception 발생 시 일괄처리
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Error Code를 500으로 바꾸는 역할.
	public String catcher(Exception ex, Model m) // Exception이 발생하면
	{
		System.out.println("catcher() in ExceptionController catch Normal Exception");
		System.out.println("m="+m);
//		m.addAttribute("ex", ex); // 모델에다가 저장하지 않으면, el로 연동되지 않는다.
		
		return "error"; // error.jsp를 반환하도록 설정하겠습니다. try-catch문이 필요가 없어져서 좋아.
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception // 이 친구가 저장하는 Model은 ExceptionHandler에서 저장하는 Model과는 다른 것이다.
	{
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("예외가 발생했습니다."); // 예외 만들기 + 발생시키기
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception
	{
		throw new FileNotFoundException("예외가 발생했습니다."); // 예외 만들기 + 발생시키기
	}
}