package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1.���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello
{
	int iv = 10;
	static int cv = 20;
	
	// static�� ��� ȣ��ȴ�. �� ������ ��Ĺ�� �ν��Ͻ��� �������ֱ� ����.
	// ����, �ν��Ͻ� �޼���� iv, cv�� �� �� ��� �����ϴ�.
	// pubilc�� �ƴ϶� private�� ������.
	// RequestMapping�� �� URL�� �޼��带 �����Ų�ٴ� ���̱� ����.\
	// 2.URL�� �޼��带 ����(����, mapping�̶� �Ѵ�.)
	@RequestMapping("/hello") //URL�� /hello�� �� ��. localhost:8080/ch2/hello
	private void main()
	{
		System.out.println("Hello - private");
		System.out.println(iv); // �ν��Ͻ� �޼ҵ�� �ν��Ͻ� / ����ƽ ���� �� �� Ŀ�� ����
		System.out.println(cv); // �ν��Ͻ� �޼ҵ�� �ν��Ͻ� / ����ƽ ���� �� �� Ŀ�� ����
	}
	
	public static void main2() //static �޼��� -> cv�� ��� ������.
	{
//		System.out.println(iv); // static �޼ҵ忡���� static �������� ������ �� �ִ�. => �ν��Ͻ��� �������� �ʾ����� ��¼����?
		System.out.println(cv);
	}
}

