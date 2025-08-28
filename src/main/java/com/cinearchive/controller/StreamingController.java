package com.cinearchive.controller;

import com.cinearchive.controller.request.StreamingRequest;
import com.cinearchive.controller.response.StreamingResponse;
import com.cinearchive.entity.Streaming;
import com.cinearchive.mapper.StreamingMapper;
import com.cinearchive.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAllMovies() {
        List<StreamingResponse> streamingResponses = streamingService.findAll().stream()
                .map(StreamingMapper::toResponse)
                .toList();
        return ResponseEntity.ok(streamingResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> getStreamingById(@PathVariable Long id) {
        return streamingService.findById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> addStreaming(@Valid@RequestBody StreamingRequest request) {
        Streaming streaming = streamingService.save(StreamingMapper.toStreaming(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toResponse(streaming));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamingResponse> updateStreaming(@Valid @RequestBody StreamingRequest request, @PathVariable Long id) {
        Streaming streaming = StreamingMapper.toStreaming(request);
        return ResponseEntity.ok(StreamingMapper.toResponse(streamingService.update(streaming, id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id) {
        streamingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}