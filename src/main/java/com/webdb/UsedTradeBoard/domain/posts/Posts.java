package com.webdb.UsedTradeBoard.domain.posts;


import com.webdb.UsedTradeBoard.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx; //게시물의 id

    @Column(length = 500, nullable = false)
    private String title;   //게시물 제목

    private String writer;  //게시물 작성자

    private String kindOfItem; // 물건종류

    private String item; //판매 물품

    private String content; // 게시글 내용

    private String price; // 판매 가격

    private String tradePlace; // 거래장소

    private boolean isSale;

    private boolean deleteYn; // 삭제여부

    @Builder
    public Posts(String title,String writer,String kindOfItem,String item,String content,String price,String tradePlace){
        this.title = title;
        this.writer = writer;
        this.kindOfItem = kindOfItem;
        this.item = item;
        this.content = content;
        this.price = price;
        this.tradePlace = tradePlace;
        this.isSale= true;
        this.deleteYn = false;
    }

    public void update(String title,String writer,String kindOfItem,String item,String content,String price,String tradePlace) {
        this.title = title;
        this.writer = writer;
        this.kindOfItem = kindOfItem;
        this.item = item;
        this.content = content;
        this.price = price;
        this.tradePlace = tradePlace;
    }

    public void delete(){
        this.deleteYn = true;
    }

    public void endSale(){
        this.isSale = false;
    }
}
