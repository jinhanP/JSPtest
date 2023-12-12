package board.controller;

import java.io.*;
import java.util.*;
import board.action.CommandAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ControllerAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<String, Object>();

	// 명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서
	// Map 객체인 commandMap에 저장
	// 명령어와 처리클래스가 매핑되어 있는 properties 파일은
	// Command.properties파일
	// @SuppressWarnings("uncheckes")미확인오퍼레이션과 관련된경고를억제
	@SuppressWarnings("unchecked")
	public void init(ServletConfig config) throws ServletException{
		//web.xml에서 propertyConfig에 해당하는 init-param 의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		//명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		String path = config.getServletContext().getRealPath("/WEB-INF");
		try {
			//Command.properties파일의 내용을 읽어옴
			f = new FileInputStream(new File(path, props));
			//Command.properties파일의 정보를 Properties객체에 저장
			pr.load(f);
		}catch(IOException e) {
			throw new ServletException(e);
		}finally {
			if(f != null) try {f.close();} catch(IOException ex) {}
		}
		//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
		Iterator<Object> keyIter = pr.keySet().iterator();
		//객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
		while(keyIter.hasNext()) {
			String command = (String)keyIter.next();
			String className = pr.getProperty(command);
			try { //해당 문자열을 클래스로 만든다.
				Class commandClass = Class.forName(className);
				//해당클래스의 객체를 생성
				 Object commandInstance = commandClass.newInstance();
				 //Map객체인 commandMap에 객체 저장
				 commandMap.put(command, commandInstance);
			}catch(ClassNotFoundException e) {
				throw new ServletException(e);
			}catch(InstantiationException e) {
				throw new ServletException(e);
			}catch(IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public ControllerAction() {
		super();
	}
	
	//get방식의 서비스 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		requestPro(request, response);
	}

	//post방식의 서비스 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		requestPro(request, response);
	}
	
	//사용자의 요청을 분석해서 해당 작업을 처리
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com=null;
		try {
			String command = request.getRequestURI();
			if(command.indexOf(request.getContextPath()) == 0) {
				command = command.substring(request.getContextPath().length());
			}
			com = (CommandAction)commandMap.get(command);
			view = com.requestPro(request, response);
		}catch(Throwable e) {
			throw new ServletException(e);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
