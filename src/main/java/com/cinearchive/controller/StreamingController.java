package com.cinearchive.controller;

import com.cinearchive.controller.request.StreamingRequest;
import com.cinearchive.controller.response.StreamingResponse;
import com.cinearchive.entity.Streaming;
import com.cinearchive.mapper.StreamingMapper;
import com.cinearchive.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;

    @GetMapping
    public List<Streaming> getAllMovies() {
        return streamingService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<StreamingResponse> getStreamingById(@PathVariable Long id) {
        Optional<Streaming>  streaming = streamingService.findById(id);
        if(streaming.isPresent()) return Optional.of(StreamingMapper.toResponse(streaming.get()));
        return Optional.empty();
    }

    @PostMapping
    public StreamingResponse addStreaming(@RequestBody StreamingRequest request) {
        Streaming streaming = streamingService.save(StreamingMapper.toStreaming(request));
        return StreamingMapper.toResponse(streaming);
    }

    @PutMapping("/{id}")
    public StreamingResponse updateStreaming(@RequestBody StreamingRequest request, @PathVariable Long id) {
        Streaming streaming = streamingService.save(StreamingMapper.toStreaming(request));
        return StreamingMapper.toResponse(streamingService.update(streaming, id));
    }

    @DeleteMapping("/{id}")
    public void deleteStreaming(@PathVariable Long id) {
        streamingService.deleteById(id);
    }
}
