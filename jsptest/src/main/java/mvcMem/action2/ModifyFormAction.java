package mvcMem.action2;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcMem.control2.ActionForward;
import mvcMem.model2.StudentDAO;
import mvcMem.model2.StudentVO;

public class ModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
			StudentDAO dao = StudentDAO.getInstance();
			HttpSession session = request.getSession();
			String loginID = (String)session.getAttribute("loginID");
			StudentVO vo = dao.getMember(loginID);
			request.setAttribute("id", vo.getId());
			request.setAttribute("pass", vo.getPass());
			request.setAttribute("name", vo.getName());
			request.setAttribute("phone1", vo.getPhone1());
			request.setAttribute("phone2", vo.getPhone2());
			request.setAttribute("phone3", vo.getPhone3());
			request.setAttribute("email", vo.getEmail());
			return new ActionForward("/mvcMem2/modifyForm.jsp",false);
			}
		}
