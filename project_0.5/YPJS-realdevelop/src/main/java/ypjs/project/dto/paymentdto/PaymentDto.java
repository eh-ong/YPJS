package ypjs.project.dto.paymentdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ypjs.project.domain.Payment;
import ypjs.project.domain.enums.PayStatus;

import java.time.LocalDateTime;

public class PaymentDto {
    @Data
    @AllArgsConstructor
    public static class SuccessPaymentDto {
        private Long orderId;
        private int price;
        private LocalDateTime date;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FailPaymentDto {
        private String orderUid;
        private String errorMessage;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PaymentForOrderDetailDto {
        private Long paymentId; //환불 로직 용
        private int price; //포인트를 제외한 실 결제 금액
        private PayStatus status; //현재 결제 내역 상태


        public PaymentForOrderDetailDto(Payment payment){
            this.paymentId = payment.getPaymentId();
            this.price = payment.getPrice();
            this.status = payment.getStatus();
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class checkLoginMemberOrderMemberDto {
        private boolean check;
        private String message;
    }


}
