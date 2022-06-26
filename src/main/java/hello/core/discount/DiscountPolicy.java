package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * 
     * @param member 사용자
     * @param price 가격
     * @return 항인 대상 금액
      */
    int discount(Member member, int price);
}
