package com.jsp.chap04;

import com.jsp.entity.Dancer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 역할: 댄서 등록 화면을 요청하면 해당 html파일을 열기만해주는 역할
@WebServlet("/chap04/dancer/form")
public class DancerFormRequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 적당한 view에게 화면처리를 위임
        // forwarding: 화면 파일을 찾아서 열어주는 개념 view templet 찾아주기
        RequestDispatcher rd
                = req.getRequestDispatcher("/WEB-INF/chap04/register.jsp");
        rd.forward(req, resp);

        req.setCharacterEncoding("utf-8");

        String name = req.getParameter("name");
        String crewName = req.getParameter("crewName");
        String danceLevel = req.getParameter("danceLevel");
        String[] genres = req.getParameterValues("genres");

        // 댄서 객체 생성
        Dancer dancer = new Dancer();
        dancer.setName(name);
        dancer.setCrewName(crewName);
        dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

        List<Dancer.Genre> genreList = new ArrayList<>();
        for (String genre : genres) {
            genreList.add(Dancer.Genre.valueOf(genre));
        }
        dancer.setGenres(genreList);

        System.out.println("dancer = " + dancer);


    }


}