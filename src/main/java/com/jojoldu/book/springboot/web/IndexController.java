package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.dto.PostsResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        //        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        //        기존 세션에서 가져오던 세션정보 값이 개선
        // 앞서 작성된 customOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장
        // 로그인 성공시 httpSession.getAttribute("user") 값을 가져올 수 있음
        
        if(user !=null){
            model.addAttribute("userName",user.getName());
        }//세션에 저장된 값이 있을 때만 model에 userName으로 등록
        // 아무 값이 없다면 로그인 버튼이 보임
        
        return "index";
    }
    //머스테치 스타터 덕분에 컨트롤러에서 앞의 경로와 뒤의 확장자는 자동으로 붙음
    @GetMapping("/posts/save")
    public String postsSave(){
        return"posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

}
