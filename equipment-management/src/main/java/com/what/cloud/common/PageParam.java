/*
 *  WHAT Confidential
 * OCO Source Materials
 * WHAT Equipment Management
 * © Copyright WanHe Advanced Technology Ltd. 2018
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the P.R.China Copyright Office
 */

package com.what.cloud.common;

public class PageParam {
    /**
     * @Fields curr : 请求的页码
     */
    private String curr;
    /**
     * @Fields limit : 每页允许最大记录数
     */
    private String limit;

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

}
