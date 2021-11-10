package com.webdb.UsedTradeBoard.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    // Delete_YN이 false인 값만 조회(삭제 안된것만 조회)
    @Query("SELECT p FROM Posts p WHERE p.deleteYn = false")
    List<Posts> findAllNotDeleted();
}
