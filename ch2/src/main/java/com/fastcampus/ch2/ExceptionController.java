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
	@ExceptionHandler({NullPointerException.class, FileNotFoundException.class}) // ������ �ش� ���� �߽߰� �ϰ�ó��.
	public String catcher2(Exception ex, Model m) // NullPointerException�� �߻��ϸ�
	{
		m.addAttribute("ex",ex);
		System.out.println("catcher() in ExceptionController catch NullPointer || FileNotFound Exception");
		return "error"; // error.jsp�� ��ȯ�ϵ���.
	}
	
	@ExceptionHandler(Exception.class) // ������ Exception �߻� �� �ϰ�ó��
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // Error Code�� 500���� �ٲٴ� ����.
	public String catcher(Exception ex, Model m) // Exception�� �߻��ϸ�
	{
		System.out.println("catcher() in ExceptionController catch Normal Exception");
		System.out.println("m="+m);
//		m.addAttribute("ex", ex); // �𵨿��ٰ� �������� ������, el�� �������� �ʴ´�.
		
		return "error"; // error.jsp�� ��ȯ�ϵ��� �����ϰڽ��ϴ�. try-catch���� �ʿ䰡 �������� ����.
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception // �� ģ���� �����ϴ� Model�� ExceptionHandler���� �����ϴ� Model���� �ٸ� ���̴�.
	{
		m.addAttribute("msg", "message from ExceptionController.main()");
		throw new Exception("���ܰ� �߻��߽��ϴ�."); // ���� ����� + �߻���Ű��
	}
	
	@RequestMapping("/ex2")
	public String main2() throws Exception
	{
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�."); // ���� ����� + �߻���Ű��
	}
}