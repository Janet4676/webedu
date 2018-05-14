package com.edu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
//@WebServlet("/He")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /*
     Servlet 특징
     동적 웹어플리케이션 컴포넌트 (jsp와 마찬가지로)
     확장자는 .java
     클라이언트의 요청에 동적으로 작동한다.
     java thread를 이용해서 동작한다.
     MVC 패턴에서 controller에 이용된다.
     
     
     URL 매핑(mapping)
     
     기존의 경로 > http://localhost:9090/webedu/servlet/com.edu.Hello
     URL 매핑 경로 > http://localhost:9090/web/He 
     
     기존의 경로를 숨겨줄 수 있고, 긴 url을 짧게 바꿔줄 수 있음.
     
     2가지 URL매핑 방법
     - web.html에서 서블릿 매핑하는 방법
     (WebContent->WEB-INF-> web.xml ->디자인모드 혹은 직접작성->
     welcome file list 우클릭 ->add After->Servlet->
     servlet->Servlet-name : HelloServlet
     servlet->Servlet-class : com.edu.Hello
     servlet-mapping-> Servlet-name : HelloServlet
     servlet-mapping-> url-pattern : /He2
     로 설정하고 위의 어노테이션을 주석처리한 후 실행하면 He2로 실행되는걸 볼 수 있음!)
     
     - 어노테이션(@WebServlet("/He"))을 이용하는 방법. (직접 적어줘도 되고 Servlet 만들면서 url 매핑 해줘도됨 He는 임의로 작성)
     
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
