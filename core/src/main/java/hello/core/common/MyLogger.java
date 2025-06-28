package hello.core.common;

import static java.util.UUID.randomUUID;
import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }
}
