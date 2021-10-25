package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.user.dto.UserInfoDto;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BoardPageServiceImplTest {
//    @Autowired
//    private BoardDetailRepository repository;
//    @Autowired
//    private UserRepository userRepository;
//
//    @BeforeEach
//    @Test
//    void createUser(){
//        UserInfo userInfo = userRepository.findByEmail("test@naver.com").orElseGet(() -> UserInfo.builder().build() );
//        if (userInfo.getId() != null) {
//            UserInfoDto infoDto = new UserInfoDto();
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            infoDto.setPassword(encoder.encode("aske1234"));
//            userRepository.save(
//                    UserInfo.builder()
//                            .email("test@naver.com")
//                            .auth("ROLE_USER")
//                            .password(infoDto.getPassword())
//                            .nick_name("개발연구 재밌소!")
//                            .build()
//            );
//        }
//
//    }
//
//    @Test
//    void createBoardDetail() {
//        UserInfo userInfo = userRepository.findByEmail("test@naver.com").orElseGet(() -> UserInfo.builder().build() );
//
//        IntStream.range(0, 20).forEach(i -> {
//            repository.save(
//                    BoardPageInfo.builder()
//                            .writer(userInfo)
//                            .title("제목 : "+i)
//                            .contents("내용 : "+i)
//                            .isDeleted(false)
//                            .build()
//            );
//        });
//    }
}