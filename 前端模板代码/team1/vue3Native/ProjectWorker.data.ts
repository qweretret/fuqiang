import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: 'workerId',
    align: "center",
    dataIndex: 'workerId'
  },
  {
    title: 'projectId',
    align: "center",
    dataIndex: 'projectId'
  },
  {
    title: '入职日期',
    align: "center",
    dataIndex: 'start',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '离职日期',
    align: "center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '计薪方式',
    align: "center",
    dataIndex: 'salaryType'
  },
  {
    title: '待遇',
    align: "center",
    dataIndex: 'salary'
  },
  {
    title: '所属班组长',
    align: "center",
    dataIndex: 'groupLeader'
  },
  {
    title: '附件',
    align: "center",
    dataIndex: 'document'
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
];

//表单数据
export const formSchema: FormSchema[] = [
  {
    label: 'workerId',
    field: 'workerId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入workerId!'},
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
    label: '入职日期',
    field: 'start',
    component: 'DatePicker',
  },
  {
    label: '离职日期',
    field: 'end',
    component: 'DatePicker',
  },
  {
    label: '计薪方式',
    field: 'salaryType',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入计薪方式!'},
             ];
    },
  },
  {
    label: '待遇',
    field: 'salary',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入待遇!'},
             ];
    },
  },
  {
    label: '所属班组长',
    field: 'groupLeader',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入所属班组长!'},
             ];
    },
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
    show: false,
  },
];
