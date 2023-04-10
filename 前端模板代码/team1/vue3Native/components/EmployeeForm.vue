<template>
  <a-spin :spinning="confirmLoading">
    <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol">
      <a-row>
        <a-col :span="24">
          <a-form-item label="name" v-bind="validateInfos.name">
            <a-input v-model:value="formData.name" placeholder="请输入name" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="gender" v-bind="validateInfos.gender">
            <a-input v-model:value="formData.gender" placeholder="请输入gender" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="岗位" v-bind="validateInfos.post">
            <a-input v-model:value="formData.post" placeholder="请输入岗位" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="身份证号码" v-bind="validateInfos.idCard">
            <a-input v-model:value="formData.idCard" placeholder="请输入身份证号码" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="身份证地址" v-bind="validateInfos.idCardAddr">
            <a-input v-model:value="formData.idCardAddr" placeholder="请输入身份证地址" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="常住地" v-bind="validateInfos.permanentAddr">
            <a-input v-model:value="formData.permanentAddr" placeholder="请输入常住地" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="入职日期" v-bind="validateInfos.start">
		        <a-date-picker placeholder="请选择入职日期" v-model:value="formData.start" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="部门" v-bind="validateInfos.depart">
            <a-input v-model:value="formData.depart" placeholder="请输入部门" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="社保日期" v-bind="validateInfos.insureDate">
            <a-input v-model:value="formData.insureDate" placeholder="请输入社保日期" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="离职日期" v-bind="validateInfos.end">
            <a-input v-model:value="formData.end" placeholder="请输入离职日期" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="联系电话" v-bind="validateInfos.mobile">
            <a-input v-model:value="formData.mobile" placeholder="请输入联系电话" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="家庭应急人及电话" v-bind="validateInfos.relation">
            <a-input v-model:value="formData.relation" placeholder="请输入家庭应急人及电话" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="职称" v-bind="validateInfos.jobTitle">
            <a-input v-model:value="formData.jobTitle" placeholder="请输入职称" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="学历" v-bind="validateInfos.education">
	          <a-textarea v-model:value="formData.education" rows="4" placeholder="请输入学历" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="附件" v-bind="validateInfos.document">
            <a-input v-model:value="formData.document" placeholder="请输入附件" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
      </a-row>
    </a-form>
  </a-spin>
</template>

<script lang="ts" setup>
  import { ref, reactive, defineExpose, nextTick, defineProps, computed } from 'vue';
  import { defHttp } from '/@/utils/http/axios';
  import { useMessage } from '/@/hooks/web/useMessage';
  import moment from 'moment';
  import { getValueType } from '/@/utils';
  import { saveOrUpdate } from '../Employee.api';
  import { Form } from 'ant-design-vue';
  
  const props = defineProps({
    disabled: { type: Boolean, default: false },
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    name: '',   
    id: '',
    gender: '',   
    id: '',
    post: '',   
    id: '',
    idCard: '',   
    id: '',
    idCardAddr: '',   
    id: '',
    permanentAddr: '',   
    id: '',
    start: '',   
    id: '',
    depart: '',   
    id: '',
    insureDate: '',   
    id: '',
    end: '',   
    id: '',
    mobile: '',   
    id: '',
    relation: '',   
    id: '',
    jobTitle: '',   
    id: '',
    education: '',   
    id: '',
    document: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
    name: [{ required: true, message: '请输入name!'},],
    gender: [{ required: true, message: '请输入gender!'},],
    idCard: [{ required: true, message: '请输入身份证号码!'},],
    idCardAddr: [{ required: true, message: '请输入身份证地址!'},],
    mobile: [{ required: true, message: '请输入联系电话!'},],
    jobTitle: [{ required: true, message: '请输入职称!'},],
  };
  const { resetFields, validate, validateInfos } = useForm(formData, validatorRules, { immediate: true });
  
  /**
   * 新增
   */
  function add() {
    edit({});
  }

  /**
   * 编辑
   */
  function edit(record) {
    nextTick(() => {
      resetFields();
      //赋值
      Object.assign(formData, record);
    });
  }

  /**
   * 提交数据
   */
  async function submitForm() {
    // 触发表单验证
    await validate();
    confirmLoading.value = true;
    const isUpdate = ref<boolean>(false);
    //时间格式化
    let model = formData;
    if (model.id) {
      isUpdate.value = true;
    }
    //循环数据
    for (let data in model) {
      //如果该数据是数组并且是字符串类型
      if (model[data] instanceof Array) {
        let valueType = getValueType(formRef.value.getProps, data);
        //如果是字符串类型的需要变成以逗号分割的字符串
        if (valueType === 'string') {
          model[data] = model[data].join(',');
        }
      }
    }
    await saveOrUpdate(model, isUpdate.value)
      .then((res) => {
        if (res.success) {
          createMessage.success(res.message);
          emit('ok');
        } else {
          createMessage.warning(res.message);
        }
      })
      .finally(() => {
        confirmLoading.value = false;
      });
  }


  defineExpose({
    add,
    edit,
    submitForm,
  });
</script>

<style lang="less" scoped>
  .antd-modal-form {
    height: 500px !important;
    overflow-y: auto;
    padding: 24px 24px 24px 24px;
  }
</style>
