package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control.ActionForward;
import mvcMem.model.StudentDAO;
import mvcMem.model.StudentVo;



public class ModifyProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respons) throws IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		StudentDAO dao = StudentDAO.getInstance();
		StudentVo vo = new StudentVo(loginID, request.getParameter("pass"), request.getParameter("name"),
				request.getParameter("phone1"), request.getParameter("phone2"), request.getParameter("phone3"),
				request.getParameter("email"), request.getParameter("zipcode"), request.getParameter("address1"),
				request.getParameter("address2"));
		dao.updateMember(vo);
		return new ActionForward("/mvcMem/modifyProc.jsp", false);
	}
}