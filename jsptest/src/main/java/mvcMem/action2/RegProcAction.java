package mvcMem.action2;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control2.ActionForward;
import mvcMem.model2.StudentDAO;
import mvcMem.model2.StudentVO;

public class RegProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		StudentDAO dao = StudentDAO.getInstance();
		StudentVO vo = new StudentVO(request.getParameter("id"), request.getParameter("pass"),
				request.getParameter("name"), request.getParameter("phone1"), request.getParameter("phone2"),
				request.getParameter("phone3"), request.getParameter("email"));
		boolean flag = dao.memberInsert(vo);
		
		request.setAttribute("flag", flag);
		return new ActionForward("/mvcMem2/regProc.jsp", false);
	}

}
