package com.linweiyuan.chatgptapi.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class WebDriverAutoRefreshScheduler {
    private final WebDriver webDriver;

    public WebDriverAutoRefreshScheduler(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // refresh cookies every 3 minutes, to avoid cloudflare 403
    @Scheduled(fixedRate = 1000 * 60 * 3)
    public void runTask() {
        webDriver.navigate().refresh();
        log.info("active refresh: {}", LocalDateTime.now());
    }
}
