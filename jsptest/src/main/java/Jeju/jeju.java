package Jeju;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class jeju extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void processRequest(HttpServletRequest request,
			 HttpServletResponse response)
			 throws ServletException, IOException {
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out = response.getWriter();
			 try {
			 HttpSession session = request.getSession(false);
  
			 if(session != null){
				 String sessionId = session.getId();
				 System.out.println("세션 아이디 : " + sessionId);
				 String user = (String)session.getAttribute("user");
				 out.println("<html>");
				 out.println("<body>");
				 out.println("<div id=\"container\">");
				 out.println("<table border='1' width='300'>");
				 out.println("<tr>");
				 out.println("<td width='300' align='center'>" + user + " 님 로그인 되었습니다.</td>");
				 out.println("</tr>");
				 out.println("<tr>");
				 out.println("<td align='center'>");
				 out.println("<a href='#'>회원정보</a>");
				 out.println("<a href='Logout'>로그아웃</a>");
				 out.println("</td>");
				 out.println("</tr>");
				 out.println("</table>");
				 out.println("</body>");
				 out.println("</html>");
				 }else{
//				 out.println("<link rel='stylesheet' href='jeju.css?ver=1'>");
//				 out.println("<link rel='stylesheet' type='text/css'href='${pageContext.request.contextPath}/css/jeju.css?ver=1'>");
				 out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css'rel='stylesheet'/>");
				 out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js'></script>");
				 out.println("<html>");
				 out.println("<body>");
				 out.println("<div id=\"container\">");
				 out.println("<header>");
				 out.println("<div id=\"logo\">");
				 out.println("<a href=\"index.html\">");
				 out.println("<h1>Dream Jeju</h1>");
				 out.println("</a>");
				 out.println("</div>");
				 out.println("<nav>");
				 out.println("<ul id=\"topMenu\">");
				 out.println("<li><a href=\"#\">단체 여행 <span>▼</span></a>");
				 out.println("<ul>");
				 out.println("<li><a href=\"#\">회사 연수</a></li>");
				 out.println("<li><a href=\"#\">수학 여행</a></li>");
				 out.println("</ul>");
				 out.println("</li>");
				 out.println("<li><a href=\"#\">맞춤 여행 <span>▼</span></a>");
				 out.println("<ul>");
				 out.println("<li><a href=\"#\">4.3 평화 기행</a></li>");
				 out.println("<li><a href=\"#\">곶자왈 체험</a></li>");
				 out.println("<li><a href=\"#\">힐링 워크샵</a></li>");
				 out.println(" </ul>");
				 out.println("</li>");
				 out.println("<li><a href=\"#\">갤러리</a></li>");
				 out.println("<li><a href=\"#\">문의하기</a></li>");
				 out.println("</ul>");
				 out.println("</nav>");
				 out.println("</header>");
				 out.println("<div id=\"slideShow\">");
				 out.println("<div id=\"slides\">");
				 out.println("<img src=\"../09.image/image/01.jpg\" alt=\"\"> \r\n"
				 		+ "<img src=\"../09.image/image/03.jpg\" alt=\"\"> \r\n"
				 		+ "<img src=\"../09.image/image/04.jpg\" alt=\"\">");
				 out.println("<button id=\"prev\" onclick=\"prevSlide()\">&lang;</button>");
				 out.println("<button id=\"next\" onclick=\"nextSlide()\">&rang;</button>");
				 out.println("</div>");
				 out.println("</div>");
				 out.println("<div id=\"contents\">");
				 out.println("<div id=\"tabMenu\">");
				 out.println("<input type=\"radio\" id=\"tab1\" name=\"tabs\" checked>");
				 out.println("<label for=\"tab1\">공지사항</label>");
				 out.println("<input type=\"radio\" id=\"tab2\" name=\"tabs\">");
				 out.println("<label for=\"tab2\">갤러리</label>");
				 out.println("<div id=\"notice\" class=\"tabContent\">");
				 out.println("<h2>공지사항 내용입니다.</h2>");
				 out.println("<ul>");
				 out.println("<li>사무실을 이전했습니다</li>");
				 out.println("<li>[참가 모집] 카약 체험에 초대합니다.</li>  <li>[참가 모집] 여름 방학 기간, 오름 체험단을 모집합니다.</li>  <li>겨울, 추천 여행지</li>");
				 out.println("<li>가을, 추천 여행지</li>");
				 out.println("</ul>");
				 out.println("</div>");
				 out.println("<div id=\"gallery\" class=\"tabContent\">");
				 out.println("<h2>갤러리 내용입니다.</h2>");
				 out.println("<ul>");
				 out.println("<li><img src=\"../bootstrap/img/img-1.jpg\"></li> \r\n"
				 		+ "        <li><img src=\"../bootstrap/img/img-2.jpg\"></li> \r\n"
				 		+ "        <li><img src=\"../bootstrap/img/img-3.jpg\"></li> \r\n"
				 		+ "        <li><img src=\"../bootstrap/img/img-1.jpg\"></li> \r\n"
				 		+ "        <li><img src=\"../bootstrap/img/img-2.jpg\"></li> \r\n"
				 		+ "        <li><img src=\"../bootstrap/img/img-3.jpg\"></li>");
				 out.println("</ul>");
				 out.println("</div>");
				 out.println("</div>");	
//				 out.println("</li>");
				 out.println("<form method='post' action='LoginCheck'>");
				 out.println("<table border='1' width='300'>");
				 out.println("<tr>");
				 out.println("<th width='100'>아이디</th>");
				 out.println("<td width='200'>&nbsp; <input type='text' name='id'></td>");
				 out.println("</tr>");
				 out.println("<tr>");
				 out.println("<th width='100'>비번</th>");
				 out.println("<td width='200'>&nbsp;<input type='password' name='pwd'></td>");
				 out.println("</tr>");
				 out.println("<tr>");
				 out.println("<td align='center' colspan='2'>");
				 out.println("<a href='bbs/memberjoin.html'>회원가입</a>");
				 out.println("<input type='submit' value='로그인'>");
				 out.println("</td>");
				 out.println("</tr>");
				 out.println("</table>");
				 out.println("</form>");
				 out.println("<div id=\"links\">");
				 out.println("<ul>");
				 out.println("<li>");
				 out.println("<a href=\"#\">");
				 out.println("<span id=\"quick-icon1\"></span>");
				 out.println("<p>평화기행</p>");
				 out.println("</a>");
				 out.println("</li>");
				 out.println("<li>");
				 out.println("<a href=\"#\"> \r\n"
				 		+ "          <span id=\"quick-icon2\"></span> \r\n"
				 		+ "          <p>힐링 워크샵</p> \r\n"
				 		+ "          </a></li>");
				 out.println("<li> \r\n"
				 		+ "          <a href=\"#\"> \r\n"
				 		+ "          <span id=\"quick-icon3\"></span> \r\n"
				 		+ "          <p>문의하기</p> \r\n"
				 		+ "          </a>  \r\n"
				 		+ "          </li> ");
				 out.println("</ul>");
				 out.println("</div>");
				 out.println("</div>");
				 out.println("<footer>");
				 out.println("<div id=\"bottomMenu\">");
				 out.println("<ul>");
				 out.println("<li><a href=\"#\">회사 소개</a></li> \r\n"
				 		+ "        <li><a href=\"#\">개인정보처리방침</a></li> \r\n"
				 		+ "        <li><a href=\"#\">여행약관</a></li>\r\n"
				 		+ "         <li><a href=\"#\">사이트맵</a></li>");
				 out.println("</ul>");
				 out.println("<div id=\"sns\">");
				 out.println("<ul>");
				 out.println("<li><a href=\"#\"><img src=\"../bootstrap/img/sns-1.png\"></a></li> \r\n"
				 		+ "          <li><a href=\"#\"><img src=\"../bootstrap/img/sns-2.png\"></a></li> \r\n"
				 		+ "          <li><a href=\"#\"><img src=\"../bootstrap/img/sns-3.png\"></a></li>");
				 out.println("</ul>");
				 out.println("</div>");
				 out.println("</div>");
				 out.println("<div id=\"company\">");
				 out.println("<p>제주특별자치도 ***동 ***로 *** (대표전화) 123-456-7890</p>");
				 out.println("</div>");
				 out.println("</footer>");
				 out.println("</div>");
				 out.println("<script src=\"./style.js?ver=20231128\"></script>");
				 out.println("</body>");
				 out.println("</html>");
				 }
				 } finally {
				 out.close();
				 }
				 }
				 @Override
				 protected void doGet(HttpServletRequest request,
				 HttpServletResponse response)
				 throws ServletException, IOException {
				 processRequest(request, response);
				 }
				 @Override
				 protected void doPost(HttpServletRequest request,
				 HttpServletResponse response)
				 throws ServletException, IOException {
				 processRequest(request, response);
				 }
				 
			
}