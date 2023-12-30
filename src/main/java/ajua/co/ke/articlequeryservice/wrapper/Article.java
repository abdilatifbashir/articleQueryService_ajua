package ajua.co.ke.articlequeryservice.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Article {

    public String title;
    public String url;
    public String author;
    @JsonProperty("num_comments")
    public int numComments;

    @JsonProperty("story_id")
    public Object storyId;

    @JsonProperty("story_title")
    public String storyTitle;

    @JsonProperty("story_url")
    public String storyUrl;

    @JsonProperty(" parent_id")
    public int parentId;

    @JsonProperty("created_at")
    public int createdAt;
}
