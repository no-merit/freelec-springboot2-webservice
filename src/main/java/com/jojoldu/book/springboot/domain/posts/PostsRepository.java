package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    //규모가 있는 프로젝트에서는 데이터 조회는 FK의 조인, 복잡한 조건 등으로 인해 이런 Entity 만으로 처리하기 어려워 조회용 프레임워크를 추가로 사용.

}
