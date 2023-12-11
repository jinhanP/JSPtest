package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control.ActionForward;
	// Super 인터페이스
public interface Action {
	//execute()메소드는 ActionForward 객체를 반환한다.
	public ActionForward execute
	//요청 과 응답
	 (HttpServletRequest request,HttpServletResponse response)
	 	throws IOException;
}
