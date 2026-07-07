package com.adtech.insights.model;

public record ClickCountResponse(
        String campaignId,
        Long clicks,
        String source
) {
}