package org.jeecg.fuqiang.team2.entity;

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
 * @Description: 申请表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_apply")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_apply对象", description="申请表")
public class Apply implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**类型*/
	@Excel(name = "类型", width = 15)
    @ApiModelProperty(value = "类型")
    private String type;
	/**盖章主要内容*/
	@Excel(name = "盖章主要内容", width = 15)
    @ApiModelProperty(value = "盖章主要内容")
    private String content;
	/**发送单位*/
	@Excel(name = "发送单位", width = 15)
    @ApiModelProperty(value = "发送单位")
    private String sendCompany;
	/**涉及金额*/
	@Excel(name = "涉及金额", width = 15)
    @ApiModelProperty(value = "涉及金额")
    private String amount;
	/**起草部门*/
	@Excel(name = "起草部门", width = 15)
    @ApiModelProperty(value = "起草部门")
    private String draftDepart;
	/**经办人*/
	@Excel(name = "经办人", width = 15)
    @ApiModelProperty(value = "经办人")
    private String handler;
	/**会审部门*/
	@Excel(name = "会审部门", width = 15)
    @ApiModelProperty(value = "会审部门")
    private String trialDepart;
	/**审批部门*/
	@Excel(name = "审批部门", width = 15)
    @ApiModelProperty(value = "审批部门")
    private String approvalDepart;
	/**日期*/
	@Excel(name = "日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "日期")
    private Date date;
	/**所属单位*/
	@Excel(name = "所属单位", width = 15)
    @ApiModelProperty(value = "所属单位")
    private String belongCompany;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private String document;
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
