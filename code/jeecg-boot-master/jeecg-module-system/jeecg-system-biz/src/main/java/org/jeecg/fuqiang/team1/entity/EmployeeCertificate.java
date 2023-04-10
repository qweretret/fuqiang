package org.jeecg.fuqiang.team1.entity;

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
 * @Description: 员工证书表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_employee_certificate")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_employee_certificate对象", description="员工证书表")
public class EmployeeCertificate implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**employeeId*/
	@Excel(name = "employeeId", width = 15)
    @ApiModelProperty(value = "employeeId")
    private String employeeId;
	/**等级*/
	@Excel(name = "等级", width = 15)
    @ApiModelProperty(value = "等级")
    private String level;
	/**专业*/
	@Excel(name = "专业", width = 15)
    @ApiModelProperty(value = "专业")
    private String major;
	/**发证机关*/
	@Excel(name = "发证机关", width = 15)
    @ApiModelProperty(value = "发证机关")
    private String institution;
	/**注册日期/发证日期*/
	@Excel(name = "注册日期/发证日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "注册日期/发证日期")
    private Date start;
	/**有效期止*/
	@Excel(name = "有效期止", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "有效期止")
    private Date end;
	/**附件*/
	@Excel(name = "附件", width = 15)
    @ApiModelProperty(value = "附件")
    private String document;
	/**是否网查*/
	@Excel(name = "是否网查", width = 15)
    @ApiModelProperty(value = "是否网查")
    private String isSearch;
	/**有无评审表*/
	@Excel(name = "有无评审表", width = 15)
    @ApiModelProperty(value = "有无评审表")
    private String hasReview;
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
	/**类别*/
	@Excel(name = "类别", width = 15)
    @ApiModelProperty(value = "类别")
    private String type;
}
