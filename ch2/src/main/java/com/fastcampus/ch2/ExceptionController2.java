// 1. Exception�� �߻��ϸ�, �� �ȿ� try - catch���� �ִ��� Ȯ���� �Ѵ�.
// 2. try - catch���� ������, ���� �ִ� Controller �ȿ� ExceptionHandler�� �ִ��� Ȯ���Ѵ�.(���� ���� ó��)
// 3. ���� Controller�ȿ� ExceptionHandler�� ������, ControllerAdvice�� Mapping�� ExceptionHandler�� �ִ��� Ȯ���Ѵ�.(���� ���� ó��)
// 4. ���� ���� ó�� �޼��尡 �ߺ��� ���(Controller�� & ���� ���� ó��), ��Ʈ�ѷ� ���� ���� ó�� �޼��尡 �켱�̴�.
// 5. �׷����� �ұ��ϰ� ó���� �� �ִ°� ������, �׳� Error�� ��������.
// 6. Error�� �������ٰ� �ϴ���, ������ ������ ���� ��� â�� �������� ������ �� �ִ�.
// 7. ù ��° ����� web.xml�� �̿��� ����̸�, ���� �ڵ��� ���߾ WEB-INF�� �ִ� .jsp ������ mapping�Ѵ�.(views ������ �ִ� .jsp ������ �ƴϴ�.)
// 8. �� ��° ����� servlet=context.xml�� �̿��� ����̸�, ������ ������ ���� views ������ �ִ� view�� mapping���ش�.
// 9. ���� �� ���� �浹�Ѵٸ�
package com.fastcampus.ch2;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 400�� ������ �����ش�. ����� ���ܴ� ����Ʈ�� 500 // �̰Ÿ� �ּ�ó�� �ϸ� servlet-context.xml�� ���ư�
class MyException extends RuntimeException
{
	MyException(String msg)
	{
		super(msg); // RuntimeException�� �������� �Ű������� msg�� �־...
	}
	MyException() { this(""); } // �޼����� ���� ����
}

@Controller
public class ExceptionController2
{	
	@RequestMapping("/ex3")
	public String main() throws Exception
	{
		throw new MyException("���ܰ� �߻��߽��ϴ�."); // ���� ����� + �߻���Ű��
	}
	
	@RequestMapping("/ex4")
	public String main2() throws Exception
	{
		throw new FileNotFoundException("���ܰ� �߻��߽��ϴ�."); // ���� ����� + �߻���Ű��
	}
}