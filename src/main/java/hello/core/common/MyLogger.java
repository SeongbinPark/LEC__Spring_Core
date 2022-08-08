package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope("request")//request scope
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
