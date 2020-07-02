package cn.baozcc.me.common.aop;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import cn.baozcc.me.annotation.Sig;
import cn.baozcc.util.ConvertUtils;
import cn.baozcc.util.ReturnUtil;
import cn.baozcc.util.SigUtil;
import cn.baozcc.util.validator.ValidationResult;
import cn.baozcc.util.validator.ValidationUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 校验参数、sig、一些特殊的统一验证
 * @author baozhichao
 * @date 2018年3月12日 下午6:21:10
 */
@SuppressWarnings("unused")
@Aspect
@Component
@Order(2)
public class AspectCheckParamController {

	private static final Logger logger = LoggerFactory.getLogger(AspectCheckParamController.class);
	
	@Pointcut("execution(public * cn.baozcc.me.oa.controller.OaController.*(..))")
	public void oa(){}

	@Pointcut("execution(public * cn.baozcc.me.oa.controller.*.*(..))")
	public void allAttendance(){}

	@Pointcut("execution(public * cn.baozcc.me.oa.controller.AttendanceHistoryController.*(..))")
	public void attendanceHistory(){}

	@Pointcut("execution(public * cn.baozcc.me.oa.controller.OutSideCardController.*(..))")
	public void outSide(){}

	@Pointcut("execution(public * cn.baozcc.me.oa.controller.WorkLocationController.*(..))")
	public void worklocation(){}

	
	/**
	 * 通讯录 cloud 切面<br>
	 * 设置 appId<br>
	 * 修改返回值为 swagger
	 * @param joinPoint
	 * @throws Throwable 
	 * @auth baozhichao
	 * @date 2018年3月12日 下午6:18:34
	 */
	@Around(value="allAttendance()")
	public Object aroud(ProceedingJoinPoint joinPoint) throws Throwable{
		
		// Object[] args = changeParam(joinPoint);
        Object[] args = joinPoint.getArgs();

        Object obj = checkParam(args);

        if (obj != null) {
            return obj;
        }

        return joinPoint.proceed(args);
	}

	private Object checkParam(Object[] args) throws NoSuchMethodException, InvocationTargetException,
            IllegalAccessException, UnsupportedEncodingException {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String agent = request.getHeader("User-Agent");

        Object param = args[0];
        Class<?> tClass = param.getClass();

        Method osMethod = tClass.getMethod("setOs", String.class);
        osMethod.invoke(param, agent);

        ValidationResult validationResult = ValidationUtils.validateEntity(args[0]);
        if (validationResult.isHasErrors()) {

            logger.error("{}, msg: {}", validationResult);
            return ReturnUtil.getCardFailed(validationResult.getErrorMsg().toString());
        }

        if (!SigUtil.checkSig(param)) {
            return ReturnUtil.getCardFailed("sig is error", param);
        }

        Method getUid = tClass.getMethod("getUid");
        Method getUmobile = tClass.getMethod("getUmobile");

        boolean isCheckUserPhone = getUid.isAnnotationPresent(Sig.class) && getUmobile.isAnnotationPresent(Sig.class);

        if (isCheckUserPhone) {

            Method getUserPhone = tClass.getMethod("getUserPhone");
            Object userPhone = getUserPhone.invoke(param);

            if (StringUtils.isEmpty(userPhone)) {
                return ReturnUtil.getCardFailed("account or mobile is null", param);
            }
        }

        return null;
    }

    /**
     * 修改参数
     * @auth baozc
     * @date 2018年9月12日 下午5:42:55
     */
    private Object[] changeParam(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        logger.error("ip : {}, header: {}", request.getRemoteAddr(), request.getHeader("Authorization"));

        String agent = request.getHeader("User-Agent");
        Object[] args = joinPoint.getArgs();
        try {

            ValidationResult validationResult = ValidationUtils.validateEntity(args[0]);
            if (validationResult.isHasErrors()) {

                logger.error("{}, msg: {}", validationResult);

            }


        } catch (Exception e) {
            logger.error("chang param auth is error:{}",e.toString());
        }
        return args;
    }

    /**
	 * 修改返回值
	 * @param obj
	 * @return
	 * @throws Exception 
	 * @auth baozc
	 * @date 2018年9月13日 下午7:44:46
	 */
	@SuppressWarnings("unchecked")
	private Object changeReturnObj(Object obj) throws Exception {
		if(obj == null) {
            return null;
        }
		if(obj instanceof List){
        	List<Object> list = ConvertUtils.clone((List<Object>)obj);
        	logger.info("update after list response: {}\n", list);
        	return list;
        }else{
        	Object o = ConvertUtils.clone(obj);
        	logger.info("update after obj response: {}\n", o);
        	return o;
        }
	}

	@SuppressWarnings("unchecked")
    private Object changeReturnObjByPasm(Object obj) throws Exception {
		if(obj == null) {
            return null;
        }
		if(obj instanceof List){
        	List<Object> list = ConvertUtils.clone((List<Object>)obj,"pasm");
        	logger.debug("update after list response: {}\n", list);
        	return list;
        }else{
        	Object o = ConvertUtils.clone(obj,"pasm");
        	logger.debug("update after obj response: {}\n", o);
        	return o;
        }
	}

}
