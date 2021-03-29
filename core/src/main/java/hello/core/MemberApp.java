package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/19
 */
public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        final MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();
        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
