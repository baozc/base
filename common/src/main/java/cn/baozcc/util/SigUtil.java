package cn.baozcc.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cn.baozcc.me.annotation.UUID;
import cn.baozcc.me.annotation.Sig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * sig加密工具类
 * @author baozc
 *
 */
public class SigUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SigUtil.class);
	
	public static String me_client_sig_key="$tr34@3wFG5^&w";

    public static <T> String generateSig(T entity) throws IllegalAccessException, UnsupportedEncodingException, InvocationTargetException {
        GenerateSig generateSig = new GenerateSig<T>(entity).invoke();
        return generateSig.getSig();
    }

	/**
	 * 根据@sig注解，自动校验 signature
	 * @param entity
	 * @return  true/false
	 * @author baozc
	 * @date 2019年08月07日 15:27:25
	 */
    public static <T> boolean checkSig(T entity) throws IllegalAccessException, UnsupportedEncodingException, InvocationTargetException {

        GenerateSig generateSig = new GenerateSig<T>(entity).invoke();
        Object oldSig = generateSig.getOldSig();
        Object uuid = generateSig.getUuid();
        String sig = generateSig.getSig();

        logger.info("{}, oldsig:{} newsig:{}", uuid, oldSig, sig);

        return sig.toUpperCase().equals(oldSig.toString().toUpperCase());
    }

    @SuppressWarnings("unused")
    public static String getSig(List<String> paramList, String client_secret) {
		String sigStr;
		Collections.sort(paramList);
		StringBuilder bf = new StringBuilder();
		for (String param : paramList) {
			bf.append(param); // 将参数键值对，以字典序升序排列后，拼接在一起
		}
		bf.append(client_secret); // 符串末尾追加上应用的Secret Key
		logger.info("sigStr:"+bf.toString());
		sigStr = DigestUtils.md5DigestAsHex(bf.toString().getBytes());

		return sigStr;
    } 

	public static String getSig(List<String> paramList) throws UnsupportedEncodingException {
		String sigStr = null;
		Collections.sort(paramList);
		StringBuilder bf = new StringBuilder();
		for (String param : paramList) {
		    logger.warn("param: {}", param);
			bf.append(param); // 将参数键值对，以字典序升序排列后，拼接在一起
		}
        bf.append(me_client_sig_key);

		logger.warn(bf.toString());
		// sigStr = DigestUtils.md5Hex(URLEncoder.encode(bf.toString(),"UTF-8"));
		return sigStr;
    }

    /**
	 * 验证手机端sig
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unused")
    public static  String sig(String... params){
		StringBuilder strBuffer = new StringBuilder();
		if(params!=null){
			List<String> list = new ArrayList<String>();
            Collections.addAll(list, params);
			Collections.sort(list);
			StringBuilder bf = new StringBuilder();
			for (String param : list) {
				bf.append(param);
			}
			bf.append(me_client_sig_key);

			try {
				System.out.println(URLEncoder.encode(bf.toString(),"UTF-8"));
				// strBuffer.append(DigestUtils.md5Hex(URLEncoder.encode(bf.toString(),"UTF-8")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strBuffer.toString();
	}


    private static class GenerateSig<T> {
        private T entity;
        private Object oldSig;
        private Object uuid;
        private String sig;

        public GenerateSig(T entity) {
            this.entity = entity;
        }

        public Object getOldSig() {
            return oldSig;
        }

        public Object getUuid() {
            return uuid;
        }

        public String getSig() {
            return sig;
        }

        public GenerateSig invoke() throws IllegalAccessException, InvocationTargetException, UnsupportedEncodingException {
            List<String> paramList = new ArrayList<>();
            oldSig = null;
            uuid = null;

            @SuppressWarnings("unchecked")
            Class<?> tClass = entity.getClass();

            while (tClass != null && !tClass.getName().toLowerCase().equals("java.lang.Object")) {

                Field[] fields = tClass.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Sig.class)) {

                        field.setAccessible(true);

                        Sig $sig =field.getAnnotation(Sig.class);

                        if ($sig.isSig()) {
                            oldSig = field.get(entity);
                            continue;
                        }

                        String fieldName = $sig.value();
                        if (StringUtils.isEmpty(fieldName)) {
                            fieldName = field.getName();
                        }

                        Object fieldValue = field.get(entity);

                        paramList.add(fieldName + "=" + fieldValue);
                    }
                }

                Method[] methods = tClass.getDeclaredMethods();
                for (Method method : methods) {

                    if (method.isAnnotationPresent(Sig.class)) {

                        method.setAccessible(true);

                        Sig $sig =method.getAnnotation(Sig.class);

                        if ($sig.isSig()) {
                            oldSig = method.invoke(entity);
                            continue;
                        }

                        String fieldName = $sig.value();
                        if (StringUtils.isEmpty(fieldName)) {

                            String methodName = method.getName();
                            fieldName = methodName.substring(3);

                            fieldName = fieldName.substring(0, 1).toLowerCase() +
                                    fieldName.substring(1);
                        }
                        Object fieldValue = method.invoke(entity);

                        paramList.add(fieldName + "=" + fieldValue);

                    } else if (method.isAnnotationPresent(UUID.class)) {
                        method.setAccessible(true);
                        uuid = method.invoke(entity);
                    }
                }
                tClass = tClass.getSuperclass();
            }

            sig = SigUtil.getSig(paramList);
            return this;
        }
    }
}

