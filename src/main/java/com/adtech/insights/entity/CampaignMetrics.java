package com.adtech.insights.entity;

import java.time.Instant;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table("campaign_metrics")
public class CampaignMetrics {

    @PrimaryKey
    private CampaignMetricsKey key;

    @Column("clicks")
    private Long clicks;

    @Column("impressions")
    private Long impressions;

    @Column("click_to_basket")
    private Long clickToBasket;

    @Column("last_updated")
    private Instant lastUpdated;
}