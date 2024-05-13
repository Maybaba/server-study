package com.jsp.chap04;

import com.jsp.entity.Dancer;
import com.jsp.repository.DancerJdbcRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/chap04/remove")
public class DancerRemoveServlet  extends HttpServlet {

    private final DancerJdbcRepo repo = new DancerJdbcRepo().getInstance();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("삭제 요청 서버 들어옴!");

        //삭제를 하려면 데이터베이서에서 해당 데이터 지워야 함
        //지우려면 대체 뭘 지워야 할지 클라이언트가 알려줘야 함 (PK정보로 인한 정보 삭제 요청)
        // 클라이언트에서 보낸 url에 붙은 id값 읽어오기
        String id = req.getParameter("id");
        System.out.println("삭제대상 id : " + id);

        //db에 삭제 명령
        repo.delete(id);

        //chap04/show-list 요청을 자동으로 보냄 ( 리다이렉션 ) 띠용 뭔소리일ㄷ까? 재귀호출?
        //esp.sendRedirect("/chap04/show-list"); //삭제가 끝나고 갈 주소 설정
        resp.sendRedirect("https://www.youtube.com/watch?v=KPnF7UrLRiQ&t=955s"); //은혼 플레이리스트

        // 해당 코드는 showDancerListServlet에 있어서 33 line을 작성해서 그 리스트로 들어간다.

//        //리스트를 다시 구해옴
//        List<Dancer> dancerList = repo.retrieve();
//        //리스트를 등록함
//        req.setAttribute("dancers", dancerList);
//
//        //적절한 화면 이동
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/chap04/dancer-list.jsp");
//        requestDispatcher.forward(req, resp);


    }
}
