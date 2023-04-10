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
 * @Description: 月度计划及完成情况
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_work_plan")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_work_plan对象", description="月度计划及完成情况")
public class WorkPlan implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**工作类型*/
	@Excel(name = "工作类型", width = 15)
    @ApiModelProperty(value = "工作类型")
    private String workType;
	/**主要内容*/
	@Excel(name = "主要内容", width = 15)
    @ApiModelProperty(value = "主要内容")
    private String workContent;
	/**配合人员*/
	@Excel(name = "配合人员", width = 15)
    @ApiModelProperty(value = "配合人员")
    private String staff;
	/**完成时间*/
	@Excel(name = "完成时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "完成时间")
    private Date end;
	/**立项时间*/
	@Excel(name = "立项时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "立项时间")
    private Date startDate;
	/**预期完成时间*/
	@Excel(name = "预期完成时间", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "预期完成时间")
    private Date expectEnd;
	/**预期成效*/
	@Excel(name = "预期成效", width = 15)
    @ApiModelProperty(value = "预期成效")
    private String expectResult;
	/**是否遗留*/
	@Excel(name = "是否遗留", width = 15)
    @ApiModelProperty(value = "是否遗留")
    private String isRemain;
	/**完成或废除*/
	@Excel(name = "完成或废除", width = 15)
    @ApiModelProperty(value = "完成或废除")
    private String isEnd;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
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
