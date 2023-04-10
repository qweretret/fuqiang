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
 * @Description: 员工表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_employee")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_employee对象", description="员工表")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**name*/
	@Excel(name = "name", width = 15)
    @ApiModelProperty(value = "name")
    private String name;
	/**gender*/
	@Excel(name = "gender", width = 15)
    @ApiModelProperty(value = "gender")
    private String gender;
	/**岗位*/
	@Excel(name = "岗位", width = 15)
    @ApiModelProperty(value = "岗位")
    private String post;
	/**身份证号码*/
	@Excel(name = "身份证号码", width = 15)
    @ApiModelProperty(value = "身份证号码")
    private String idCard;
	/**身份证地址*/
	@Excel(name = "身份证地址", width = 15)
    @ApiModelProperty(value = "身份证地址")
    private String idCardAddr;
	/**常住地*/
	@Excel(name = "常住地", width = 15)
    @ApiModelProperty(value = "常住地")
    private String permanentAddr;
	/**入职日期*/
	@Excel(name = "入职日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "入职日期")
    private Date start;
	/**部门*/
	@Excel(name = "部门", width = 15)
    @ApiModelProperty(value = "部门")
    private String depart;
	/**社保日期*/
	@Excel(name = "社保日期", width = 15)
    @ApiModelProperty(value = "社保日期")
    private String insureDate;
	/**离职日期*/
	@Excel(name = "离职日期", width = 15)
    @ApiModelProperty(value = "离职日期")
    private String end;
	/**联系电话*/
	@Excel(name = "联系电话", width = 15)
    @ApiModelProperty(value = "联系电话")
    private String mobile;
	/**家庭应急人及电话*/
	@Excel(name = "家庭应急人及电话", width = 15)
    @ApiModelProperty(value = "家庭应急人及电话")
    private String relation;
	/**职称*/
	@Excel(name = "职称", width = 15)
    @ApiModelProperty(value = "职称")
    private String jobTitle;
	/**学历*/
	@Excel(name = "学历", width = 15)
    @ApiModelProperty(value = "学历")
    private String education;
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
