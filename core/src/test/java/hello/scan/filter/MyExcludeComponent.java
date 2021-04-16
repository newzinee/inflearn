package hello.scan.filter;

import java.lang.annotation.*;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/16
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
