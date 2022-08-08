package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;//생성자주입 ( 롬복)
    private final MyLogger myLogger;//생성자주입, request scope
    //오류뜨는 이유 MyLogger 객체는 request scope인데 ( = 생존범위 : 고객들어오고 나갈때까지 )
    //스프링 띄우는 단계 에서는 http 요청이 오지도 않음 (생성자 주입이므로 스프링 띄우는 단계에서 주입받는데..)
    //앞뒤가 안맞다.!!!  -> Provider 쓰자!!!!!=DL받자!!!!!!!!!!!!!!!!!!!!!!



    @RequestMapping("log-demo")
    @ResponseBody//문자 그대로 반환
    public String logDemo(HttpServletRequest request) {//HttpServletRequest : 요청 정보 받을수있음.
        String requestURL = request.getRequestURL().toString();//요청 온 URL 꺼내기
        myLogger.setRequestURL(requestURL);//아까 설정한 setter

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
