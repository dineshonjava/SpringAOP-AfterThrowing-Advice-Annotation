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
	@AfterThrowing(pointcut = "logForAllMethods()" , throwing="exc") //After Throwing advice with name pointcut that declared as name logForAllMethods()
	public void afterThrowingAdviceForAllMethods(JoinPoint jp, Exception exc) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForAllMethods() " + jp.getSignature().getName() +" Exception: "+exc);
    }
	
	/**
	 * Declaring After Throwing advice for all transfer methods whose taking three arguments of any type 
	 * of all classes in the package com.doj.aopapp.service
	 * @param jp
	 * @throws Throwable
	 */
	@AfterThrowing(pointcut = "execution(* com.doj.aopapp.service.*.transfer(*,*,*))", throwing="exc")
	public void afterThrowingAdviceForTransferMethods(JoinPoint jp, Exception exc) throws Throwable {
        System.out.println("****LoggingAspect.afterThrowingAdviceForTransferMethods() " + jp.getSignature().getName() +" Exception: "+exc);
    }
	
	/**
	 * Declaring named pointcut
	 */
	@Pointcut("execution(* com.doj.aopapp.service.*.*(..))")
	public void logForAllMethods(){}
}
