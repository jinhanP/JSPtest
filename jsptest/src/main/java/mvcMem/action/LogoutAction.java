package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control.ActionForward;



public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respons) throws IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		return new ActionForward("/mvcMem/logout.jsp", false);
	}
}
