package com.adtech.insights.controller;

import com.adtech.insights.constant.ApiConstants;
import com.adtech.insights.model.ClickCountResponse;
import com.adtech.insights.service.InsightsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/ad")
@RequiredArgsConstructor
public class AdInsightsController {

    private final InsightsService insightsService;



    @GetMapping("/{campaignId}/clicks")
    public ClickCountResponse getClicks(
            @RequestHeader(ApiConstants.TENANT_HEADER) String tenantId,
            @PathVariable String campaignId,
            @RequestParam(required = false) LocalDate from,
            @RequestParam(required = false) LocalDate to) {

        return insightsService.getClicks(
                tenantId,
                campaignId,
                from,
                to);
    }
}