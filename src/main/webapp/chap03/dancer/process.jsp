<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="com.jsp.entity.Dancer" %>

<%!
  // 필드 선언 - 데틀라레이션 오래된 문법
public static List<Dancer> dancerList = new ArrayList<>();
%>

<%
 request.setCharacterEncoding("uft-8");
    String name = request.getParameter("name");
    String crewName = request.getParameter("crewName");
    String danceLevel = request.getParameter("danceLevel");
    String [] genres = request.getParameterValues("genres");

    //댄서 객체 생성
    Dancer dancer = new Dancer();
    dancer.setName(name);
    dancer.setCrewName(crewName);
    dancer.setDanceLevel(Dancer.DanceLevel.valueOf(danceLevel));

    //반복문
    List<Dancer.Genre> genreList = new ArrayList<>();

    for (String genre : genres) {
        genreList.add(Dancer.Genre.valueOf(genre));
    }
    dancer.setGenres(genreList);

%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h1> <%= dancer.getName()%> 님이 등록되었습니다.  </h1>
<a href="/chap02/dancer/DancerListServlet"> 댄서 정보 모아 보기 </a>


</body>
</html>