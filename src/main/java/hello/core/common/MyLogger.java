package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)//인터페이스면 인터페이스.
//가짜(프록시)를 만드는 것.
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }


    public void log(String message) {
        System.out.println("[" + uuid + "]" + " [" + requestURL + "]" + message);

    }

    @PostConstruct//고객요청이 들어와서 최초로 스프링에 달라할 때 호출.
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created: " + this);

    }

    @PreDestroy//고객요청이 빠져나가면 호출.
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);

    }
}
