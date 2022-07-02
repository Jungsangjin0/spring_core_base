package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자 10000원 주문
//        statefulService1.order("userA", 10000);
        int userA = statefulService1.order2("userA", 10000);
        //ThreadB : B사용자 20000원 주문
//        statefulService2.order("userB", 20000);
        int userB = statefulService2.order2("userB", 20000);

        //ThreadA: 사용자A 주문 금액을 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + userA);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}