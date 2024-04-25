package com.mehkey.springbootgrpc;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

import java.util.*;

@GRpcService
public class Service  extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request,
                      StreamObserver<HelloResponse> responseObserver) {
        String message = "Hello " + request.getFirstName() + " " + request.getLastName();
        
        

        responseObserver.onNext(HelloResponse.newBuilder()
                .setGreeting(message)
                .build());
        responseObserver.onCompleted();
        System.out.println("HelloService: response message: " + message);
    }
}
