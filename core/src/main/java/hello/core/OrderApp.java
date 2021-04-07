package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/23
 */
public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        final MemberService memberService = appConfig.memberService();
//        final OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        final OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        final Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        final Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
