package ajua.co.ke.articlequeryservice.service;

import ajua.co.ke.articlequeryservice.wrapper.UniversalResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final HttpRequest httpRequest;

    @Override
    public Mono<UniversalResponse> queryArticles(String page,String limit) {

        return httpRequest.searchArticlesByLimit(page,limit);
    }




}
