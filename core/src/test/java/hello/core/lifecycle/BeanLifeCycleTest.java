package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/21
 */
class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        final ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        final NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean
        public NetworkClient networkClient() {
            final NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://github.com/treasureBear94");
            return networkClient;
        }
    }
}
