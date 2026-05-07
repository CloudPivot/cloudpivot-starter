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

package com.cloudpivot.starter.auth.justauth.autoconfigure.cache;

import jakarta.annotation.PostConstruct;
import me.zhyd.oauth.cache.AuthDefaultStateCache;
import me.zhyd.oauth.cache.AuthStateCache;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import com.cloudpivot.starter.auth.justauth.autoconfigure.JustAuthProperties;
import com.cloudpivot.starter.auth.justauth.cache.RedisAuthStateCache;
import com.cloudpivot.starter.core.constant.PropertiesConstants;

/**
 * JustAuth State 缓存配置
 *
 * @author <a href="https://gitee.com/justauth/justauth-spring-boot-starter">yangkai.shen</a>
 * @author CloudPivot Team
 * @since 2.15.0
 */
@Configuration(proxyBeanMethods = false)
public class JustAuthStateCacheConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JustAuthStateCacheConfiguration.class);

    /**
     * 使用内存
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnMissingBean(AuthStateCache.class)
    @ConditionalOnProperty(name = PropertiesConstants.AUTH_JUSTAUTH + ".cache.type", havingValue = "default", matchIfMissing = true)
    static class Default {

        @Bean
        public AuthStateCache authStateCache() {
            log.debug("[CloudPivot Starter] - Auto Configuration 'JustAuth-StateCache-Default' completed initialization.");
            return AuthDefaultStateCache.INSTANCE;
        }
    }

    /**
     * 使用 Redis
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnMissingBean(AuthStateCache.class)
    @ConditionalOnProperty(name = PropertiesConstants.AUTH_JUSTAUTH + ".cache.type", havingValue = "redis")
    static class Redis {

        @Bean
        public AuthStateCache authStateCache(JustAuthProperties properties, RedissonClient redissonClient) {
            log.debug("[CloudPivot Starter] - Auto Configuration 'JustAuth-StateCache-Redis' completed initialization.");
            return new RedisAuthStateCache(properties.getCache());
        }
    }

    /**
     * 自定义
     */
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnProperty(name = PropertiesConstants.AUTH_JUSTAUTH + ".cache.type", havingValue = "custom")
    static class Custom {

        @Bean
        @ConditionalOnMissingBean(AuthStateCache.class)
        public AuthStateCache authStateCache() {
            if (log.isErrorEnabled()) {
                log.error("[CloudPivot Starter] - When 'cloudpivot-starter.justauth.cache.type' is 'custom', you must provide a bean of type '{}' in your configuration.", ResolvableType
                    .forClass(AuthStateCache.class));
            }
            throw new NoSuchBeanDefinitionException(AuthStateCache.class);
        }

        @PostConstruct
        public void postConstruct() {
            log.debug("[CloudPivot Starter] - Auto Configuration 'JustAuth-StateCache-Custom' completed initialization.");
        }
    }
}
