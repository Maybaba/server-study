package com.jsp.repository;

import com.jsp.entity.Dancer;

import java.util.ArrayList;
import java.util.List;

//역할 : 메모리 데이터 베이스에 댄서드릉ㄹ CRUD (저장,조회,수정,삭제)
//Model
public class DancerMemoryRepo {

    //싱글톤 구현 - 하나만 생성자 객체를 만들도록 한 뒤 그 값을 전역에서 공유할 수 있도록 하는 기능
    private static DancerMemoryRepo repo = new DancerMemoryRepo();

    //싱글 객체를 리턴하는 메서드
    public static DancerMemoryRepo getInstance() {
        return repo;
    }

    //데이터베이스 역할을 할 자료구조
    private List<Dancer> dancerList = new ArrayList<>();

    //댄서를 데이터베이스에 저장하는 기능
    public boolean save(Dancer dancer) {
        if(dancer == null) return false;
        dancerList.add(dancer);
        System.out.println("dancerList = " + dancerList);
        return true;
    }

    //댄서 리스트를 반환하는 기능
    public List<Dancer> retrieve() {
        return dancerList;
    }

}
