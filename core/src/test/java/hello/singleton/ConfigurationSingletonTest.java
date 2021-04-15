package hello.singleton;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/13
 */
public class ConfigurationSingletonTest {

    @Test
    void configurationDeep() {
        final ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        final AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }

}
