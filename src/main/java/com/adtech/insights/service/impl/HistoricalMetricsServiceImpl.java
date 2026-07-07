package com.adtech.insights.service.impl;

import com.adtech.insights.exception.CampaignNotFoundException;
import com.adtech.insights.model.ClickCountResponse;
import com.adtech.insights.model.HistoricalCampaignMetrics;
import com.adtech.insights.service.HistoricalMetricsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class HistoricalMetricsServiceImpl
        implements HistoricalMetricsService {

    private final List<HistoricalCampaignMetrics> historicalMetrics;

    public HistoricalMetricsServiceImpl(ObjectMapper mapper)
            throws IOException {

        InputStream inputStream = getClass()
                .getResourceAsStream("/historical-data.json");

        historicalMetrics = Arrays.asList(
                mapper.readValue(
                        inputStream,
                        HistoricalCampaignMetrics[].class));
    }

    @Override
    public ClickCountResponse getClicks(
            String tenantId,
            String campaignId, LocalDate from, LocalDate to) {

        HistoricalCampaignMetrics metric =
                historicalMetrics.stream()
                        .filter(m ->
                                m.tenantId().equals(tenantId)
                                        && m.campaignId().equals(campaignId))
                        .findFirst()
                        .orElseThrow(() ->
                                new CampaignNotFoundException(
                                        tenantId,
                                        campaignId));

        return new ClickCountResponse(
                campaignId,
                metric.clicks(),
                "HISTORICAL");
    }
}