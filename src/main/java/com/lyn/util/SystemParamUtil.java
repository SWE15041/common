package com.lyn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 1.创建资源文件，放置在类路径下，文件名：system.properties
 * 2.系统参数初始化：SystemParamUtil.init()
 * 3.调用
 *
 * @author lyn
 */

public class SystemParamUtil {

    /**
     * 系统参数缓存
     */
    private CacheDataModel systemCache = new CacheDataModel();

    private Properties props = null;

    private static SystemParamUtil instance = null;

    /**
     * web目录的绝对地址(暂时不使用)
     */
    public static final String WEBCONTEXT_REAL_PATH = "webContextRealPath";

    /**
     * web上下文(暂时不使用)
     */
    public static final String WEBCONTEXT_PATH = "webContextPath";

    /**
     * 系统资源存放文件，默认放在类路径下
     */
    private final static String DEFAULT_SYSTEM_PROPERTIES = "system.properties";

    /**
     * 系统数据缓存初始化
     */
    public static void init() {
        if (instance == null) {
            synchronized (SystemParamUtil.class) {
                System.out.println("系统数据持有类初始化...");
                Properties props = getSystemConfProps();
                instance = new SystemParamUtil(props);
                instance.initParameters(props);
                System.out.println("系统数据持有类初始化[OK]");
            }
        }
    }

    private static SystemParamUtil getInstance() {
        if (instance == null) {
            init();
        }
        return instance;
    }

    public SystemParamUtil(Properties props) {
        initParameters(props);
    }

    private void initParameters(Properties props) {
        this.props = props;
    }


    public static Properties getSystemConfProps() {
        System.out.println("system.properties系统配置读取开始...");
        InputStream inputStream = null;
        Properties sysConf = new Properties();
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_SYSTEM_PROPERTIES);
            if (inputStream != null) {
                sysConf.load(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("system.properties系统配置读取[OK]");
        return sysConf;
    }

    /**
     * 为什么要指定数据类型
     *
     * @param paramKey
     * @param requiredType
     * @param <T>
     * @return
     */
    public <T> T getSystemParam(String paramKey, Class<T> requiredType) {
        Object paramValue = getSystemParam(paramKey);
        if (paramValue != null) {
            if (paramValue instanceof String) {
                return StringUtil.cast((String) paramValue, requiredType);
            } else {
                return requiredType.cast(paramValue);
            }
        } else {
            return null;
        }
    }

    public Object getSystemParam(String paramKey) {
        Object paramValue = this.systemCache.get(paramKey);
        if (paramValue == null) {
            String isoParamValue = props.getProperty(paramKey);
            if (StringUtil.isNotBlank(isoParamValue)) {
                paramValue = EncodeUtil.convertStrEncode(isoParamValue, EncodeUtil.ISO_8859_1, EncodeUtil.UTF_8);
            }

        }
        return paramValue;
    }

    public void setSystemParam(String paramKey, Object paramValue) {
        this.systemCache.add(paramKey, paramValue);
    }

    public static void setParam(String paramKey, Object paramValue) {
        getInstance().setSystemParam(paramKey, paramValue);
    }


    public static <T> T getParam(String paramKey, Class<T> clazz) {
        return getInstance().getSystemParam(paramKey, clazz);
    }

}

class CacheDataModel {

    private Map<String, Object> cacheMap = new HashMap<>();

    public Object get(String key) {
        return cacheMap.get(key);
    }

    public void add(String key, Object value) {
        cacheMap.remove(key);
        cacheMap.put(key, value);
    }

}

