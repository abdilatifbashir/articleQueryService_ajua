package ajua.co.ke.articlequeryservice.wrapper;

import lombok.Data;

@Data
public class Article {

    public String title;
    public String url;
    public String author;
    public int num_comments;
    public Object story_id;
    public String story_title;
    public String story_url;
    public int parent_id;
    public int created_at;
}
