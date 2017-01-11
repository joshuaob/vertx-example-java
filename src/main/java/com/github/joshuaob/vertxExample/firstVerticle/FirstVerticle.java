package com.github.joshuaob.vertxExample.firstVerticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class FirstVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        vertx
            .createHttpServer()
            .requestHandler(r -> {
                r.response().end("<h1>Hello from my first " +
                    "Vert.x 3 application</h1>");
            })
            .listen(
            // retrieve the port from the configuration
            // default to 8080
            config().getInteger("http.port", 8080),
            result -> {
                if(result.succeeded()) {
                    fut.complete();
                } else {
                    fut.fail(result.cause());
                }
        });
    }

}
