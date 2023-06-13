package kr.or.ddit.Controller.intercept;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AccessLoggingInterceptor extends HandlerInterceptorAdapter {

	PrintWriter writer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle...!");
		File file = new File("c:/logs/ddit_loggin.log");
		writer = new PrintWriter(new FileWriter(file, true), true);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String requestURI = request.getRequestURI();
		log.info("requestURI : " + requestURI);
		
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		
		Class clazz = method.getDeclaringClass();			// class kr.or.ddit.Controller.BoardController 같은 것
		
		String className = clazz.getName();					// kr.or.ddit.Controller.BoardController 같은 것
		String classSimpleName = clazz.getSimpleName();		// BoardController 같은 것
		String methodName = method.getName();				// boardList 와 같은 메서드
		
		writer.printf("현재일시 : %s %n", getCurrentTime());
		writer.printf("Access Controller : %s %n", className + "." + methodName);
	}
	
	public String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(cal.getTime());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
