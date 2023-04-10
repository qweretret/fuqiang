import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { watch,ref} from 'vue';
import {getjobCase} from './JobVolunteer.api';
import {defHttp} from '/@/utils/http/axios'
defHttp.get({
  url: '/jobVolunteer/jobVolunteer/getjobCase',
}).then((res)=>{
  jeecg3 = res
}).catch((error)=>{
  console.log(error)
})
const jeecg = ref(' ');
let jeecg2 = [];
let jeecg3 = [];
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '学生',
    align:"center",
    dataIndex: 'stuid_dictText'
   },
   {
    title: '企业',
    align:"center",
    dataIndex: 'enterpriseid_dictText'
   },
   {
    title: '实习岗位',
    align:"center",
    dataIndex: 'jobName_dictText'
   },
   {
    title: '理由',
    align:"center",
    dataIndex: 'reason'
   },
   {
    title: '是否就业',
    align:"center",
    dataIndex: 'employment_dictText'
   },
   {
    title: '是否指导',
    align:"center",
    dataIndex: 'guidance_dictText'
   },
   {
    title: '班主任意见',
    align:"center",
    dataIndex: 'teacherOpinion'
   },
   {
    title: '同意状态',
    align:"center",
    dataIndex: 'state_dictText'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'note'
   },
   {
    title: '系级指导',
    align:"center",
    dataIndex: 'departmentOpinion'
   },
   {
    title: '条款',
    align:"center",
    dataIndex: 'clause'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '学生',
    field: 'stuid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_stu,name,id"
     },
  },
  {
    label: '企业',
    field: 'enterpriseid',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_practicecmp,name,id",
        onChange: (e) => {
          jeecg.value = e; 
        },
    },
  },
  {
    label: '实习岗位',
    field: 'jobName',
    component: 'JDictSelectTag',
    componentProps:{
     
    },
  },
  {
    label: '理由',
    field: 'reason',
    component: 'Input',
  },
  {
    label: '是否就业',
    field: 'employment',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_employment"
     },
  },
  {
    label: '是否指导',
    field: 'guidance',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_guidance"
     },
  },
  {
    label: '班主任意见',
    field: 'teacherOpinion',
    component: 'Input',
  },
  {
    label: '同意状态',
    field: 'state',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"job_consent"
     },
  },
  {
    label: '备注',
    field: 'note',
    component: 'Input',
  },
  {
    label: '系级指导',
    field: 'departmentOpinion',
    component: 'Input',
  },
  {
    label: '条款',
    field: 'clause',
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

watch(jeecg, function (value, oldvalue) {
  if(value != oldvalue){
    jeecg.value = value;
    jeecg2 = [];
    for (const iterator of jeecg3) {
      if(value == iterator.company){
         jeecg2.push(iterator)
      }
    }
    console.log(jeecg2)
  }
  
})