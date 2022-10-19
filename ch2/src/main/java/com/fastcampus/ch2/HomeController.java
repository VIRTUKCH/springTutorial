// 기본적으로 제공되는 소스임.
// 1. 원격 호출 가능함 프로그램으로 서버에 전달하고
// 2. URL과 메서드를 연결함.
// home을 만들어준다고 생각하면 좋을듯 함.

package com.fastcampus.ch2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 1. 원격 호출 가능한 프로그램으로 등록
public class HomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@GetMapping("/")
	public String home()
	{
		return "index";
	}
}