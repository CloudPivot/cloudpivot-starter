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

package cc.cloudpivot.starter.core.constant;

/**
 * 配置属性相关常量
 *
 * @author CloudPivot Team
 * @since 1.1.1
 */
public class PropertiesConstants {

    /**
     * CloudPivot Starter
     */
    public static final String CLOUDPIVOT_STARTER = "cloudpivot-starter";

    /**
     * 启用配置
     */
    public static final String ENABLED = "enabled";

    /**
     * Web 配置
     */
    public static final String WEB = CLOUDPIVOT_STARTER + StringConstants.DOT + "web";

    /**
     * Web-跨域配置
     */
    public static final String WEB_CORS = WEB + StringConstants.DOT + "cors";

    /**
     * Web-响应配置
     */
    public static final String WEB_RESPONSE = WEB + StringConstants.DOT + "response";

    /**
     * 认证-JustAuth 配置
     */
    public static final String AUTH_JUSTAUTH = CLOUDPIVOT_STARTER + StringConstants.DOT + "justauth";

    /**
     * 加密配置
     */
    public static final String ENCRYPT = CLOUDPIVOT_STARTER + StringConstants.DOT + "encrypt";

    /**
     * 加密-密码编码器
     */
    public static final String ENCRYPT_PASSWORD_ENCODER = ENCRYPT + StringConstants.DOT + "password-encoder";

    /**
     * 加密-字段加密
     */
    public static final String ENCRYPT_FIELD = ENCRYPT + StringConstants.DOT + "field";

    /**
     * 加密-API 加密
     */
    public static final String ENCRYPT_API = ENCRYPT + StringConstants.DOT + "api";

    /**
     * 安全配置
     */
    public static final String SECURITY = CLOUDPIVOT_STARTER + StringConstants.DOT + "security";

    /**
     * 安全-XSS 配置
     */
    public static final String SECURITY_XSS = SECURITY + StringConstants.DOT + "xss";

    /**
     * 安全-敏感词配置
     */
    public static final String SECURITY_SENSITIVE_WORDS = SECURITY + StringConstants.DOT + "sensitive-words";

    /**
     * 限流配置
     */
    public static final String RATE_LIMITER = CLOUDPIVOT_STARTER + StringConstants.DOT + "rate-limiter";

    /**
     * 幂等配置
     */
    public static final String IDEMPOTENT = CLOUDPIVOT_STARTER + StringConstants.DOT + "idempotent";

    /**
     * 链路追踪配置
     */
    public static final String TRACE = CLOUDPIVOT_STARTER + StringConstants.DOT + "trace";

    /**
     * 验证码配置
     */
    public static final String CAPTCHA = CLOUDPIVOT_STARTER + StringConstants.DOT + "captcha";

    /**
     * 图形验证码配置
     */
    public static final String CAPTCHA_GRAPHIC = CAPTCHA + StringConstants.DOT + "graphic";

    /**
     * 行为验证码配置
     */
    public static final String CAPTCHA_BEHAVIOR = CAPTCHA + StringConstants.DOT + "behavior";

    /**
     * 消息配置
     */
    public static final String MESSAGING = CLOUDPIVOT_STARTER + StringConstants.DOT + "messaging";

    /**
     * WebSocket 配置
     */
    public static final String MESSAGING_WEBSOCKET = MESSAGING + StringConstants.DOT + "websocket";

    /**
     * MQTT 配置
     */
    public static final String MESSAGING_MQTT = MESSAGING + StringConstants.DOT + "mqtt";

    /**
     * 日志配置
     */
    public static final String LOG = CLOUDPIVOT_STARTER + StringConstants.DOT + "log";

    /**
     * 存储配置
     */
    public static final String STORAGE = CLOUDPIVOT_STARTER + StringConstants.DOT + "storage";

    /**
     * License 配置
     */
    public static final String LICENSE = CLOUDPIVOT_STARTER + StringConstants.DOT + "license";

    /**
     * License 生成器配置
     */
    public static final String LICENSE_GENERATOR = LICENSE + StringConstants.DOT + "generator";

    /**
     * License 校验器配置
     */
    public static final String LICENSE_VERIFIER = LICENSE + StringConstants.DOT + "verifier";

    /**
     * CRUD 配置
     */
    public static final String CRUD = CLOUDPIVOT_STARTER + StringConstants.DOT + "crud";

    /**
     * 数据权限配置
     */
    public static final String DATA_PERMISSION = CLOUDPIVOT_STARTER + StringConstants.DOT + "data-permission";


    private PropertiesConstants() {
    }
}
