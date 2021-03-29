package hello.core.order;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/19
 */
public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}
