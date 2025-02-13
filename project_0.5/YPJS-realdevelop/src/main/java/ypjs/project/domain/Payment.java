package ypjs.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ypjs.project.domain.enums.PayStatus;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "payment")
@NoArgsConstructor
public class Payment {
    @Id @GeneratedValue
    @Column(name = "payment_id")
    private Long paymentId;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_order_id")
    private Order order;

    //실결제금액
    private int price;

    private String name;

    private String phone;

    private String email;

    private LocalDateTime date; //결제 완료 날짜

    @Enumerated(EnumType.STRING)
    private PayStatus status; //OK, READY, CANCEL

    private String uid; //결제 고유 번호

    //==생성 메서드==//

    public static Payment create(Order order, int price, String name, String phone, String email) {
        Payment payment = new Payment();
        payment.order = order;
        payment.price = price;
        payment.name = name;
        payment.phone = phone;
        payment.email = email;
        payment.date = LocalDateTime.now();
        payment.status = PayStatus.READY;
        return payment;
    }

    //==결제 완료 시 paymentUid, 상태, 결제완료 날짜로 업데이트 메서드==//
    public void changeUidAndStatusAndDate(PayStatus payStatus, String uid){
        this.status = payStatus;
        this.uid = uid;
        this.date = LocalDateTime.now();
    }

    //==결제 상태 메서드==//
    public void changeStatus(PayStatus payStatus){
        this.status = payStatus;
    }

    //==결제 완료 후 포인트 사욯한 금액으로 업데이트 메서드==//
    public void changePrice(int price){
        this.price = price;
    }

    //==결제 취소 상태처리 메서드==//
    public void changePaymentStatusCanceled(){
        if(status.equals(PayStatus.READY)){
            throw new IllegalStateException("결제 전의 주문은 취소가 불가능 합니다.");
        }else if(status.equals(PayStatus.CANCEL)){
            throw new IllegalStateException("이미 취소된 주문입니다.");
        }
        this.status = PayStatus.CANCEL;
    }


    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }
}