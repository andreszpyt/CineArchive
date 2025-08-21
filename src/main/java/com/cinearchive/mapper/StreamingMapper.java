package com.cinearchive.mapper;

import com.cinearchive.controller.request.StreamingRequest;
import com.cinearchive.controller.response.StreamingResponse;
import com.cinearchive.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {
    public Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }

    public StreamingResponse toResponse(Streaming streaming) {
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
