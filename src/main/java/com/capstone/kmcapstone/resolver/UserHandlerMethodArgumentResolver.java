package com.capstone.kmcapstone.resolver;


import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@Component
public class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory
    ) {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null)
            throw new IllegalArgumentException("사용자 정보가 존재하지 않습니다.");
        final UserInfo userInfo = (UserInfo) auth.getPrincipal();
        final LoginUser loginUser = parameter.getParameterAnnotation(LoginUser.class);

        if (loginUser == null || userInfo == null) {
            throw new IllegalArgumentException("사용자 정보가 존재하지 않습니다.");
        }

        return userInfo;
    }

    public void supportsParameter(@LoginUser UserInfo userInfo) {
    }
}
