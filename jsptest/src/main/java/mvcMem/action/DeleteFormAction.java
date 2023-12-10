package mvcMem.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.control.ActionForward;



public class DeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse respons) throws IOException {
		// TODO Auto-generated method stub
		return new ActionForward("/mvcMem/deleteForm.jsp", false);
	}
}
