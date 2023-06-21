package com.multi.sample.web.common;

import com.multi.sample.common.utils.DateTimeUtil;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

@SpringBootTest
@ActiveProfiles("local")
public class DateTimeUtilTest {
    protected Logger LOG = LoggerFactory.getLogger(DateTimeUtilTest.class);

    @Test
    void testChangeTimeZone() {
        String format = "yyyy-MM-dd HH:mm:ss";
        LOG.debug(DateTimeUtil.getChangeTimeZone("2023-06-15 17:28:30", format, "Asia/Seoul", "UTC"));
        LOG.debug(DateTimeUtil.getChangeOffset(LocalDateTime.now(), 9, 7).toString());
    }
}
