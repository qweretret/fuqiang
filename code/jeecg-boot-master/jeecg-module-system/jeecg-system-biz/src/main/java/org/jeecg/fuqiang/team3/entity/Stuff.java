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
 * @Description: 物料表
 * @Author: jeecg-boot
 * @Date:   2022-11-28
 * @Version: V1.0
 */
@Data
@TableName("fq_stuff")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="fq_stuff对象", description="物料表")
public class Stuff implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private String id;
	/**单位*/
	@Excel(name = "单位", width = 15)
    @ApiModelProperty(value = "单位")
    private String unit;
	/**税率*/
	@Excel(name = "税率", width = 15)
    @ApiModelProperty(value = "税率")
    private BigDecimal taxRate;
	/**不含税价*/
	@Excel(name = "不含税价", width = 15)
    @ApiModelProperty(value = "不含税价")
    private BigDecimal excludeTax;
	/**含税价*/
	@Excel(name = "含税价", width = 15)
    @ApiModelProperty(value = "含税价")
    private BigDecimal includeTax;
	/**区域*/
	@Excel(name = "区域", width = 15)
    @ApiModelProperty(value = "区域")
    private String area;
	/**供应商*/
	@Excel(name = "供应商", width = 15)
    @ApiModelProperty(value = "供应商")
    private String supplierId;
	/**数据来源*/
	@Excel(name = "数据来源", width = 15)
    @ApiModelProperty(value = "数据来源")
    private String dataSoure;
	/**检查日期*/
	@Excel(name = "检查日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "检查日期")
    private Date checkDate;
	/**采购日期*/
	@Excel(name = "采购日期", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "采购日期")
    private Date purcherDate;
	/**标准or内容*/
	@Excel(name = "标准or内容", width = 15)
    @ApiModelProperty(value = "标准or内容")
    private String content;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private String remark;
	/**走势*/
	@Excel(name = "走势", width = 15)
    @ApiModelProperty(value = "走势")
    private String trend;
	/**材料类型*/
	@Excel(name = "材料类型", width = 15)
    @ApiModelProperty(value = "材料类型")
    private String typeId;
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
