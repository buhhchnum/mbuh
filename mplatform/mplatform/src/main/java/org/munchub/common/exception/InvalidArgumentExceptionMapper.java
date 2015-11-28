package org.munchub.common.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.munchub.common.beans.ErrorInfo;

public class InvalidArgumentExceptionMapper implements ExceptionMapper<InvalidArgumentException>{

	public Status getStatus()
	{
		return Status.BAD_REQUEST;
	}
	@Override
	public Response toResponse(InvalidArgumentException exception) {
		 ErrorInfo info = new ErrorInfo(exception);
	      return Response.status(getStatus()).entity(info).build();
	}



}
