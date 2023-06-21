package com.multi.sample.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    /**
     * String 형태로 날짜와 시간을 입력받아 요청한 Zone의 시간대로 변경하여 반환한다.
     * @param orgDateTime      입력 시간 ("2023-06-15 17:28:30")
     * @param orgFormat        입력된 데이터의 포멧 ( "yyyy-MM-dd HH:mm:ss" )
     * @param orgTimeZone      입력된 데이터의 Zone Name ("Asia/Seoul")
     * @param changeTimeZone   변경한 Zone Name ("UTC")
     * @return
     */
    public static String getChangeTimeZone(String orgDateTime, String orgFormat, String orgTimeZone, String changeTimeZone) {
        String changeDateTime = "";

        if(orgDateTime == null || "".equals(orgDateTime)) {
            return changeDateTime;
        }

        try {
            SimpleDateFormat oSdf = new SimpleDateFormat(orgFormat);
            oSdf.setTimeZone(TimeZone.getTimeZone(orgTimeZone));

            Date dt = oSdf.parse(orgDateTime);

            SimpleDateFormat cSdf = new SimpleDateFormat(orgFormat);
            cSdf.setTimeZone(TimeZone.getTimeZone(changeTimeZone));
            changeDateTime = cSdf.format(dt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return changeDateTime;
    }

    /**
     * LOCAL DATE TIME을 입력받아 OFFSET 정보를 변경하여 반환한다.
     * @param orgDateTime   입력 시간
     * @param orgOffset     입력 시간의 OFFSET 값
     * @param changeOffset  변경할 OFFSET 값
     * @return
     */
    public static LocalDateTime getChangeOffset(LocalDateTime orgDateTime, int orgOffset, int changeOffset) {
        LocalDateTime changeDateTime = null;

        ZoneOffset orgZoneOffset = ZoneOffset.ofHours(orgOffset);
        OffsetDateTime orgOffsetDateTime = orgDateTime.atOffset(orgZoneOffset);
        OffsetDateTime newOffsetDateTime = orgOffsetDateTime.withOffsetSameLocal(ZoneOffset.ofHours(orgOffset));

        ZoneOffset changeZoneOffset = ZoneOffset.ofHours(changeOffset);
        OffsetDateTime utcDateTime  = newOffsetDateTime.withOffsetSameInstant(changeZoneOffset);
        changeDateTime = utcDateTime.toLocalDateTime();

        return changeDateTime;
    }
}
