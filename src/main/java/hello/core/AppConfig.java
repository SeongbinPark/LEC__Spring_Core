package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //@Bean -> memberService -> new MemoryMemberRepository()
    //@Bean -> orderService -> new MemoryMemberRepository(), new RateDiscountPolicy()
<<<<<<< HEAD
    //여러번 new되는데 어떻게 singleton을 유지 할까? -> @Configuration

    //이렇게 리펙터링하면 역할에 어떤 구현체를 쓸 건지 한 눈에 파악할 수 있고 나중에 구현체만 갈아끼기 쉽다.

=======
>>>>>>> b54b233b2381c2f158e25ebdfd65e4f42928b4c1
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
