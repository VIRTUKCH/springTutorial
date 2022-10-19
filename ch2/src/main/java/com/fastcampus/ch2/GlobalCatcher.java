package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.fastcampus.ch3") // �Ʒ� �޼������ ��� Controller���� �������� ����ǰ� �����.
// ���� ��Ű���� ������ �� �ִµ�, �׷��� �ϸ� �ش� ��Ű���� ���ϴ� Controller���Ը� ������ �ȴ�. Default�� ��� ��Ű�� ����.
public class GlobalCatcher
{
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) // ������ �ش� ���� �߽߰� �ϰ�ó��.
	public String catcher2(Exception ex, Model m) // NullPointerException�� �߻��ϸ�
	{
		m.addAttribute("ex",ex);
		return "error"; // error.jsp�� ��ȯ�ϵ���.
	}
	
	@ExceptionHandler(Exception.class) // ������ Exception �߻� �� �ϰ�ó��
	public String catcher(Exception ex, Model m) // Exception�� �߻��ϸ�
	{
		m.addAttribute("ex", ex); // �𵨿��ٰ� �������� ������, el�� �������� �ʴ´�.
		return "error"; // error.jsp�� ��ȯ�ϵ��� �����ϰڽ��ϴ�. try-catch���� �ʿ䰡 �������� ����.
	}
}