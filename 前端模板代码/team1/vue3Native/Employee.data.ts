import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: 'name',
    align: "center",
    dataIndex: 'name'
  },
  {
    title: 'gender',
    align: "center",
    dataIndex: 'gender'
  },
  {
    title: '岗位',
    align: "center",
    dataIndex: 'post'
  },
  {
    title: '身份证号码',
    align: "center",
    dataIndex: 'idCard'
  },
  {
    title: '身份证地址',
    align: "center",
    dataIndex: 'idCardAddr'
  },
  {
    title: '常住地',
    align: "center",
    dataIndex: 'permanentAddr'
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
    title: '部门',
    align: "center",
    dataIndex: 'depart'
  },
  {
    title: '社保日期',
    align: "center",
    dataIndex: 'insureDate'
  },
  {
    title: '离职日期',
    align: "center",
    dataIndex: 'end'
  },
  {
    title: '联系电话',
    align: "center",
    dataIndex: 'mobile'
  },
  {
    title: '家庭应急人及电话',
    align: "center",
    dataIndex: 'relation'
  },
  {
    title: '职称',
    align: "center",
    dataIndex: 'jobTitle'
  },
  {
    title: '学历',
    align: "center",
    dataIndex: 'education'
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
    label: 'name',
    field: 'name',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入name!'},
             ];
    },
  },
  {
    label: 'gender',
    field: 'gender',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入gender!'},
             ];
    },
  },
  {
    label: '岗位',
    field: 'post',
    component: 'Input',
  },
  {
    label: '身份证号码',
    field: 'idCard',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入身份证号码!'},
             ];
    },
  },
  {
    label: '身份证地址',
    field: 'idCardAddr',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入身份证地址!'},
             ];
    },
  },
  {
    label: '常住地',
    field: 'permanentAddr',
    component: 'Input',
  },
  {
    label: '入职日期',
    field: 'start',
    component: 'DatePicker',
  },
  {
    label: '部门',
    field: 'depart',
    component: 'Input',
  },
  {
    label: '社保日期',
    field: 'insureDate',
    component: 'Input',
  },
  {
    label: '离职日期',
    field: 'end',
    component: 'Input',
  },
  {
    label: '联系电话',
    field: 'mobile',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入联系电话!'},
             ];
    },
  },
  {
    label: '家庭应急人及电话',
    field: 'relation',
    component: 'Input',
  },
  {
    label: '职称',
    field: 'jobTitle',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
      return [
              { required: true, message: '请输入职称!'},
             ];
    },
  },
  {
    label: '学历',
    field: 'education',
    component: 'InputTextArea',
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
