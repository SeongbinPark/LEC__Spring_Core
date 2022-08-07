package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefullService statefullService1 = ac.getBean(StatefullService.class);
        StatefullService statefullService2 = ac.getBean(StatefullService.class);

        //ThreadA에서 A 사용자가 10000월 주문
        int userAPrice = statefullService1.order("userA", 10000);
        //ThreadB에서 B 사용자가 20000월 주문
        int userBPrice = statefullService2.order("userB", 20000);

        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);



        

        //ThreadA: 사용자A 가 줌누금액 조회
//        int price = statefullService1.getPrice();//20000원 출력

//        Assertions.assertThat(statefullService1.getPrice()).isEqualTo(20000);
    }


    @Configuration
    static class TestConfig {

        @Bean
        public StatefullService statefullService() {
            return new StatefullService();
        }
    }

}
