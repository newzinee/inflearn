package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/24
 */
class SingletonWithPrototypeTest {

    @Test
    void prototypeFind() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        final PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);

        final PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }
    
    @Test
    void singletonClientUsePrototype() {
        final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        final ClientBean clientBean1 = ac.getBean(ClientBean.class);
        final int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        final ClientBean clientBean2 = ac.getBean(ClientBean.class);
        final int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }
    
    @Scope("singleton")
    static class ClientBean {

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic() {
            final PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }

    }

    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
