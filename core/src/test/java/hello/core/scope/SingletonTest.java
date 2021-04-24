package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/24
 */
class SingletonTest {

    @Test
    void singletonBeanFind() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        final SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        final SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        Assertions.assertThat(singletonBean1).isSameAs(singletonBean2);

        ac.close();
    }

    @Scope("singleton")
    static class SingletonBean {

        @PostConstruct
        public void inti() {
            System.out.println("SingletonBean.inti");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }

    }

}
