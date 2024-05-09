package com.jsp.chap01;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
//http://127.0.0.1:8181/login?name="kim"&age=13&grade=A

//역할 : HTTP 통신의 요청과 응답 데이터를 손쉽게 처리할 수 있게 도와주는 클래스

//WAS (톰캣) 에게 이 서블릿을 언제 호출할 지 URL을 매핑
@WebServlet("/login") //urlPattens 생략 가능
public class BasicServlet extends HttpServlet {
    public BasicServlet() {
        System.out.println("\n\n\nBasic Servlet 객체 생성 됨!\n\n\n");
    }

    //서버는 클라이언트에서 요청이 들어오면
    //http 메시지를 분석하여 요청 내용을 파악해야 함

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //요청 메시지 정보를 쉽게 읽도록 많은 메서드 제공

        //요청 방식
       String method = req.getMethod();

       //요청 URI
        String requestURI = req.getRequestURI();

        //요청 파라미터 정보
        String queryString = req.getQueryString();

        //요청 헤더 정보 읽기
        String header = req.getHeader("Cache-Control");

        System.out.println("method = " + method);
        System.out.println("requestURI = " + requestURI);
        System.out.println("queryString = " + queryString);
        System.out.println("header = " + header);

        //쿼리스트링 (요청파라미터) 하나씩 읽기
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String grade = req.getParameter("grade");

        System.out.println("grade = " + grade);
        System.out.println("age = " + age);
        System.out.println("name = " + name);

        // 서버의 응답 처리
        // 비즈니스 로직 : 나이를 기반으로 출생년도를 계산
        // 학점이 F면 과락처리, 아니면 통과처리
        int birthYear = 0;

        try {
            birthYear = LocalDate.now().getYear() - Integer.parseInt(age) + 1;
        } catch (NumberFormatException e) {
            resp.setStatus(400);
        }

        String message;
        switch (grade) {
            case "F":
                message = "F 이시군야 재수강 필수 대상입니다❕";
                break;
            case "A":
                message = "오 A 이시군여 !!!!! 굳굳";
                break;
            case "B":
                message = "오 B 이시군여 굳~굳";
                break;
            case "C":
                message = "오 C 이시군여 밭으로 갑시다";
                break;
            case "D":
                message = "오 D 이시군여.....";
                break;
            default:
                message = " 점수가 ABCDF외이군요. 다시 입력해주세여 😆";
        }

        //응답 메세지 생성
        resp.setStatus(200);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");

        //응답 바디에 넣을 html 생성
        PrintWriter w = resp.getWriter();

        w.write("<!DOCTYPE html>\n");
        w.write("<html>\n");
        w.write("<head>\n");
        w.write("</head>\n");
        w.write("<body>\n");
        w.write("   \t<h1>\n");
        w.write(String.format("%s님은 %d년생입니다.", name, birthYear));
        w.write("   </h1>\n");
        w.write("<h2>" + message + "</h2>");
        w.write("</body>\n");
        w.write("</html>");
    }
}
