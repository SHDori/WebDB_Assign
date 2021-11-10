package com.webdb.UsedTradeBoard.controller.dto;


import com.webdb.UsedTradeBoard.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * 게시물 저장시 api에 전달되는 DTO
 * */

@NoArgsConstructor
@Getter
public class PostsSaveRequestDTO {

    private String title;   //게시물 제목

    private String writer;  //게시물 작성자

    private String kindOfItem;

    private String item; //판매 물품

    private String content; // 게시글 내용

    private String price; // 판매 가격

    private String tradePlace; // 거래장소

    @Builder
    public PostsSaveRequestDTO(String title,String writer,String kindOfItem,String item,String content,String price,String tradePlace){
        this.title = title;
        this.writer = writer;
        this.kindOfItem = kindOfItem;
        this.item = item;
        this.content = content;
        this.price = price;
        this.tradePlace = tradePlace;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title).writer(writer).kindOfItem(kindOfItem).content(content).item(item).price(price).tradePlace(tradePlace).build();
    }

}
