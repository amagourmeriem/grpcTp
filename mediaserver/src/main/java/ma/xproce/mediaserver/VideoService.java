package ma.xproce.mediaserver;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.xproce.lab.*;
import org.xproce.lab.VideoServiceGrpc.VideoServiceImplBase;

@GrpcService
public class VideoService extends VideoServiceImplBase {

    @Override
    public void uploadVideo(UploadVideoRequest request, StreamObserver<Video> responseObserver) {
        super.uploadVideo(request, responseObserver);
        Video video = Video.newBuilder()
                .setTitle("video")
                .setDescription("description")
                .setUrl("http://exemple.com")
                .setDurationSeconds(5)
                .setCreator(
                        Creator.newBuilder()
                                .setEmail("email@email.com")
                                .setName("mehdi")
                                .build()
                )
                .build();
        responseObserver.onNext(video);
        responseObserver.onCompleted();
    }

    @Override
    public void getVideo(VideoIdRequest request, StreamObserver<Video> responseObserver) {
        super.getVideo(request, responseObserver);
    }
}
