package com.cinearchive.controller;

import com.cinearchive.entity.Streaming;
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
    public Optional<Streaming> getStreamingById(@PathVariable Long id) {
        return streamingService.findById(id);
    }

    @PostMapping
    public Streaming addStreaming(@RequestBody Streaming streaming) {
        return streamingService.save(streaming);
    }

    @PutMapping("/{id}")
    public Streaming updateStreaming(@RequestBody Streaming streaming, @PathVariable Long id) {
        return streamingService.update(streaming, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStreaming(@PathVariable Long id) {
        streamingService.deleteById(id);
    }
}
