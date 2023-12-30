package ajua.co.ke.articlequeryservice.wrapper;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ApiResMessage {

    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<Article> data;
}
