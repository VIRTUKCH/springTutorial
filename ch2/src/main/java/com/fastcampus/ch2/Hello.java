package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1.원격 호출가능한 프로그램으로 등록
@Controller
public class Hello
{
	int iv = 10;
	static int cv = 20;
	
	// static이 없어도 호출된다. 그 이유는 톰캣이 인스턴스를 생성해주기 때문.
	// 또한, 인스턴스 메서드는 iv, cv를 둘 다 사용 가능하다.
	// pubilc이 아니라 private라도 가능함.
	// RequestMapping이 곧 URL과 메서드를 연결시킨다는 말이기 때문.\
	// 2.URL과 메서드를 연결(맵핑, mapping이라 한다.)
	@RequestMapping("/hello") //URL을 /hello로 한 것. localhost:8080/ch2/hello
	private void main()
	{
		System.out.println("Hello - private");
		System.out.println(iv); // 인스턴스 메소드는 인스턴스 / 스태틱 변수 둘 다 커버 가능
		System.out.println(cv); // 인스턴스 메소드는 인스턴스 / 스태틱 변수 둘 다 커버 가능
	}
	
	public static void main2() //static 메서드 -> cv만 사용 가능함.
	{
//		System.out.println(iv); // static 메소드에서는 static 변수에만 접근할 수 있다. => 인스턴스가 생성되지 않았으면 어쩌려고?
		System.out.println(cv);
	}
}

