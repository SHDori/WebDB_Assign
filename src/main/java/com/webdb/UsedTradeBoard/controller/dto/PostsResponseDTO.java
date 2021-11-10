package com.webdb.UsedTradeBoard.controller.dto;


import com.webdb.UsedTradeBoard.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDTO {

    private Long idx;

    private String title;   //게시물 제목

    private String writer;  //게시물 작성자

    private String kindOfItem;

    private String item; //판매 물품

    private String content; // 게시글 내용

    private String price; // 판매 가격

    private String tradePlace; // 거래장소

    private boolean isSale;

    private boolean deleteYn; // 삭제여부


    public PostsResponseDTO(Posts posts){
        this.idx = posts.getIdx();
        this.title = posts.getTitle();
        this.writer = posts.getWriter();
        this.kindOfItem = posts.getKindOfItem();
        this.item = posts.getItem();
        this.content = posts.getContent();
        this.price = posts.getPrice();
        this.tradePlace = posts.getTradePlace();
    }

}
