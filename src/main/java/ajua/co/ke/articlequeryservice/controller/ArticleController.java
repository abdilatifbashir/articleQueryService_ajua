package ajua.co.ke.articlequeryservice.controller;


import ajua.co.ke.articlequeryservice.service.ArticleService;
import ajua.co.ke.articlequeryservice.wrapper.UniversalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{page}")
    public Mono<UniversalResponse> queryArticles(@PathVariable String page, @RequestParam String limit) {
        return articleService.queryArticles(page,limit);
    }


}
