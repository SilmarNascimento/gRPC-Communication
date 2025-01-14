package org.example.service;

import io.grpc.stub.StreamObserver;
import proto.GRPC.CommunicationRequest;
import proto.GRPC.CommunicationReply;
import proto.GreeterGrpc;

public class ServerProtoImplementation extends GreeterGrpc.GreeterImplBase {
  /*
   * We observe here that some words have an @, these are Annotations.
   * Annotations are used to provide supplement information about a program. We can autogenerate this functions,
   * in Intellij we can use the shortcut ctrl + O to do this.
   * */
  @Override
  public void sayHello(CommunicationRequest request, StreamObserver<CommunicationReply> responseObserver) {
    /* Build a response composed with the constant Hello and the name variable from the request.
     * For example, if the request is: gRPC the reply will be: "Hello gRPC".
     */
    CommunicationReply reply = CommunicationReply.newBuilder().setMessage("Hello " + request.getName()).build();
    responseObserver.onNext(reply);
    /* We use the response observer's onCompleted method to specify that we've finished dealing with the RPC */
    responseObserver.onCompleted();
  }
}