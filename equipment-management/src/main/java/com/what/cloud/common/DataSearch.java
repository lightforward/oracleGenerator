/*
 *  WHAT Confidential
 * OCO Source Materials
 * WHAT Equipment Management
 * © Copyright WanHe Advanced Technology Ltd. 2018
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the P.R.China Copyright Office
 */

package com.what.cloud.common;

public class DataSearch implements java.io.Serializable {

    private static final long serialVersionUID = 2L;

    //条件类型
    private String groupOp;

    private rule[] rules;

    public String getGroupOp() {
        return groupOp;
    }

    public void setGroupOp(String groupOp) {
        this.groupOp = groupOp;
    }

    public rule[] getRules() {
        return rules;
    }

    public void setRules(rule[] rules) {
        this.rules = rules;
    }

    public static class rule implements java.io.Serializable {
        private static final long serialVersionUID = -1260040538394529415L;

        private String field;
        private String op;
        private String data;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getOp() {
            return op;
        }

        public void setOp(String op) {
            this.op = op;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
} 