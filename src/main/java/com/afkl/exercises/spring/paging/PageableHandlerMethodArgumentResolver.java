package com.afkl.exercises.spring.paging;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Optional;

public class PageableHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Pageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        final int page = Optional.ofNullable(nativeWebRequest.getParameter("page"))
                .map(p -> Math.abs(Integer.parseInt(p))).orElse(1);
        final int size = Optional.ofNullable(nativeWebRequest.getParameter("size"))
                .map(s -> Math.abs(Integer.parseInt(s))).orElse(25);
        return new Pageable(page, size);
    }

}
