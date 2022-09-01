package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component 붙은 클래스들을 자동으로 빈으로 등록
        basePackages = "hello.core",
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)//Configuration 어노테이션이 있는 다른 클래스는 스캔하지 않는다.(예제를 위하여 AppConfig를 남겨놨기 때문에)
public class AutoAppConfig {

//    @Bean(name="memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }//자동 생성 vs 수동 생성 충돌 테스트용. ( 이름 같을 때 스프링부트는 오류내는게 디폴트설정 )


}
