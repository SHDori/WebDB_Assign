package com.webdb.UsedTradeBoard.controller;


import com.webdb.UsedTradeBoard.controller.dto.PostsSaveRequestDTO;
import com.webdb.UsedTradeBoard.domain.posts.Posts;
import com.webdb.UsedTradeBoard.domain.posts.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록테스트() throws Exception{
        //given
        String title = "게시글1";
        String content = "테스트내용";

        PostsSaveRequestDTO requestDTO = PostsSaveRequestDTO.builder().title(title).content(content).build();

        String url = "http://localhost:"+port + "/api/board/posts";


        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDTO,Long.class);


        //then
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();

        Assertions.assertThat(all.get(0).getTitle()).isEqualTo(title);
        Assertions.assertThat(all.get(0).getContent()).isEqualTo(content);
    }
}
