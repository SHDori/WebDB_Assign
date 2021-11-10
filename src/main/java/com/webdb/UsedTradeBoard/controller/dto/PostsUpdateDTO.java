package com.webdb.UsedTradeBoard.controller.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시물 수정시 update api에 들어갈 DTO
 * */

@NoArgsConstructor
@Getter
public class PostsUpdateDTO {

    private String title;   //게시물 제목

    private String writer;  //게시물 작성자

    private String kindOfItem;

    private String item; //판매 물품

    private String content; // 게시글 내용

    private String price; // 판매 가격

    private String tradePlace; // 거래장소

    @Builder
    public PostsUpdateDTO(String title,String writer,String kindOfItem,String item,String content,String price,String tradePlace){
        this.title = title;
        this.writer = writer;
        this.kindOfItem = kindOfItem;
        this.item = item;
        this.content = content;
        this.price = price;
        this.tradePlace = tradePlace;
    }
}
