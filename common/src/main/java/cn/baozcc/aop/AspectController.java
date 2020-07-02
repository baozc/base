package cn.baozcc.aop;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 控制器日志切面
 * @author baozhichao
 * @date 2018年3月12日 下午6:21:10
 */
@Aspect
@Component
@Order(3)
public class AspectController {

	private static final Logger logger = LoggerFactory.getLogger(AspectController.class);
	
	private double stime;

    private String className;
	private String methodName;
	
	@Pointcut("execution(public * cn.baozcc.*.controller.*.*(..))")
	public void log(){}

	/**
	 * 进入controller方法前，输出参数
	 * @param joinPoint
	 * @auth baozhichao
	 * @date 2018年3月12日 下午6:18:34
	 */
	@Before("log()")
	public void befor(JoinPoint joinPoint) throws Exception{
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        
        String classType = joinPoint.getTarget().getClass().getName();    
        Class<?> clazz = Class.forName(classType);

        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (clazz) {
        	 className = clazz.getSimpleName();
             
             methodName = joinPoint.getSignature().getName();
		}
        
        //参数
        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();
        Class<?>[] paramTypes = ((CodeSignature)joinPoint.getSignature()).getParameterTypes();

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<paramValues.length; i++){
        	sb.append("\t").append(paramNames[i]).append(" : ").append(paramValues[i]).append("\t(").append(paramTypes[i].getSimpleName()).append(")").append("\n");
        }
        
        logger.info("\n\n className :\t{}\n methodName :\t{}\n action :\t{}\n params :{\n{} }\n"
        		, className, methodName, request.getMethod(), sb);
        
        stime = System.currentTimeMillis();
	}
	
    @After("log()")
    public void doAfter(){
    }
    
    @AfterThrowing("log()")
    public void throwss(){
    	
    }

    /**
     * 获取返回数据，记录时长
     * @param object 返回数据
     * @auth baozhichao
     * @date 2018年3月12日 下午6:20:26
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        if(object instanceof List) {
            if(((List)object).size() <= 5) {
                logger.info("response : {}",object);
            } else {
                logger.info("response : {}", ((List)object).subList(0,5));
            }
        } else {
            logger.info("response : {}",object);
        }
        double etime = System.currentTimeMillis();
  	    logger.info("{}.{} time consuming："+((etime -stime)/1000)+"s  \n", className, methodName);
    }
}
