package ajua.co.ke.articlequeryservice.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ApiResMessage {

    public int page;
    @JsonProperty("per_page")
    public int perPage;
    public int total;

    @JsonProperty("total_pages")
    public int totalPages;
    public ArrayList<Article> data;
}
