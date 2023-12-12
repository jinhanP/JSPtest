//package mvcMem.action2;
//
//import java.io.IOException;
//import java.util.Vector;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mvcMem.control2.ActionForward;
//import mvcMem.model2.ZipCodeVO;
//
//public class ZipCheckAction implements Action {
//
//	@Override
//	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		mvcMem.model2.StudentDAO dao = mvcMem.model2.StudentDAO.getInstance();
//		String check = request.getParameter("check");
//		String dong = request.getParameter("dong");
//		Vector<ZipCodeVO> zipcodeList = dao.zipcodeRead(dong);
//		int totalList = zipcodeList.size();
//		request.setAttribute("check", check);
//		request.setAttribute("dong", dong);
//		request.setAttribute("zipcodeList", zipcodeList);
//		request.setAttribute("totalList", totalList);
//		return new ActionForward("/mvcMem2/zipCheck.jsp", false);
//	}
//
//}
