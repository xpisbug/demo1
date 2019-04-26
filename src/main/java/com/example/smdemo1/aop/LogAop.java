package com.example.smdemo1.aop;

import com.example.smdemo1.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xp-dc
 * @date 2018/12/25
 */

@Component
@Aspect
public class LogAop {

	//两个..代表所有子目录，最后括号里的两个..代表所有参数
	//@Pointcut("execution(* com.example.smdemo1.service.*.*(..))")
	@Pointcut("@annotation(com.example.smdemo1.annoation.LogDu)")
	private void pointCutMethod(){

	}

	//声明前置通知
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint joinPoint){
		System.out.println("前置通知");//3
		Object[] objs = joinPoint.getArgs();
		System.out.println(joinPoint.getKind());
		System.out.println(joinPoint.getSourceLocation());
		System.out.println(joinPoint.getStaticPart().getSignature());
		System.out.println(joinPoint);
		System.out.println(joinPoint.getTarget().getClass().getName());
		if(null == objs || objs.length == 0){
			return;
		}
		for(Object obj : objs){
			System.out.println("--------------------------");
			System.out.println(obj);
			System.out.println("--------------------------");
		}
		System.out.println();
	}

	//后置通知，包括异常
	@After("pointCutMethod()")
	public void doAfter(){
		System.out.println("后置通知，包括异常");
	}

	//声明例外通知
	@AfterThrowing(pointcut="pointCutMethod()",throwing = "e")
	public void doAfterThrowing(Exception e){
		System.out.println("例外通知(异常)");
	}

	//声明后置通知
	@AfterReturning(pointcut="pointCutMethod()",returning="result")
	public void doAfterReturning(Object result){
		System.out.println("后置通知，连接点完成，不包括异常： " + result);
	}

	//声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("进入方法---环绕通知");//1
		System.out.println(pjp.getTarget().getClass().getName());//2
		Object o = pjp.proceed();
		System.out.println("退出方法---环绕通知");//4
		return o;
	}

}
