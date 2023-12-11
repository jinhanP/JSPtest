package mvcMem.action2;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
	public mvcMem.control2.ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
