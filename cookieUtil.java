package com.travelsky.pssgui.util;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
/**
 * CookieUtil.java
 *
 * @author chenqian
 * @date 2017/3/8
 */

public class CookieUtil {
    /**
     * 设置HttpOnly Cookie
     * @param response HTTP响应
     * @param cookie Cookie对象
     * @param isHttpOnly 是否为HttpOnly
     */
    public static void addCookie(HttpServletResponse response, Cookie cookie, boolean isHttpOnly) {
        String name = cookie.getName();//Cookie名称
        String value = cookie.getValue();//Cookie值
        int maxAge = cookie.getMaxAge();//最大生存时间(毫秒,0代表删除,-1代表与浏览器会话一致)
        String path = cookie.getPath();//路径
        String domain = cookie.getDomain();//域
        boolean isSecure = cookie.getSecure();//是否为安全协议信息

        StringBuilder buffer = new StringBuilder();

        buffer.append(name).append("=").append(value).append(";");

        if (maxAge > 0) {
            buffer.append("Max-Age=").append(maxAge).append(";");
        }

        if (domain != null) {
            buffer.append("domain=").append(domain).append(";");
        }

        if (path != null) {
            buffer.append("path=").append(path).append(";");
        }

        if (isSecure) {
            buffer.append("secure;");
        }

        if (isHttpOnly) {
            buffer.append("HttpOnly;");
        }

        response.addHeader("Set-Cookie", buffer.toString());
    }
}
