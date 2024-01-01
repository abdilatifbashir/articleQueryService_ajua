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
                    .filter(article -> isTitleNotEmpty(article.getStoryTitle()) && isTitleNotEmpty(article.getTitle()))
                    .sorted(Comparator.comparing(Article::getNumComments, Comparator.reverseOrder())
                            .thenComparing(Article::getTitle))
                    .collect(Collectors.toList());

    }

    private boolean isTitleNotEmpty(String title) {
        return title != null && !title.isEmpty();
    }

    public List<Article> topArticles(int limit, List<Article> articles) {
        List<Article> topArticles = new ArrayList<>();

        if (!articles.isEmpty()) {
            List<Article> filteredArticles = filterAndSortArticles(articles);

          if(!filteredArticles.isEmpty()){
              for (Article article : filteredArticles) {
                  topArticles.add(article);
                  if (topArticles.size() == limit) {
                      return topArticles;
                  }
              }
          }
        }

        return topArticles;
    }

}
