import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '企业名称',
    align:"center",
    dataIndex: 'name',
   },
   {
    title: '手机号',
    align:"center",
    dataIndex: 'mobile'
   },
   {
    title: '地址',
    align:"center",
    dataIndex: 'address'
   },
   {
    title: '来源类型',
    align:"center",
    dataIndex: 'source_dictText'
   },
   {
    title: '规模',
    align:"center",
    dataIndex: 'maxemps_dictText'
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'descb'
   },
   {
    title: '网站',
    align:"center",
    dataIndex: 'url'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'remark'
   },
   {
    title: '是否可用',
    align:"center",
    dataIndex: 'available_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '企业名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '手机号',
    field: 'mobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: false},
                 { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号码!'},
          ];
     },
  },
  {
    label: '地址',
    field: 'address',
    component: 'Input',
  },
  {
    label: '来源类型',
    field: 'source',
    defaultValue: "学校",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_source"
     },
  },
  {
    label: '规模',
    field: 'maxemps',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_enterprise_size"
     },
  },
  {
    label: '描述',
    field: 'descb',
    component: 'Input',
  },
  {
    label: '网站',
    field: 'url',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'Input',
  },
  {
    label: '是否可用',
    field: 'available',
    defaultValue: "正常",
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"status"
     },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
