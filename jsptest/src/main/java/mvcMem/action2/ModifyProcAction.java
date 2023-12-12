package mvcMem.action2;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control2.ActionForward;
import mvcMem.model2.StudentDAO;

public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		StudentDAO dao = StudentDAO.getInstance();
		mvcMem.model2.StudentVO vo = new mvcMem.model2.StudentVO(loginID, request.getParameter("pass"), request.getParameter("name"),
				request.getParameter("phone1"), request.getParameter("phone2"), request.getParameter("phone3"),
				request.getParameter("email"));
		dao.updateMember(vo);
		return new ActionForward("/mvcMem2/modifyProc.jsp", false);
	}
}
