package com.webdb.UsedTradeBoard.controller;

import com.webdb.UsedTradeBoard.controller.dto.PostsResponseDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsSaveRequestDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsUpdateDTO;
import com.webdb.UsedTradeBoard.domain.posts.Posts;
import com.webdb.UsedTradeBoard.domain.posts.PostsRepository;
import com.webdb.UsedTradeBoard.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;

    @PostMapping("/api/board/posts")
    public Long save(@RequestBody PostsSaveRequestDTO saveDTO){

        return postsService.save(saveDTO);
    }

//    @GetMapping("/api/board/posts/{idx}")
//    public PostsResponseDTO findById(@PathVariable Long idx){
//
//        PostsResponseDTO postsResponseDTO = postsService.findById(idx);
//
//        return postsResponseDTO;
//
//    }

    // 게시글 수정
    @PutMapping("/api/board/posts/{idx}")
    public Long update(@PathVariable Long idx, @RequestBody PostsUpdateDTO updateDTO){
        return postsService.update(idx,updateDTO);
    }
    // 게시글 삭제
    @PutMapping("/api/board/posts/{idx}/isDelete")
    public Long delete(@PathVariable Long idx){
        postsService.delete(idx);
        return idx;
    }

    @PutMapping("/api/board/posts/{idx}/endRecruiting")
    public Long endRecruiting(@PathVariable Long idx){

        postsService.endSale(idx);
        return idx;
    }

    @PostConstruct
    public void initializing(){

        for (int i = 0; i < 10; i++) {
            Posts posts = Posts.builder()
                    .title(i+"번 게시글")
                    .content(i+"내용내용")
                    .kindOfItem("식품")
                    .writer("김승환")
                    .price("5000")
                    .tradePlace("안양")
                    .item("컵라면")
                    .build();
            postsRepository.save(posts);
        }
        for (int i = 10; i < 15; i++) {
            Posts posts = Posts.builder()
                    .title(i+"번 게시글")
                    .content(i+"내용내용")
                    .kindOfItem("운동")
                    .writer("김승환")
                    .price("5000")
                    .tradePlace("안양")
                    .item("글러브")
                    .build();
            postsRepository.save(posts);
        }
    }

}
