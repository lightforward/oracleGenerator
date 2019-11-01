/*
 *  WHAT Confidential
 * OCO Source Materials
 * WHAT Equipment Management
 * © Copyright WanHe Advanced Technology Ltd. 2018
 * The source code for this program is not published or otherwise divested of its trade secrets, irrespective of what has been deposited with the P.R.China Copyright Office
 */

package com.what.cloud.exception;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -1963689178920485227L;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
