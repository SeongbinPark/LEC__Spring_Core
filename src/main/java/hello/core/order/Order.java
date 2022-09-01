package hello.core.order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Order {//주문다 끝나고 할인 다 했을 때 만들어지는 객체
    private Long memberId;
    private String itemName;
    private int itemPrice;//원가
    private int discountPrice;//할인가격

    //계산된 가격
    public int calculaterPrice() {
        return itemPrice-discountPrice;
    }
}
