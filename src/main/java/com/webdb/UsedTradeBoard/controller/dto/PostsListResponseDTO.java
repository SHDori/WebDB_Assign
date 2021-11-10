package com.webdb.UsedTradeBoard.controller.dto;

import com.webdb.UsedTradeBoard.domain.posts.Posts;
import lombok.Getter;

/**
 * 게시판 리스트로 쭈욱 나열할때 전달되는DTO입니다
 * */

@Getter
public class PostsListResponseDTO {

    private Long idx;

    private String title;   //게시물 제목

    private String writer;  //게시물 작성자

    private String kindOfItem;

    private String item; //판매 물품

    private String price; // 판매 가격

    private boolean isSale;

    public PostsListResponseDTO(Posts posts){
        this.idx = posts.getIdx();
        this.title = posts.getTitle();
        this.writer = posts.getWriter();
        this.kindOfItem = posts.getKindOfItem();
        this.item = posts.getItem();

        this.price = posts.getPrice();

        this.isSale = posts.isSale();

    }


}
