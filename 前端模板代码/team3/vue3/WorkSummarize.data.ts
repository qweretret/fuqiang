import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '日期',
    align:"center",
    dataIndex: 'date',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '经办人',
    align:"center",
    dataIndex: 'handler'
   },
   {
    title: '主管',
    align:"center",
    dataIndex: 'charge'
   },
   {
    title: '正负面情况',
    align:"center",
    dataIndex: 'evaluateState'
   },
   {
    title: '情况描述',
    align:"center",
    dataIndex: 'situation'
   },
   {
    title: '经验修正措施',
    align:"center",
    dataIndex: 'method'
   },
   {
    title: '经验总结人',
    align:"center",
    dataIndex: 'summarizer'
   },
   {
    title: '同类失误第*次',
    align:"center",
    dataIndex: 'faultNum'
   },
   {
    title: '备注说明',
    align:"center",
    dataIndex: 'remark'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '日期',
    field: 'date',
    component: 'DatePicker',
  },
  {
    label: '经办人',
    field: 'handler',
    component: 'Input',
  },
  {
    label: '主管',
    field: 'charge',
    component: 'Input',
  },
  {
    label: '正负面情况',
    field: 'evaluateState',
    component: 'Input',
  },
  {
    label: '情况描述',
    field: 'situation',
    component: 'Input',
  },
  {
    label: '经验修正措施',
    field: 'method',
    component: 'Input',
  },
  {
    label: '经验总结人',
    field: 'summarizer',
    component: 'Input',
  },
  {
    label: '同类失误第*次',
    field: 'faultNum',
    component: 'InputNumber',
  },
  {
    label: '备注说明',
    field: 'remark',
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
