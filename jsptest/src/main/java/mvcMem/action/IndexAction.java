package mvcMem.action;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control.ActionForward;

public class IndexAction implements Action {
	// Index 액션과 index 페이지
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		return new ActionForward("/mvcMem/index.jsp", false);
	}
}
