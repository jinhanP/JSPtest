package mvc;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcMem.action2.Action;
import mvcMem.control2.ActionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 멤버변수로 맵을 가져온다.
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	// 우리가 사용되어질 모든 Action 객체가 
	public void init(ServletConfig config) throws ServletException {
		// web.xml에서 propertyConfig에 해당하는 init-param의 값을 읽어옴
		// web-inf에 있는
		String props = config.getInitParameter("propertyConfig");
		// 명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
		Properties pr = new Properties();
		String path = config.getServletContext().getRealPath("/WEB-INF");
		FileInputStream f = null;
		try {
			// Command.properties파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			// Command.properties파일의 정보를 Properties객체에 저장
			pr.load(f);
		} catch (IOException e) {
			throw new ServletException(e);
		} finally {
			if (f != null)
				try {
					f.close();
				} catch (IOException ex) {
				}
		}
		// Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
		Iterator<Object> keyIter = pr.keySet().iterator();
		// 객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String className = pr.getProperty(command);
			try {// 해당 문자열을 클래스로 만든다.
				Class commandClass = Class.forName(className);
				Object commandInstance = commandClass.newInstance();// 해당클래스의 객체를 생성
				// Map객체인 commandMap에 객체 저장
				commandMap.put(command, commandInstance);
			} catch (ClassNotFoundException e) {
				throw new ServletException(e);
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		requestPro(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		requestPro(request,response);
	}
	private void requestPro(HttpServletRequest request, HttpServletResponse response) {
		//요청한 내용을 알아낸다. http://localhost:8080/jsptest/mvcMem/member.di
		// /mvc/message.di=mvc.MessageProcess
		String view = null;
		String command = request.getRequestURI(); // /jsptest/mvcMem/member.di 만 가져온다.
		String path = request.getContextPath();// /jsptest 만 가져온다.
		if(command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(path.length());
			
		}
		//모든자식객체는 => 부모인터페이스로 받을수 있다.
//		public class MessageProcess implements CommandProcess{}
//		ActionFactory factory = ActionFactory.getInstance();
//		Action action = factory.getAction(cmd);
		CommandProcess com = (CommandProcess) commandMap.get(command);
		try {
			 view = com.requestPro(request, response);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
