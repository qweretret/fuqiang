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
 * @Description: 工人表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_worker")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_worker对象", description="工人表")
public class Worker implements Serializable {
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
	/**mobile*/
	@Excel(name = "mobile", width = 15)
    @ApiModelProperty(value = "mobile")
    private String mobile;
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
	/**有无犯罪记录、失信记录*/
	@Excel(name = "有无犯罪记录、失信记录", width = 15)
    @ApiModelProperty(value = "有无犯罪记录、失信记录")
    private String hasIllegal;
	/**诚信情况*/
	@Excel(name = "诚信情况", width = 15)
    @ApiModelProperty(value = "诚信情况")
    private String creditState;
	/**擅长专业*/
	@Excel(name = "擅长专业", width = 15)
    @ApiModelProperty(value = "擅长专业")
    private String adeptMajor;
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
