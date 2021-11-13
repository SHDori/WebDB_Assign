package com.webdb.UsedTradeBoard.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {

    // Delete_YN이 false인 값만 조회(삭제 안된것만 조회)
    @Query("SELECT p FROM Posts p WHERE p.deleteYn = false ORDER BY p.idx DESC")
    List<Posts> findAllNotDeleted();

    // 제목, 물건명으로 조회 (삭제안된거만 조회)
    @Query("SELECT p FROM Posts p WHERE p.title LIKE %:keyword% OR p.item LIKE %:keyword% AND p.deleteYn = false")
    List<Posts> findByKeyword(@Param("keyword") String keyword);
}
