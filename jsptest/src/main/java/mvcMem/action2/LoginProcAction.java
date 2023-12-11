package mvcMem.action2;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control2.ActionForward;


public class LoginProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		mvcMem.model2.StudentDAO dao = mvcMem.model2.StudentDAO.getInstance();
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		int check = dao.loginCheck(id, pass);
		if (check == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("loginID", id);
		} else if (id != null && pass != null) {
			request.setAttribute("check", check);
		}
		return new ActionForward("member.mdo?cmd=login", false);
	}

}
