package pl.lrozek.spring.leak.main;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import pl.lrozek.spring.leak.config.AppConfig;
import pl.lrozek.spring.leak.service.AsyncService;

public class LeakMain {

    public static void main( String[] args ) throws InterruptedException, ExecutionException {
        int i = 0;
        for ( ;; i++ ) {
            AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext( AppConfig.class );
            AsyncService asyncService = applicationContext.getBean( AsyncService.class );

            String calleeThreadName = asyncService.doAsyncWork().get();
            String callerThreadName = Thread.currentThread().getName();
            boolean areThreadsTheSame = calleeThreadName.equals( callerThreadName );
            logger.info( "{} calleeThreadName is {}, callerThreadName is {}, areThreadsTheSame: {}", i, calleeThreadName, callerThreadName, areThreadsTheSame );
            applicationContext.close();
        }
    }

    private static Logger logger = LoggerFactory.getLogger( LeakMain.class );

}
