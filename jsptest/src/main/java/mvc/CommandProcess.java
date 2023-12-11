package mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CommandProcess {
	 public String requestPro(HttpServletRequest request,
			 HttpServletResponse response) throws Throwable;
}
//다음으로 구현할 클래스를만든다.
