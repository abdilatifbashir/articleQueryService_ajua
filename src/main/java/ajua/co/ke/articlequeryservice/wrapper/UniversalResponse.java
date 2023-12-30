package ajua.co.ke.articlequeryservice.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UniversalResponse {

    String requestRef;
    private String responseCode;
    private String responseMessage;

    private Object data;
}
