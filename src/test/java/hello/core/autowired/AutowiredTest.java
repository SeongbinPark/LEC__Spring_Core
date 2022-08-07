package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import java.util.Optional;


public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        //첫번 째 방법 : requierd = false
        @Autowired(required = false)//기본 설정은 true 인데 이때는 무조건 빈이 있어서 주입받아야됨.
        public void setNoBean1(Member noBean1) {//Member는 스프링이 관리하는 빈이 아니라 없는거 테스트하는거임.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired// 두 번째 방법 : @Nullable
        public void setNoBean2(@Nullable Member noBean2) {//Member는 스프링이 관리하는 빈이 아니라 없는거 테스트하는거임.
            System.out.println("noBean2 = " + noBean2);
        }
        @Autowired//세번째 방법 : Optional 이용.
        public void setNoBean3(Optional<Member> noBean3) {//Member는 스프링이 관리하는 빈이 아니라 없는거 테스트하는거임.
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
