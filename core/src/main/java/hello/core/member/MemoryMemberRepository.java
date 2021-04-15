package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yjjung
 * @version 0.1.0
 * @since 2021/03/18
 */
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(final Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(final Long memberId) {
        return store.get(memberId);
    }

}
