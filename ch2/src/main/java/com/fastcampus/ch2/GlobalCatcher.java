package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") // 아래 메서드들이 모든 Controller에게 공통으로 적용되게 만든다.
// 옆에 패키지도 적어줄 수 있는데, 그렇게 하면 해당 패키지에 속하는 Controller에게만 적용이 된다. Default는 모든 패키지 적용.
public class GlobalCatcher
{
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) // 앞으로 해당 예외 발견시 일괄처리.
	public String catcher2(Exception ex, Model m) // NullPointerException이 발생하면
	{
		m.addAttribute("ex",ex);
		return "error"; // error.jsp를 반환하도록.
	}
	
	@ExceptionHandler(Exception.class) // 앞으로 Exception 발생 시 일괄처리
	public String catcher(Exception ex, Model m) // Exception이 발생하면
	{
		m.addAttribute("ex", ex); // 모델에다가 저장하지 않으면, el로 연동되지 않는다.
		return "error"; // error.jsp를 반환하도록 설정하겠습니다. try-catch문이 필요가 없어져서 좋아.
	}
}