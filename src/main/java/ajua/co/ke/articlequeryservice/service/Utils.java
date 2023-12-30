package ajua.co.ke.articlequeryservice.service;
import ajua.co.ke.articlequeryservice.wrapper.ApiResMessage;
import ajua.co.ke.articlequeryservice.wrapper.Article;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class Utils {
    public String generateReference() {
        return UUID.randomUUID().toString();
    }


    private List<Article> filterAndSortArticles(List<Article> articles) {
        return articles.stream()
                .filter(article -> isTitleNotEmpty(article.getTitle()) || isTitleNotEmpty(article.getStory_title()))
                .sorted(Comparator.comparing(Article::getNum_comments, Comparator.reverseOrder())
                        .thenComparing(Article::getTitle))
                .collect(Collectors.toList());
    }

    private boolean isTitleNotEmpty(String title) {
        return title != null && !title.isEmpty();
    }

    public List<Article> topArticles(int limit, List<Article> articles) {
        List<Article> topArticles = new ArrayList<>();

        while (!articles.isEmpty()) {
            List<Article> filteredArticles = filterAndSortArticles(articles);

            for (Article article : filteredArticles) {
                topArticles.add(article);
                if (topArticles.size() == limit) {
                    return topArticles;
                }
            }
        }

        return topArticles;
    }

}
