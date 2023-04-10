import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
  {
    title: '工作类型',
    align: "center",
    dataIndex: 'workType'
  },
  {
    title: '主要内容',
    align: "center",
    dataIndex: 'workContent'
  },
  {
    title: '配合人员',
    align: "center",
    dataIndex: 'staff'
  },
  {
    title: '完成时间',
    align: "center",
    dataIndex: 'end',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '立项时间',
    align: "center",
    dataIndex: 'startDate',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '预期完成时间',
    align: "center",
    dataIndex: 'expectEnd',
    customRender:({text}) =>{
      return !text?"":(text.length>10?text.substr(0,10):text);
    },
  },
  {
    title: '预期成效',
    align: "center",
    dataIndex: 'expectResult'
  },
  {
    title: '是否遗留',
    align: "center",
    dataIndex: 'isRemain'
  },
  {
    title: '完成或废除',
    align: "center",
    dataIndex: 'isEnd'
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
    label: '工作类型',
    field: 'workType',
    component: 'Input',
  },
  {
    label: '主要内容',
    field: 'workContent',
    component: 'Input',
  },
  {
    label: '配合人员',
    field: 'staff',
    component: 'Input',
  },
  {
    label: '完成时间',
    field: 'end',
    component: 'DatePicker',
  },
  {
    label: '立项时间',
    field: 'startDate',
    component: 'DatePicker',
  },
  {
    label: '预期完成时间',
    field: 'expectEnd',
    component: 'DatePicker',
  },
  {
    label: '预期成效',
    field: 'expectResult',
    component: 'Input',
  },
  {
    label: '是否遗留',
    field: 'isRemain',
    component: 'Input',
  },
  {
    label: '完成或废除',
    field: 'isEnd',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'remark',
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
