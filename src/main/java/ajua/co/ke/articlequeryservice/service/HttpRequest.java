package ajua.co.ke.articlequeryservice.service;

import ajua.co.ke.articlequeryservice.wrapper.UniversalResponse;
import reactor.core.publisher.Mono;

public interface HttpRequest {

    Mono<UniversalResponse> searchArticlesByLimit(String page,String limit);
}
