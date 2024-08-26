package org.tc.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductImageDTO {
    @Min(value = 1, message = "Product id must be > 0")
    @JsonProperty("product_id")
    private Long productId;

    @Size(min = 5, max = 200, message = "Image name must 5 to 200 character")
    @JsonProperty("image_url")
    private String imageUrl;
}
