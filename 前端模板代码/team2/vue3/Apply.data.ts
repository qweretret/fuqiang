import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '类型',
    align:"center",
    dataIndex: 'type'
   },
   {
    title: '盖章主要内容',
    align:"center",
    dataIndex: 'content'
   },
   {
    title: '发送单位',
    align:"center",
    dataIndex: 'sendCompany'
   },
   {
    title: '涉及金额',
    align:"center",
    dataIndex: 'amount'
   },
   {
    title: '起草部门',
    align:"center",
    dataIndex: 'draftDepart'
   },
   {
    title: '经办人',
    align:"center",
    dataIndex: 'handler'
   },
   {
    title: '会审部门',
    align:"center",
    dataIndex: 'trialDepart'
   },
   {
    title: '审批部门',
    align:"center",
    dataIndex: 'approvalDepart'
   },
   {
    title: '日期',
    align:"center",
    dataIndex: 'date',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text)
    },
   },
   {
    title: '所属单位',
    align:"center",
    dataIndex: 'belongCompany'
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
    label: '类型',
    field: 'type',
    component: 'Input',
  },
  {
    label: '盖章主要内容',
    field: 'content',
    component: 'Input',
  },
  {
    label: '发送单位',
    field: 'sendCompany',
    component: 'Input',
  },
  {
    label: '涉及金额',
    field: 'amount',
    component: 'Input',
  },
  {
    label: '起草部门',
    field: 'draftDepart',
    component: 'Input',
  },
  {
    label: '经办人',
    field: 'handler',
    component: 'Input',
  },
  {
    label: '会审部门',
    field: 'trialDepart',
    component: 'Input',
  },
  {
    label: '审批部门',
    field: 'approvalDepart',
    component: 'Input',
  },
  {
    label: '日期',
    field: 'date',
    component: 'DatePicker',
  },
  {
    label: '所属单位',
    field: 'belongCompany',
    component: 'Input',
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
