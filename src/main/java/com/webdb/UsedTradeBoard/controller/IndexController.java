package com.webdb.UsedTradeBoard.controller;

import com.webdb.UsedTradeBoard.controller.dto.PostsListResponseDTO;
import com.webdb.UsedTradeBoard.controller.dto.PostsResponseDTO;
import com.webdb.UsedTradeBoard.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/api/board/search/{keyword}")
    public String search(@PathVariable String keyword, Model model){
        model.addAttribute("posts",postsService.findByKeyword(keyword));
        return "search";
    }

    @GetMapping("/posting")
    public String posting(Model model){

        return "inputPage";
    }




    @GetMapping("/api/board/posts/{idx}")
    public String findById(@PathVariable Long idx, Model model){

        PostsResponseDTO postsResponseDTO = postsService.findById(idx);
        model.addAttribute("post",postsResponseDTO);

        return "viewPage";

    }

    @GetMapping("/api/board/posts/update/{idx}")
    public String updating(@PathVariable Long idx, Model model){

        PostsResponseDTO postsResponseDTO = postsService.findById(idx);
        model.addAttribute("post",postsResponseDTO);

        return "updatePage";

    }
}
