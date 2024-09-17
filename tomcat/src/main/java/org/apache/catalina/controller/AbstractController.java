package org.apache.catalina.controller;

import org.apache.catalina.session.SessionManager;
import org.apache.coyote.http11.request.Request;
import org.apache.coyote.http11.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController implements Controller {

    protected static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    protected final SessionManager sessionManager;

    protected AbstractController() {
        this.sessionManager = SessionManager.getInstance();;
    }

    @Override
    public void service(Request request, Response response) throws Exception {
        if (request.hasGetMethod()) {
            doGet(request, response);
        }
        if (request.hasPostMethod()) {
            doPost(request, response);
        }
    }

    abstract protected void doGet(Request request, Response response) throws Exception;

    abstract protected void doPost(Request request, Response response) throws Exception;
}
