package com.mehkey.springbootgrpc;

import com.mehkey.springbootgrpc.HelloServiceGrpc.HelloServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
        
        HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloResponse helloResponse = stub
                .hello(HelloRequest.newBuilder().setFirstName("Mehh").setLastName("Key").build());
        System.out.println("Greeting: " + helloResponse.getGreeting());
    }
}
