/*
 *  WHAT Confidential
 * OCO Source Materials
 * WHAT Equipment Management
 * © Copyright WanHe Advanced Technology Ltd. 2018
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the P.R.China Copyright Office
 */

package com.what.cloud.common;

import com.what.cloud.exception.ApplicationException;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class ResponseWrapper<T> implements Serializable {

    private static final long serialVersionUID = -2057997441963343533L;

    private static final String DEF_SUCC_MSG = "操作成功";
    private static final String DEF_FAIL_MSG = "操作失败";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 增加请求时间
     *
     * @author chl
     * @date 2018/09/05 17:06
     */
    private String date = SIMPLE_DATE_FORMAT.format(System.currentTimeMillis());

    private boolean succ = true;
    private String msg;
    private T content;
    private final Map<String, Object> options = new HashMap<>();

    public static <T> ResponseWrapper<T> success(String msg, T object) {
        return new ResponseWrapper<>(true, msg, object);
    }

    public static <T> ResponseWrapper<T> success(T object) {
        return new ResponseWrapper<>(true, DEF_SUCC_MSG, object);
    }

    public static <T> ResponseWrapper<T> success(String msg) {
        return new ResponseWrapper<>(true, msg, null);
    }

    public static <T> ResponseWrapper<T> success() {
        return success(DEF_SUCC_MSG);
    }

    public static <T> ResponseWrapper<T> fail(String msg) {
        return new ResponseWrapper<>(false, msg, null);
    }

    public static <T> ResponseWrapper<T> fail() {
        return fail(DEF_FAIL_MSG);
    }

    public static <T> ResponseWrapper<T> fail(String msg, Exception e) {
        if (e instanceof ApplicationException
                || e instanceof IllegalArgumentException) {
            return new ResponseWrapper<>(false, e.getMessage(), null);
        } else {
            return fail(parseException2Str(e));
        }
    }

    public static <T> ResponseWrapper<T> fail(Exception e) {
        return fail(DEF_FAIL_MSG, e);
    }

    public ResponseWrapper(boolean succ) {
        this();
        this.succ = succ;
    }

    public ResponseWrapper(boolean succ, String msg) {
        this(succ);
        this.msg = msg;
    }

    public ResponseWrapper(boolean succ, String msg, T content) {
        this(succ, msg);
        this.content = content;
    }

    public ResponseWrapper addOption(String key, Object value) {
        options.put(key, value);
        return this;
    }

    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public <T> T getOptionValue(String key) {
        return (T) options.get(key);
    }

    public boolean hasValueInOption(String key) {
        return options.containsKey(key);
    }

    private static String parseException2Str(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

}
