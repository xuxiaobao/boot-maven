package com.spring.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.spring.user.pojo.User;

@Aspect
@Component
public class ControllerInterceptor {

	// and @annotation(org.springframework.web.bind.annotation.RequestMapping)
	@Before("execution(* com.spring.*.controller..*(..))")
	public void BeforeReturning(JoinPoint pjp) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		HttpServletResponse response = sra.getResponse();

		//Map<String, String[]> inputParamMap = request.getParameterMap();
		//String requestPath = request.getRequestURI();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("login");
		
		/*if(user == null){
			try {
				response.sendRedirect("/login");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}*/
	}

}
