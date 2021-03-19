package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/19
 */
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(final Member member, final int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }

}
