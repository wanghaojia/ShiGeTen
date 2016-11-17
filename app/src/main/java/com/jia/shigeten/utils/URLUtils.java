package com.jia.shigeten.utils;

/**
 * URL地址工具类
 * Created by JIA on 2016/11/15.
 */

public class URLUtils {

    public static final String BASE_URL = "http://api.shigeten.net/";
    private static final String API_URL = BASE_URL + "api/";

    private static final String CRITIC_URL = API_URL + "Critic/";
    public static final String CRITIC_LIST_URL = CRITIC_URL + "GetCriticList";
    public static final String CRITIC_CONTENT_URL = CRITIC_URL + "GetCriticContent";

    private static final String NOVEL_URL = API_URL + "Novel/";
    public static final String NOVEL_LIST_URL = NOVEL_URL + "GetNovelList";
    public static final String NOVEL_CONTENT_URL = NOVEL_URL + "GetNovelContent";

    private static final String DIAGRAM_URL = API_URL + "Diagram/";
    public static final String DIAGRAM_LIST_URL = DIAGRAM_URL + "GetDiagramList";
    public static final String DIAGRAM_CONTENT_URL = DIAGRAM_URL + "GetDiagramContent";

    /**
     * 根据类型返回url
     * @param type
     * @param isList
     * @return
     */
    public static String getUrl(int type,boolean isList){
        if (isList){
            if (type == Utils.CRITIC_TYPE) return CRITIC_LIST_URL;
            if (type == Utils.CRITIC_TYPE) return CRITIC_LIST_URL;
            if (type == Utils.CRITIC_TYPE) return CRITIC_LIST_URL;
        }
        return null;
    }
}
