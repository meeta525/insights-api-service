package com.adtech.insights.entity;

import java.io.Serializable;

import lombok.*;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@PrimaryKeyClass
public class CampaignMetricsKey implements Serializable {

    @PrimaryKeyColumn(
            name = "tenant_id",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED)
    private String tenantId;

    @PrimaryKeyColumn(
            name = "campaign_id",
            ordinal = 1,
            type = PrimaryKeyType.CLUSTERED)
    private String campaignId;
}