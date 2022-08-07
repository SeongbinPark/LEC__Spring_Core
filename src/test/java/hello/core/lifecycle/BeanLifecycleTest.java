package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifecycleTest {

    @Test
    public void lifecycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifecycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);//빈 조회
        ac.close();//applicationcontext 닫는 메서드 ( 스프링 컨테이너 닫는것 )
    }


    @Configuration
    static class LifecycleConfig {
//        @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {//빈 이름 : networkClient
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;//반환 타입이 빈으로 등록된다.
        }
    }
}
