// �⺻������ �����Ǵ� �ҽ���.
// 1. ���� ȣ�� ������ ���α׷����� ������ �����ϰ�
// 2. URL�� �޼��带 ������.
// home�� ������شٰ� �����ϸ� ������ ��.

package com.fastcampus.ch2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // 1. ���� ȣ�� ������ ���α׷����� ���
public class HomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
//	@GetMapping("/")
	public String home()
	{
		return "index";
	}
}