/*
 * Copyright (c) 2022-present CloudPivot Authors. All Rights Reserved.
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cloudpivot.starter.ratelimiter.autoconfigure;

import jakarta.annotation.PostConstruct;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import com.cloudpivot.starter.cache.redisson.autoconfigure.RedissonAutoConfiguration;
import com.cloudpivot.starter.core.constant.PropertiesConstants;
import com.cloudpivot.starter.ratelimiter.aop.RateLimiterAspect;
import com.cloudpivot.starter.ratelimiter.generator.DefaultRateLimiterNameGenerator;
import com.cloudpivot.starter.ratelimiter.generator.RateLimiterNameGenerator;

/**
 * 限流器自动配置
 *
 * @author KAI
 * @author CloudPivot Team
 * @since 2.2.0
 */
@AutoConfiguration(after = RedissonAutoConfiguration.class)
@EnableConfigurationProperties(RateLimiterProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.RATE_LIMITER, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class RateLimiterAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RateLimiterAutoConfiguration.class);

    /**
     * 限流器切面
     */
    @Bean
    public RateLimiterAspect rateLimiterAspect(RateLimiterProperties properties,
                                               RateLimiterNameGenerator rateLimiterNameGenerator,
                                               RedissonClient redissonClient) {
        return new RateLimiterAspect(properties, rateLimiterNameGenerator, redissonClient);
    }

    /**
     * 限流器名称生成器
     */
    @Bean
    @ConditionalOnMissingBean
    public RateLimiterNameGenerator nameGenerator() {
        return new DefaultRateLimiterNameGenerator();
    }

    @PostConstruct
    public void postConstruct() {
        log.debug("[CloudPivot Starter] - Auto Configuration 'RateLimiter' completed initialization.");
    }
}
