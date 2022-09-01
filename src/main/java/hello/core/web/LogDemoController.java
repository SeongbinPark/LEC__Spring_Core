package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;//생성자주입 ( 롬복)
    //    private final MyLogger myLogger;//생성자주입, request scope
//    //오류뜨는 이유 MyLogger 객체는 request scope인데 ( = 생존범위 : 고객들어오고 나갈때까지 )
//    //스프링 띄우는 단계 에서는 http 요청이 오지도 않음 (생성자 주입이므로 스프링 띄우는 단계에서 주입받는데..)
//    //앞뒤가 안맞다.!!!  -> Provider 쓰자!!!!!=DL받자!!!!!!!!!!!!!!!!!!!!!!
    private final ObjectProvider<MyLogger> myLoggerProvider;


//    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)//인터페이스면 인터페이스.
//    에서 proxyMode = ScopedProxyMode.TARGET_CLASS 를 쓰면 ObjectProvider 쓸 필요없다.
    // 여기선 그냥 ObjectProvider 붙여둠.


    @RequestMapping("log-demo")
    @ResponseBody//문자 그대로 반환
    //요청이 들어와야 컨트롤러로 들어오므로 지금은 HTTP요청이 살이있는 상태.
    //그 뒤에 DL 받기 때문에 request scope에 아무런 문제가 없다.
    public String logDemo(HttpServletRequest request) { //HttpServletRequest : 요청 정보 받을수있음.
        MyLogger myLogger = myLoggerProvider.getObject(); //Provider 쓸 때 DL받는 코드.
        //ObjectProvider 안 쓰면 여기서 .getObject안해도됨. ( 이름을 myLoggerProvider라고 헷갈리게 지어둠. )


        String requestURL = request.getRequestURL().toString();//요청 온 URL 꺼내기

        myLogger.setRequestURL(requestURL);//아까 설정한 setter

        System.out.println("myLoggerProvider = " + myLogger.getClass());

        myLogger.setRequestURL(requestURL);//아까 설정한 setter
//        MyLogger의 기능을 실제 호출하는 시점에 진짜를 넣어줌.


        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
