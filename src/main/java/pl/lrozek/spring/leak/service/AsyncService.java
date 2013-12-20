package pl.lrozek.spring.leak.service;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class AsyncService {

    @Async
    public Future<String> doAsyncWork() {
        return new AsyncResult<String>( Thread.currentThread().getName() );
    }

}
