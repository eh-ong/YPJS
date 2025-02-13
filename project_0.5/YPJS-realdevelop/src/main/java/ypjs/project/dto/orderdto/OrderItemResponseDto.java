package ypjs.project.dto.orderdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ypjs.project.domain.OrderItem;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponseDto {

    private Long orderId;
    private Long itemId;
    private String name;
    private String filepath;
    private int count;
    private int totalPrice;

    public static OrderItemResponseDto create (OrderItem oi) {
        OrderItemResponseDto oid = new OrderItemResponseDto();
        oid.orderId = oi.getOrder().getOrderId();
        oid.itemId = oi.getItem().getItemId();
        oid.name = oi.getItem().getName();
        oid.filepath = oi.getItem().getFilePath();
        oid.count = oi.getCount();
        oid.totalPrice = oi.totalPrice();
        return oid;
    }

}
