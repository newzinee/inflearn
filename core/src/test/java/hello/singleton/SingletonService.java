package hello.singleton;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/04/11
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void login() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
