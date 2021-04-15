package hello.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/11
 */
class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        final StatefulService statefulService1 = ac.getBean(StatefulService.class);
        final StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA
        statefulService1.order("userA", 10000);
        // ThreadB
        statefulService2.order("userB", 20000);

        // ThreadA
        final int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}