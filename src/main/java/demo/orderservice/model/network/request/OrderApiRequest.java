package demo.orderservice.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderApiRequest {

    private Long id;

    private String status;

    private String paymentType;

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private Long deliveryId;

    private Long consumerId;

}
