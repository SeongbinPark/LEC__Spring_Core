package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    // 자기 자신을 내부에 하나 가지고 있는다 . ( private static으로 )
    //static이라 되어있으면 static영역에 딱 하나만 만들어져서 올라감.

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }
    public void logic() {

    }
}
