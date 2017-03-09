/**
 * 
 */
package com.doj.aopapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh.Rajput
 *
 */
@Aspect
@Component
public class LoggingAspect {
	
	/**
	 * Declaring After Throwing advice 
	 * @param jp
	 * @throws Throwable
	 */
	//@AfterThrowing("execution(* com.doj.aopapp.service.*.*(..))") // After Throwing advice with pointcut expression directly
	@AfterThrowing("logForAllMethods()") //After Throwing advice with name pointcut that declared as name logForAllMethods()
	public void afterThrowingAdviceForAllMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForAllMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring After Throwing advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@AfterThrowing("execution(* com.doj.aopapp.service.*.transfer(*,*,*))")
	public void afterThrowingAdviceForTransferMethods(JoinPoint jp) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForTransferMethods() " + jp.getSignature().getName());
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.doj.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
