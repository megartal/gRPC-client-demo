package au.com.brolly.grpcclientdemo;

import au.com.brolly.grpcserverdemo.UserDetail;
import au.com.brolly.grpcserverdemo.UserServiceGrpc;
import au.com.brolly.grpcserverdemo.user;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcClientDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GrpcClientDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 8070).usePlaintext(true).build();

        UserServiceGrpc.UserServiceBlockingStub response = UserServiceGrpc.newBlockingStub(chanel);

        response.createUser(UserDetail.newBuilder().setName("test").setAge(32).setEmail("test@gmail.com").build());


        System.out.println(response);
    }
}
