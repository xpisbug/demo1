package com.example.smdemo1.aop;

import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.Date;

import com.example.smdemo1.annoation.OperLog;
import com.example.smdemo1.dao.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author xp-dc
 * @date 2018/12/26
 */
@Aspect
@Component
public class OperationLogAop {
	//获取开始时间
	private Date actionStartDate;
	//获取结束时间
	private Date actionEndDate;
	//定义log实体
	private Log log = new Log();

	//@Pointcut("execution(* com.example.smdemo1.controller.*.*(..))")
	@Pointcut("@annotation(com.example.smdemo1.annoation.OperLog)")
	//@Pointcut("@annotation(com.example.smdemo1.annoation.Log)")
	private void controllerAspect(){}

	/**
	 * 方法开始执行
	 */
	@Before("controllerAspect()")
	public void doBefore(){
		actionStartDate = new Date();
		System.out.println("开始："+actionStartDate);
	}

	/**
	 * 方法执行结束
	 */
	@After("controllerAspect()")
	public void after(JoinPoint pjp){
		//拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		//拦截的放参数类型
		Signature signature = pjp.getSignature();
		//拦截的方法名称，就是当前执行的方法
		String methodName = signature.getName();
		//拦截的方法参数
		Object[] args = pjp.getArgs();
		MethodSignature msig = null;
		if(!(signature instanceof MethodSignature)){
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature) signature;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();
		Object object = null;
		Method method = null;

		try{
			method = target.getClass().getMethod(methodName, parameterTypes);
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}catch(SecurityException e1){
			e1.printStackTrace();
		}

		if(null != method){
			//判断是否包含自定义的注解
			if(method.isAnnotationPresent(OperLog.class)){
				OperLog operLog = method.getAnnotation(OperLog.class);
				log.setModule(operLog.module());
			}
		}
		actionEndDate = new Date();
		System.out.println("结束："+actionEndDate);
	}

	/**
	 * 方法执行结束后的操作
	 */
	@AfterReturning("controllerAspect()")
	public void doAfter(JoinPoint pjp) {
		//拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		//拦截的放参数类型
		Signature signature = pjp.getSignature();
		//拦截的方法名称，就是当前执行的方法
		String methodName = signature.getName();
		//拦截的方法参数
		Object[] args = pjp.getArgs();
		MethodSignature msig = null;
		if(!(signature instanceof MethodSignature)){
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature) signature;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();
		Object object = null;
		Method method = null;

		try{
			method = target.getClass().getMethod(methodName, parameterTypes);
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}catch(SecurityException e1){
			e1.printStackTrace();
		}

		if(null != method){
			//判断是否包含自定义的注解
			if(method.isAnnotationPresent(OperLog.class)){
				OperLog operLog = method.getAnnotation(OperLog.class);
				log.setModule(operLog.module());
			}
		}

		if(log.getState() >= 0){
			log.setActionStartDate(actionStartDate);
			log.setActionEndDate(actionEndDate);
			System.out.println(log);
			System.out.println(">>>>>>>>>>>>>存入log数据库");
		}else{
			System.out.println(log);
			System.out.println("<<<<<<<<<<<<<<不存入log数据库");
		}

	}

	/**
	 * 方法有异常操作
	 */
	@AfterThrowing("controllerAspect()")
	public void doAfterThrow(){
		if(log.getState() == 2){
			log.setActionStartDate(actionStartDate);
			log.setActionEndDate(actionEndDate);
			System.out.println(log);
			System.out.println(">>>>>>>>>>>>>存入log数据库");
		}else{
			System.out.println(log);
			System.out.println("<<<<<<<<<<<<<<不存入log数据库");
		}
	}

	@Around("controllerAspect()")
	public Object around(ProceedingJoinPoint pjp){
		//日志实体对象
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		//获取当前登录用户信息
		//todo
		//String userName = null;

		//拦截的实体类，就是当前正在执行的controller
		Object target = pjp.getTarget();
		//拦截的放参数类型
		Signature signature = pjp.getSignature();
		//拦截的方法名称，就是当前执行的方法
		String methodName = signature.getName();
		//拦截的方法参数
		Object[] args = pjp.getArgs();
		MethodSignature msig = null;
		if(!(signature instanceof MethodSignature)){
			throw new IllegalArgumentException("该注解只能用于方法");
		}
		msig = (MethodSignature)signature;
		Class[] parameterTypes = msig.getMethod().getParameterTypes();
		Object object = null;
		Method method = null;

		try{
			method = target.getClass().getMethod(methodName, parameterTypes);
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}catch(SecurityException e1){
			e1.printStackTrace();
		}

		if(null != method){
			//判断是否包含自定义的注解
			if(method.isAnnotationPresent(OperLog.class)){
				OperLog operLog = method.getAnnotation(OperLog.class);
				log.setModule(operLog.module());
				log.setMethod(operLog.method());
				log.setIp(getIp(request));
				log.setUrl(request.getRequestURI());

				try{
					object = pjp.proceed();
					log.setDesc("执行成功");
					log.setState(0);
				}catch(Throwable e){
					log.setDesc("执行失败");
					log.setState(1);
				}
			}else{
				//没有包含注解
				try{
					object = pjp.proceed();
					log.setDesc("此操作不包含注解,执行成功");
					log.setState(0);
				}catch(Throwable e){
					log.setDesc("此操作不包含注解,执行失败");
					log.setState(1);
				}
			}
		}else{
			//不需要拦截直接执行
			try{
				object = pjp.proceed();
				log.setDesc("不需要拦截直接执行,执行成功");
				log.setState(0);
			}catch(Throwable e){
				log.setDesc("不需要拦截直接执行,执行失败");
				log.setState(1);
			}
		}
		return object;
	}


	private String getIp(HttpServletRequest request){
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
