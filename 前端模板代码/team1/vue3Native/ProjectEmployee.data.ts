import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: 'projectId',
    align: "center",
    dataIndex: 'projectId'
  },
  {
    title: 'employeeId',
    align: "center",
    dataIndex: 'employeeId'
  },
  {
    title: '岗位',
    align: "center",
    dataIndex: 'post'
  },
  {
    title: '在岗日期',
    align: "center",
    dataIndex: 'start',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '离岗日期',
    align: "center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '备注',
    align: "center",
    dataIndex: 'remark'
  },
];

//查询数据
export const searchFormSchema: FormSchema[] = [
];

//表单数据
export const formSchema: FormSchema[] = [
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
    label: 'employeeId',
    field: 'employeeId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入employeeId!'},
             ];
    },
  },
  {
    label: '岗位',
    field: 'post',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入岗位!'},
             ];
    },
  },
  {
    label: '在岗日期',
    field: 'start',
    component: 'DatePicker',
  },
  {
    label: '离岗日期',
    field: 'end',
    component: 'DatePicker',
  },
  {
    label: '备注',
    field: 'remark',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入备注!'},
             ];
    },
  },
	// TODO 主键隐藏字段，目前写死为ID
  {
    label: '',
    field: 'id',
    component: 'Input',
    show: false,
  },
];
