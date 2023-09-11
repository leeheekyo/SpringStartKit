package com.naver.blog.common.batch;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BatchVo {
	@Schema(name="배치 이름", required=true, example="AlarmSendJob", description="배치 작업 명")
	String batchName;
}
