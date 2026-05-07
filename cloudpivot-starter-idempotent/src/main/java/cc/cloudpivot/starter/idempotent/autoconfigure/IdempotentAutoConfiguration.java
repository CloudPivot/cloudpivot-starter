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

package cc.cloudpivot.starter.idempotent.autoconfigure;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import cc.cloudpivot.starter.cache.redisson.autoconfigure.RedissonAutoConfiguration;
import cc.cloudpivot.starter.core.constant.PropertiesConstants;
import cc.cloudpivot.starter.idempotent.aop.IdempotentAspect;
import cc.cloudpivot.starter.idempotent.generator.DefaultIdempotentNameGenerator;
import cc.cloudpivot.starter.idempotent.generator.IdempotentNameGenerator;

/**
 * 幂等自动配置
 *
 * @author loach
 * @author CloudPivot Team
 * @since 2.10.0
 */
@AutoConfiguration(after = RedissonAutoConfiguration.class)
@EnableConfigurationProperties(IdempotentProperties.class)
@ConditionalOnProperty(prefix = PropertiesConstants.IDEMPOTENT, name = PropertiesConstants.ENABLED, havingValue = "true", matchIfMissing = true)
public class IdempotentAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(IdempotentAutoConfiguration.class);

    /**
     * 幂等切面
     */
    @Bean
    public IdempotentAspect idempotentAspect(IdempotentProperties properties,
                                             IdempotentNameGenerator idempotentNameGenerator) {
        return new IdempotentAspect(properties, idempotentNameGenerator);
    }

    /**
     * 幂等名称生成器
     */
    @Bean
    @ConditionalOnMissingBean
    public IdempotentNameGenerator idempotentNameGenerator() {
        return new DefaultIdempotentNameGenerator();
    }

    @PostConstruct
    public void postConstruct() {
        log.debug("[CloudPivot Starter] - Auto Configuration 'Idempotent' completed initialization.");
    }
}