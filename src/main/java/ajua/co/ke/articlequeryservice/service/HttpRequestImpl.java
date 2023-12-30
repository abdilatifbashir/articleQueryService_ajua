package ajua.co.ke.articlequeryservice.service;

import ajua.co.ke.articlequeryservice.wrapper.ApiResMessage;
import ajua.co.ke.articlequeryservice.wrapper.UniversalResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class HttpRequestImpl implements HttpRequest {

    @Resource
    private Environment environment;

    @Autowired
    private WebClient webClient;

    @Autowired
    private Utils utils;

    @Override
    public Mono<UniversalResponse> searchArticlesByLimit(String page,String limit) {
        String endpoint = environment.getProperty("endpoints.articleUrl") + page;
        System.out.println("url >> " + endpoint);

        return this.webClient
                .get()
                .uri(endpoint)
                .retrieve()
                .bodyToMono(ApiResMessage.class)
                .map(result -> {
                    System.out.println("resulttt: " + result);
                    // call the method here
                    utils.topArticles(Integer.valueOf(limit),result.getData());
                    return new UniversalResponse(utils.generateReference(), "200", "success", utils.topArticles(Integer.valueOf(limit),result.getData()));
                })
                .onErrorResume(error -> {
                    // Handle errors
                    return Mono.just(new UniversalResponse(utils.generateReference(),"500", "internal error server", error));
                });
    }

}
