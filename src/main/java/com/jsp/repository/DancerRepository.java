package com.jsp.repository;

import com.jsp.entity.Dancer;

import java.util.*;

// 추상화된 역할 : Dancer 데이터를 CRUD 하는 것
// 구체적으로 어떻게 어디에서 DB에서 ? 세이브파일에서??? 모르겠어. 구현하는 기능만 적어놔.
public interface DancerRepository {

    boolean save(Dancer dancer);
    List<Dancer> retrieve();

    void delete(String id);
}
