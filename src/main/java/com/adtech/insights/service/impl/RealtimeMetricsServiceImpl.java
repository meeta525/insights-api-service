package com.adtech.insights.service.impl;

import com.adtech.insights.entity.CampaignMetrics;
import com.adtech.insights.exception.CampaignNotFoundException;
import com.adtech.insights.exception.RealtimeServiceUnavailableException;
import com.adtech.insights.model.ClickCountResponse;
import com.adtech.insights.repository.CampaignMetricsRepository;
import com.adtech.insights.service.RealtimeMetricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@RequiredArgsConstructor
public class RealtimeMetricsServiceImpl implements RealtimeMetricsService {

    private final CampaignMetricsRepository repository;

    @Override
    @Retry(name = "cassandraRetry")
    public ClickCountResponse getClicks(
            String tenantId,
            String campaignId) {

        CampaignMetrics metrics = repository
                .findByKeyTenantIdAndKeyCampaignId(
                        tenantId,
                        campaignId)
                .orElseThrow(() ->
                        new CampaignNotFoundException(
                                tenantId,
                                campaignId));

        return new ClickCountResponse(
                campaignId,
                metrics.getClicks(),
                "REALTIME");
    }
}