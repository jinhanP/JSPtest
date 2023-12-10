package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control.ActionForward;



public class RegFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respons) throws IOException {
		return new ActionForward("/mvcMem/regForm.jsp", false);
	}

}
