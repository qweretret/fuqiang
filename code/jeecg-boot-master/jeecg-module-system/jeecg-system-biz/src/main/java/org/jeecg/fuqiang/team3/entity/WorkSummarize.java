package org.jeecg.fuqiang.team3.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 月度总结性工作台账
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_work_summarize")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_work_summarize对象", description="月度总结性工作台账")
public class WorkSummarize implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**日期*/
	@Excel(name = "日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "日期")
    private Date date;
	/**经办人*/
	@Excel(name = "经办人", width = 15)
    @ApiModelProperty(value = "经办人")
    private String handler;
	/**主管*/
	@Excel(name = "主管", width = 15)
    @ApiModelProperty(value = "主管")
    private String charge;
	/**正负面情况*/
	@Excel(name = "正负面情况", width = 15)
    @ApiModelProperty(value = "正负面情况")
    private String evaluateState;
	/**情况描述*/
	@Excel(name = "情况描述", width = 15)
    @ApiModelProperty(value = "情况描述")
    private String situation;
	/**经验修正措施*/
	@Excel(name = "经验修正措施", width = 15)
    @ApiModelProperty(value = "经验修正措施")
    private String method;
	/**经验总结人*/
	@Excel(name = "经验总结人", width = 15)
    @ApiModelProperty(value = "经验总结人")
    private String summarizer;
	/**同类失误第*次*/
	@Excel(name = "同类失误第*次", width = 15)
    @ApiModelProperty(value = "同类失误第*次")
    private Integer faultNum;
	/**备注说明*/
	@Excel(name = "备注说明", width = 15)
    @ApiModelProperty(value = "备注说明")
    private String remark;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private String updateBy;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
