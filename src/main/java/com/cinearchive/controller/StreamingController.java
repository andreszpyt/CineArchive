package com.cinearchive.controller;

import com.cinearchive.service.CategoryService;
import com.cinearchive.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streaming")
@RequiredArgsConstructor
public class StreamingController {
    private final StreamingService streamingService;
}
