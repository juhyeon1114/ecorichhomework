package demo.ecorichhomework.domain.common.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import demo.ecorichhomework.domain.common.data.dto.BeachTemperatureApiResponse.Response.Body.Items.Item;
import demo.ecorichhomework.global.exception.exceptions.ItemNotFoundException;
import java.util.List;
import lombok.Data;

@Data
public class BeachTemperatureApiResponse {

    private Response response;

    @Data
    public static class Response {

        private Header header;
        private Body body;

        @Data
        public static class Header {

            private String resultCode;
            private String resultMsg;
        }

        @Data
        public static class Body {

            private String dataType;
            private Items items;
            private int pageNo;
            private int numOfRows;
            private int totalCount;

            @Data
            public static class Items {

                private List<Item> item;

                @Data
                public static class Item {

                    private String beachNum;
                    private String tm;
                    private String tw;
                }
            }
        }
    }

    @JsonIgnore
    public Double getTemperature() {
        List<Item> items = response.getBody().getItems().getItem();
        if (items.isEmpty()) {
            throw new ItemNotFoundException("조회된 데이터가 없습니다");
        }
        return Double.parseDouble(items.getFirst().getTw());
    }

}
