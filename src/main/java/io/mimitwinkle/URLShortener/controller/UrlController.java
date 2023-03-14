package io.mimitwinkle.URLShortener.controller;

import io.mimitwinkle.URLShortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("url/shortener")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/{id}")
    public String getOriginalUrl(@PathVariable String id) {
        return urlService.getOriginalUrl(id);
    }

    @PostMapping
    public String generateShortUrl(@RequestBody String url) {
        return urlService.generateShortUrl();
    }
}
