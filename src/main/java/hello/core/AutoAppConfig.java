package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(//@Component 붙은 클래스들을 자동으로 빈으로 등록
        basePackages = "hello.core.member",
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)//Configuration 어노테이션이 있는 클래스는 스캔하지 않는다.(예제를 위하여 AppConfig를 남겨놨기 때문에)
public class AutoAppConfig {


}
