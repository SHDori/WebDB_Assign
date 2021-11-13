package com.webdb.UsedTradeBoard.service.posts;

import com.webdb.UsedTradeBoard.controller.dto.PostsListResponseDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsResponseDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsSaveRequestDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsUpdateDTO;
import com.webdb.UsedTradeBoard.domain.posts.Posts;
import com.webdb.UsedTradeBoard.domain.posts.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    //게시글 등록
    @Transactional
    public Long save(PostsSaveRequestDTO saveDTO){
        return postsRepository.save(saveDTO.toEntity()).getIdx();
    }

    // idx로 게시글 조회
    public PostsResponseDTO findById(Long idx){
        Posts post = postsRepository.findById(idx)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다. idx = "+idx));
        return new PostsResponseDTO(post);
    }

    //게시글 수정
    @Transactional
    public Long update(Long idx, PostsUpdateDTO updateDTO){
        Posts posts = postsRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. idx = "+idx));
        posts.update(updateDTO.getTitle(),updateDTO.getWriter(),updateDTO.getKindOfItem(), updateDTO.getItem(), updateDTO.getContent(), updateDTO.getPrice()
                , updateDTO.getTradePlace() );
        return idx;
    }

    //게시글 삭제(실제론 삭제x)
    @Transactional
    public void delete(Long idx){
        Posts posts = postsRepository.findById(idx)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다 id = "+idx));
        posts.delete();
    }

    @Transactional
    public void endSale(Long idx){
        Posts posts = postsRepository.findById(idx)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시물이 없습니다 id = "+idx));
        posts.endSale();
    }


    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findAllDesc(){
        return postsRepository.findAllNotDeleted().stream().map(PostsListResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDTO> findByKeyword(String keyword){
        return postsRepository.findByKeyword(keyword).stream().map(PostsListResponseDTO::new).collect(Collectors.toList());
    }


}
