package hello.core.order;

<<<<<<< HEAD
=======

>>>>>>> b54b233b2381c2f158e25ebdfd65e4f42928b4c1
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD
@Getter
@Setter
@AllArgsConstructor
@ToString
=======
@AllArgsConstructor
@ToString
@Getter
@Setter
>>>>>>> b54b233b2381c2f158e25ebdfd65e4f42928b4c1
public class Order {//주문다 끝나고 할인 다 했을 때 만들어지는 객체
    private Long memberId;
    private String itemName;
    private int itemPrice;//원가
    private int discountPrice;//할인가격

<<<<<<< HEAD
=======

>>>>>>> b54b233b2381c2f158e25ebdfd65e4f42928b4c1
    //계산된 가격
    public int calculaterPrice() {
        return itemPrice-discountPrice;
    }
}
