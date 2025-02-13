package ypjs.project.dto.orderdto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ypjs.project.domain.enums.DeliveryStatus;
import ypjs.project.domain.enums.OrderStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class OrderSearchDto {
    private LocalDate startDate;
    private LocalDate endDate;
    private OrderStatus orderStatus;
    private DeliveryStatus deliveryStatus;
    private Long orderId;
    private String memberUserName;
    private String itemName;


}
