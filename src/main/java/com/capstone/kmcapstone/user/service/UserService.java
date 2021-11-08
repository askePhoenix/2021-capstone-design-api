package com.capstone.kmcapstone.user.service;

import com.capstone.kmcapstone.user.dto.UserInfoDto;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }





    public Long save(UserInfoDto infoDto) {
        if (userRepository.findByEmail(infoDto.getEmail()).
                stream().findAny().isPresent()) {
            return -1L;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        infoDto.setPassword(encoder.encode(infoDto.getPassword()));

        final UserInfo userInfo = userRepository.save(
                UserInfo.builder()
                        .email(infoDto.getEmail())
                        .auth(infoDto.getAuth())
                        .password(infoDto.getPassword())
                        .nick_name(infoDto.getNick_name())
                        .build()
        );

        return userInfo.getId();
    }
}
