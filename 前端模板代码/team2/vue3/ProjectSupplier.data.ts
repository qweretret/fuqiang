import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: 'supplierId',
    align:"center",
    dataIndex: 'supplierId'
   },
   {
    title: 'projectId',
    align:"center",
    dataIndex: 'projectId'
   },
   {
    title: '开始日期',
    align:"center",
    dataIndex: 'start',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '结束时间',
    align:"center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '主要服务内容',
    align:"center",
    dataIndex: 'service'
   },
   {
    title: '合同价钱',
    align:"center",
    dataIndex: 'contractPrice'
   },
   {
    title: '结算价钱',
    align:"center",
    dataIndex: 'lastPrice'
   },
   {
    title: '附件',
    align:"center",
    dataIndex: 'document'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'supplierId',
    field: 'supplierId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入supplierId!'},
          ];
     },
  },
  {
    label: 'projectId',
    field: 'projectId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入projectId!'},
          ];
     },
  },
  {
    label: '开始日期',
    field: 'start',
    component: 'DatePicker',
  },
  {
    label: '结束时间',
    field: 'end',
    component: 'DatePicker',
  },
  {
    label: '主要服务内容',
    field: 'service',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入主要服务内容!'},
          ];
     },
  },
  {
    label: '合同价钱',
    field: 'contractPrice',
    component: 'InputNumber',
  },
  {
    label: '结算价钱',
    field: 'lastPrice',
    component: 'InputNumber',
  },
  {
    label: '附件',
    field: 'document',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
