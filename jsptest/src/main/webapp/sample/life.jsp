<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
		//멤버변수
    private int numOne = 0;

    public void jspInit(){//메소드 재정의
        System.out.println("jspInit() 호출됨");
    }
    
    public void jspDestroy(){//메소드 재정의
        System.out.println("jspDestroy() 호출됨");
    }
%>
 <!-- 아웃트 라이트에 들어온다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아웃트 라이트 -->

<!-- 서비스 함수에 들어온다 -->
<%
    int numTwo = 0;
    this.numOne++; // 새로고침할때마다 증가
    numTwo++; // 새로고침할때마다 초기화
%>
<ul>
    <li>Number One : <%=this.numOne %></li>
    <li>Number Two : <%=numTwo %></li>
</ul>
</body>
</html>