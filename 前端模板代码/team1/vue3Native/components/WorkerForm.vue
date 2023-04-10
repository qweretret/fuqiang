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
          <a-form-item label="mobile" v-bind="validateInfos.mobile">
            <a-input v-model:value="formData.mobile" placeholder="请输入mobile" :disabled="disabled"></a-input>
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
          <a-form-item label="有无犯罪记录、失信记录" v-bind="validateInfos.hasIllegal">
            <a-input v-model:value="formData.hasIllegal" placeholder="请输入有无犯罪记录、失信记录" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="诚信情况" v-bind="validateInfos.creditState">
            <a-input v-model:value="formData.creditState" placeholder="请输入诚信情况" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="擅长专业" v-bind="validateInfos.adeptMajor">
            <a-input v-model:value="formData.adeptMajor" placeholder="请输入擅长专业" :disabled="disabled"></a-input>
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
  import { saveOrUpdate } from '../Worker.api';
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
    mobile: '',   
    id: '',
    idCard: '',   
    id: '',
    idCardAddr: '',   
    id: '',
    permanentAddr: '',   
    id: '',
    hasIllegal: '',   
    id: '',
    creditState: '',   
    id: '',
    adeptMajor: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
    name: [{ required: true, message: '请输入name!'},],
    gender: [{ required: true, message: '请输入gender!'},],
    mobile: [{ required: true, message: '请输入mobile!'},],
    idCard: [{ required: true, message: '请输入身份证号码!'},],
    idCardAddr: [{ required: true, message: '请输入身份证地址!'},],
    creditState: [{ required: true, message: '请输入诚信情况!'},],
    adeptMajor: [{ required: true, message: '请输入擅长专业!'},],
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
