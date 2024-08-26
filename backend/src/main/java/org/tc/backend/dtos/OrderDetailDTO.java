package org.tc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetailDTO {

    @JsonProperty("order_id")
    @Min(value=1, message = "Order's id must be > 0")
    private long orderId;

    @JsonProperty("product_id")
    @Min(value=1, message = "Order's id must be > 0")
    private long productId;

    @Min(value=0, message = "Price must be >= 0")
    private Float price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "number of products must be >= 1")
    private int numberOfProducts;

    @Min(value = 0, message = "total money must be >= 1")
    @JsonProperty("total_money")
    private Float totalMoney;

    private String color;

}
