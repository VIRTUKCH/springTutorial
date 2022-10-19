// 1. Exception이 발생하면, 그 안에 try - catch문이 있는지 확인을 한다.
// 2. try - catch문이 없으면, 같이 있는 Controller 안에 ExceptionHandler가 있는지 확인한다.(지역 예외 처리)
// 3. 같은 Controller안에 ExceptionHandler가 없으면, ControllerAdvice에 Mapping된 ExceptionHandler가 있는지 확인한다.(전역 예외 처리)
// 4. 만약 예뢰 처리 메서드가 중복된 경우(Controller내 & 전역 예외 처리), 컨트롤러 내의 예외 처리 메서드가 우선이다.
// 5. 그럼에도 불구하고 처리할 수 있는게 없으면, 그냥 Error을 내보낸다.
// 6. Error을 내보낸다고 하더라도, 에러의 종류에 따라 어떠한 창을 보여줄지 선택할 수 있다.
// 7. 첫 번째 방법은 web.xml을 이용한 방법이며, 에러 코드의 맞추어서 WEB-INF에 있는 .jsp 파일을 mapping한다.(views 폴더에 있는 .jsp 파일이 아니다.)
// 8. 두 번째 방법은 servlet=context.xml을 이용한 방법이며, 예외의 종류에 따라서 views 폴더에 있는 view를 mapping해준다.
// 9. 만약 그 둘이 충돌한다면
package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 400번 에러를 보여준다. 사용자 예외는 디폴트가 500 // 이거를 주석처리 하면 servlet-context.xml이 돌아가
class MyException extends RuntimeException
{
	MyException(String msg)
	{
		super(msg); // RuntimeException의 생성자의 매개변수에 msg를 넣어서...
	}
	MyException() { this(""); } // 메세지가 없는 형태
}

@Controller
public class ExceptionController2
{	
	@RequestMapping("/ex3")
	public String main() throws Exception
	{
		throw new MyException("예외가 발생했습니다."); // 예외 만들기 + 발생시키기
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception
	{
		throw new FileNotFoundException("예외가 발생했습니다."); // 예외 만들기 + 발생시키기
	}
}