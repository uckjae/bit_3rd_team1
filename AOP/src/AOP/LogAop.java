package AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //Aspect 역할을 할 클래스라고 명시
public class LogAop {
	
	//Pointcut의 속성에 핵심코드의 어느 부분까지 공통 기능을 사용하겠다고 명시함
	@Pointcut("within(AOP.*)") //어느 부분에 횡단 관심 모듈을 삽입할 것인지 정의 -> 메소드에 삽입함
	private void pointcutMethod() {}
	
	@Around("pointcutMethod()") //around가 적용될 포인트컷을 명시
	public Object loggerAop(ProceedingJoinPoint joinpoint) {
		
		//@Around에서 매개 변수로 ProceedingJoinPoint객체를 받음
		//ProceedingJoinPoint는 핵심 관심 모듈에 대한 정보를 가지고 있으며
		//@Around 내부에서는 before와 after를 나누는 기준이 됨
		
		//공통 기능이 적용되는 메소드가 어떤 메소드인지 출력하기 위해 메소드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + "메소드 시작"); //메소드 실행
		
		System.out.println("핵심 기능 전에 실행 할 공통 기능"+System.currentTimeMillis());
		
		Object obj = null;
		try {
			obj = joinpoint.proceed();//핵심 기능 실행
			
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			//공통 기능
			System.out.println("핵심 기능 후에 실행 할 공통 기능"+System.currentTimeMillis());
			System.out.println(signatureStr + "끝");
		}
		return obj;		
	}
	
	@Before("within(AOP.*)")
	public void beforeMethod() {
		System.out.println("beforeMethod() 실행");
	}
}
