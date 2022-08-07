package hello.core.scan.filter;


import java.lang.annotation.*;

//
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented//이 3개는 일단 넘어가자
public @interface MyExcludeComponent {
    //@MyExcludeComponent 가 붙은건 컴포넌트스캔에서 제외할거야.





}
