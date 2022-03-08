package com.logicmonitor.resource.detectors.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import org.junit.jupiter.api.Test;

public class LMCommonResourceProviderTest {
  @Test
  public void whenProvidedValidCommonResourceThenReturnResourceWithTelemetrySDKName() {
    AttributesBuilder attrBuilders = Attributes.builder();
    String telemetrySdkName = "lm-opentelemetry";
    attrBuilders.put(ResourceAttributes.TELEMETRY_SDK_NAME, telemetrySdkName);
    Resource resources = Resource.create(attrBuilders.build(), ResourceAttributes.SCHEMA_URL);
    Resource lmResource = LMCommonResource.buildResource();
    assertEquals(resources, lmResource);
  }
}
