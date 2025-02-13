package ypjs.project.dto.cartdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ypjs.project.domain.Cart;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartListDto {

    private Long cartId; //장바구니번호

    private Long itemId;  //상품번호

    private String itemName;  //상품명

    private String itemContent;  //상품설명

    private int itemPrice;  //상품가격

    private String itemFilepath;  //이미지 파일 경로

    private int itemCount;  //상품수량

    public CartListDto(Cart cart) {
        cartId = cart.getCartId();
        itemId = cart.getItem().getItemId();
        itemName = cart.getItem().getName();
        itemContent = cart.getItem().getContent();
        itemPrice = cart.getItem().getPrice();
        itemFilepath = cart.getItem().getFilePath();
        itemCount = cart.getItemCount();
    }
}
