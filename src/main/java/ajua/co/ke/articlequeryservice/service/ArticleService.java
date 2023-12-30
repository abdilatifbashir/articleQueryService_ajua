package ajua.co.ke.articlequeryservice.service;


import ajua.co.ke.articlequeryservice.wrapper.UniversalResponse;
import reactor.core.publisher.Mono;

public interface ArticleService {

    Mono<UniversalResponse> queryArticles(String page,String limit);


}
