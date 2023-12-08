package mvc.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.control.ActionForward;

public interface Action {
	//액션
//인터페이스 서로 다른 두 개의 시스템, 장치 사이에서 정보나 신호를 주고받는 경우의 접점이나 경계면
	
	//추상메소드
	public abstract ActionForward execute(HttpServletRequest request, HttpServletResponse respons) throws IOException;
	
}
