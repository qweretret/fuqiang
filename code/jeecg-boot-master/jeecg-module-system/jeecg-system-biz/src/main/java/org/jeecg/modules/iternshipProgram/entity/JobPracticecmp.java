package org.jeecg.modules.iternshipProgram.entity;

import java.io.Serializable;
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
 * @Description: 实习企业表
 * @Author: jeecg-boot
 * @Date:   2022-09-15
 * @Version: V1.0
 */
@Data
@TableName("job_practicecmp")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="job_practicecmp对象", description="实习企业表")
public class JobPracticecmp implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**企业名称*/
	@Excel(name = "企业名称", width = 15)
    @ApiModelProperty(value = "企业名称")
    private java.lang.String name;
	/**手机号*/
	@Excel(name = "手机号", width = 15)
    @ApiModelProperty(value = "手机号")
    private java.lang.String mobile;
	/**地址*/
	@Excel(name = "地址", width = 15)
    @ApiModelProperty(value = "地址")
    private java.lang.String address;
	/**来源类型*/
	@Excel(name = "来源类型", width = 15, dicCode = "job_source")
	@Dict(dicCode = "job_source")
    @ApiModelProperty(value = "来源类型")
    private java.lang.String source;
	/**规模*/
	@Excel(name = "规模", width = 15, dicCode = "job_enterprise_size")
	@Dict(dicCode = "job_enterprise_size")
    @ApiModelProperty(value = "规模")
    private java.lang.String maxemps;
	/**描述*/
	@Excel(name = "描述", width = 15)
    @ApiModelProperty(value = "描述")
    private java.lang.String descb;
	/**网站*/
	@Excel(name = "网站", width = 15)
    @ApiModelProperty(value = "网站")
    private java.lang.String url;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String remark;
	/**是否可用*/
	@Excel(name = "是否可用", width = 15, dicCode = "status")
	@Dict(dicCode = "status")
    @ApiModelProperty(value = "是否可用")
    private java.lang.String available;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
}
