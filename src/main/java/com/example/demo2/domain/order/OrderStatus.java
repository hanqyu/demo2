package com.example.demo2.domain.order;

public enum OrderStatus {
    PENDING("결제 전"),
    PAID("결제 완료"),
    PLACED("발주 완료"),
    SHIPPING("배송중"),
    DELIVERED("배송완료"),
    CANCELED("주문취소"),
    FAILED("주문실패")
    ;

    private String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }
}
