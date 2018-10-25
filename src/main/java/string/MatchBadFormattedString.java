package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchBadFormattedString {
    public static void main(String[] args) {
        String theLine = "    \"msg\": \"File Content [u'<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>', u'', u'<configuration scan=\\\"true\\\" scanPeriod=\\\"10 minutes\\\">', u'    <jmxConfigurator />', u'', u'    <property name=\\\"max.retention.days\\\" value=\\\"10\\\" />', u'    <property name=\\\"hue.log.dir\\\" value=\\\"${TOMCAT_LOG_DIR}\\\"/>', u'    <property name=\\\"hue.layout\\\" value=\\\"@timestamp:%date{yyyy-MM-dd\\\\'T\\\\'HH:mm:ss.SSSZ}&#x9;hostname:%property{HOSTNAME}&#x9;tenantName:${COMPANY_APPLICATION_TENANT}&#x9;applicationName:${COMPANY_APPLICATION_NAME}&#x9;landscapeName:${COMPANY_APPLICATION_LANDSCAPE}&#x9;level:%level&#x9;loggerName:%logger&#x9;thread:%thread&#x9;serviceId:%X{serviceId}&#x9;userId:%X{userId}&#x9;companyId:%X{companyId}&#x9;sessionToken:%X{sessionToken}&#x9;requestToken:%X{requestToken}&#x9;timeZone:%X{timeZone}&#x9;method:%X{method}&#x9;url:%X{url}&#x9;correlationId:%X{correlationId}&#x9;message:%replace(%replace(%message){\\\\'\\\\\\\\n\\\\',\\\\'\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n\\\\'}){\\\\'\\\\\\\\t\\\\',\\\\'\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\t\\\\'}&#x9;throwable:%replace(%replace(%exception){\\\\'\\\\\\\\n\\\\',\\\\'\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n\\\\'}){\\\\'\\\\\\\\t\\\\',\\\\'\\\\'}%n%nopex\\\" />', u'    <property name=\\\"hue.audit.layout\\\" value=\\\"@timestamp:%date{yyyy-MM-dd\\\\'T\\\\'HH:mm:ss.SSSZ}&#x9;hostname:%property{HOSTNAME}&#x9;tenantName:${COMPANY_APPLICATION_TENANT}&#x9;applicationName:${COMPANY_APPLICATION_NAME}&#x9;landscapeName:${COMPANY_APPLICATION_LANDSCAPE}&#x9;level:%level&#x9;loggerName:%logger&#x9;thread:%thread&#x9;%replace(%message){\\\\'\\\\\\\\n\\\\',\\\\'\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n\\\\'}%n%nopex\\\" />', u'    <property name=\\\"event.log.layout\\\" value=\\\"@timestamp:%date{yyyy-MM-dd\\\\'T\\\\'HH:mm:ss.SSSZ}&#x9;tenantName:${COMPANY_APPLICATION_TENANT}&#x9;landscapeName:${COMPANY_APPLICATION_LANDSCAPE}&#x9;%msg%n\\\"/>', u'    <property name=\\\"hue.audit.access.file.pattern\\\" value=\\\"${hue.log.dir}/audit-access.%d{yyyyMMdd}-%i.log\\\" />', u'    <property name=\\\"event.log.file.pattern\\\" value=\\\"${hue.log.dir}/hue-event.%d{yyyyMMdd}-%i.log\\\" />', u'', u'    <appender name=\\\"CONSOLE\\\" class=\\\"ch.qos.logback.core.ConsoleAppender\\\">', u'        <encoder>', u'            <pattern>${hue.layout}</pattern>', u'        </encoder>', u'    </appender>', u'', u'    <appender name=\\\"FILE-BASE-CATALINA\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/catalina-base.log</file>', u'        <append>true</append>', u'        <encoder>', u'           <charset>utf-8</charset>', u'           <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/archive/catalina-base-%d{yyyyMMdd}-%i.log.zip</fileNamePattern>', u'            <maxHistory>${max.retention.days}</maxHistory>', u'            <cleanHistoryOnStart>true</cleanHistoryOnStart>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>20MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'', u'    <appender name=\\\"FILE-CATALINA\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/catalina.log</file>', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'     <pattern>${hue.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/archive/catalina-%d{yyyyMMdd}-%i.log.zip</fileNamePattern>', u'            <maxHistory>${max.retention.days}</maxHistory>', u'            <cleanHistoryOnStart>true</cleanHistoryOnStart>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>20MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"FILE-LOCALHOST\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/localhost.log</file>', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${hue.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/archive/localhost-%d{yyyyMMdd}-%i.log.zip</fileNamePattern>', u'            <maxHistory>${max.retention.days}</maxHistory>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>20MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"FILE-MANAGER\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/manager.log</file>', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${hue.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/archive/manager-%d{yyyyMMdd}-%i.log.zip</fileNamePattern>', u'            <maxHistory>${max.retention.days}</maxHistory>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>20MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"FILE-HOST-MANAGER\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/host-manager.log</file>', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${hue.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/archive/host-manager-%d{yyyyMMdd}-%i.log.zip</fileNamePattern>', u'            <maxHistory>${max.retention.days}</maxHistory>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>20MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"AUDIT-ACCESS\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${hue.audit.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.audit.access.file.pattern}</fileNamePattern>', u'            <maxHistory>1</maxHistory>', u'            <cleanHistoryOnStart>true</cleanHistoryOnStart>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>100MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"AUDIT-DATA-CHANGE\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <file>${hue.log.dir}/audit-datachange.log</file>', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${hue.audit.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${hue.log.dir}/audit-datachange.log.%d{yyyyMMdd}-%i.zip</fileNamePattern>', u'            <maxHistory>4</maxHistory>', u'            <cleanHistoryOnStart>true</cleanHistoryOnStart>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>5MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <appender name=\\\"FILE-HUE-EVENT-LOG\\\" class=\\\"ch.qos.logback.core.rolling.RollingFileAppender\\\">', u'        <append>true</append>', u'        <encoder>', u'            <charset>utf-8</charset>', u'            <pattern>${event.log.layout}</pattern>', u'        </encoder>', u'        <rollingPolicy class=\\\"ch.qos.logback.core.rolling.TimeBasedRollingPolicy\\\">', u'            <fileNamePattern>${event.log.file.pattern}</fileNamePattern>', u'            <maxHistory>1</maxHistory>', u'            <cleanHistoryOnStart>true</cleanHistoryOnStart>', u'            <timeBasedFileNamingAndTriggeringPolicy class=\\\"ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP\\\">', u'                <maxFileSize>100MB</maxFileSize>', u'            </timeBasedFileNamingAndTriggeringPolicy>', u'        </rollingPolicy>', u'    </appender>', u'', u'    <logger name=\\\"com.worksap.company\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-CATALINA\\\" />', u'      <appender-ref ref=\\\"FILE-BASE-CATALINA\\\"/>', u'    </logger>', u'', u'    <logger name=\\\"org.springframework\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-CATALINA\\\" />', u'      <appender-ref ref=\\\"FILE-BASE-CATALINA\\\"/>', u'    </logger>', u'', u'    <logger name=\\\"org.apache.catalina\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-CATALINA\\\" />', u'      <appender-ref ref=\\\"FILE-BASE-CATALINA\\\"/>', u'    </logger>', u'', u'    <logger name=\\\"org.apache.catalina.core.ContainerBase.[Catalina].[localhost]\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-LOCALHOST\\\" />', u'    </logger>', u'', u'    <logger name=\\\"org.apache.catalina.core.ContainerBase.[Catalina].[localhost].[/manager]\\\" level=\\\"INFO\\\"', u'        additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-MANAGER\\\" />', u'    </logger>', u'', u'    <logger name=\\\"org.apache.catalina.core.ContainerBase.[Catalina].[localhost].[/host-manager]\\\" level=\\\"INFO\\\"', u'        additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-HOST-MANAGER\\\" />', u'    </logger>', u'', u'    <logger name=\\\"audit.hue.access.log\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"AUDIT-ACCESS\\\" />', u'    </logger>', u'', u'    <logger name=\\\"audit.hue.datachange.log\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"AUDIT-DATA-CHANGE\\\" />', u'    </logger>', u'', u'    <logger name=\\\"com.worksap.company.eventlog.impl.EventLogImpl\\\" level=\\\"INFO\\\" additivity=\\\"false\\\">', u'      <appender-ref ref=\\\"FILE-HUE-EVENT-LOG\\\" />', u'    </logger>', u'', u'    <root level=\\\"ERROR\\\">', u'      <appender-ref ref=\\\"FILE-CATALINA\\\" />', u'      <appender-ref ref=\\\"FILE-BASE-CATALINA\\\"/>', u'    </root>', u'', u'</configuration>']\"";
        Pattern filePattern = Pattern.compile("\"msg\":.*File Content.*\\[(.*)].*");
        Matcher matcher = filePattern.matcher(theLine);
        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}