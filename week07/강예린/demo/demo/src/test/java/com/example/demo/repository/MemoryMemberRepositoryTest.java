package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository= new MemoryMemberRepository();
    // 콜백 메소드- 하나의 메소드만 끝나도 일로 돌아옴


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member= new Member();
        member.setName("spring");
        repository.save(member);
        Member result= repository.findById(member.getId()).get();
       // Assertions.assertEquals(member, result);
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result= repository.findByName("spring1").get();
        Assertions.assertThat(member1).isEqualTo(result);

    }
    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result= repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
    }
    }

