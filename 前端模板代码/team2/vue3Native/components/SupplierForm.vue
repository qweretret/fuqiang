<template>
  <a-spin :spinning="confirmLoading">
    <a-form ref="formRef" class="antd-modal-form" :labelCol="labelCol" :wrapperCol="wrapperCol">
      <a-row>
        <a-col :span="24">
          <a-form-item label="单位名称" v-bind="validateInfos.companyName">
            <a-input v-model:value="formData.companyName" placeholder="请输入单位名称" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="纳税人识别号" v-bind="validateInfos.taxpayerNum">
            <a-input v-model:value="formData.taxpayerNum" placeholder="请输入纳税人识别号" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="单位电话" v-bind="validateInfos.companyMobile">
            <a-input v-model:value="formData.companyMobile" placeholder="请输入单位电话" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="办公地址" v-bind="validateInfos.companyAddr">
            <a-input v-model:value="formData.companyAddr" placeholder="请输入办公地址" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="注册时间" v-bind="validateInfos.registerTime">
		        <a-date-picker placeholder="请选择注册时间" v-model:value="formData.registerTime" value-format="YYYY-MM-DD"  style="width: 100%" :disabled="disabled"/>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="注册地址" v-bind="validateInfos.registerAddr">
            <a-input v-model:value="formData.registerAddr" placeholder="请输入注册地址" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="经济性质" v-bind="validateInfos.attribute">
            <a-input v-model:value="formData.attribute" placeholder="请输入经济性质" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="负责人姓名" v-bind="validateInfos.principalName">
            <a-input v-model:value="formData.principalName" placeholder="请输入负责人姓名" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="负责人电话" v-bind="validateInfos.principalMobile">
            <a-input v-model:value="formData.principalMobile" placeholder="请输入负责人电话" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="经营主体类别" v-bind="validateInfos.sellSubject">
            <a-input v-model:value="formData.sellSubject" placeholder="请输入经营主体类别" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="税务规模" v-bind="validateInfos.taxationScale">
            <a-input v-model:value="formData.taxationScale" placeholder="请输入税务规模" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="开户行及账号  json数组" v-bind="validateInfos.bankAccount">
            <a-input v-model:value="formData.bankAccount" placeholder="请输入开户行及账号  json数组" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="主要销售货物" v-bind="validateInfos.marketGoods">
            <a-input v-model:value="formData.marketGoods" placeholder="请输入主要销售货物" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="税务诚信等级
            分年度" v-bind="validateInfos.taxationCreditLevel">
            <a-input v-model:value="formData.taxationCreditLevel" placeholder="请输入税务诚信等级
            分年度" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="入库引进人" v-bind="validateInfos.storageBringMan">
            <a-input v-model:value="formData.storageBringMan" placeholder="请输入入库引进人" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="场所勘察情况" v-bind="validateInfos.siteState">
            <a-input v-model:value="formData.siteState" placeholder="请输入场所勘察情况" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="负面及正面情况" v-bind="validateInfos.evaluateState">
            <a-input v-model:value="formData.evaluateState" placeholder="请输入负面及正面情况" :disabled="disabled"></a-input>
          </a-form-item>
        </a-col>
        <a-col :span="24">
          <a-form-item label="其他信息" v-bind="validateInfos.ortherInfo">
            <a-input v-model:value="formData.ortherInfo" placeholder="请输入其他信息" :disabled="disabled"></a-input>
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
  import { saveOrUpdate } from '../Supplier.api';
  import { Form } from 'ant-design-vue';
  
  const props = defineProps({
    disabled: { type: Boolean, default: false },
  });
  const formRef = ref();
  const useForm = Form.useForm;
  const emit = defineEmits(['register', 'ok']);
  const formData = reactive<Record<string, any>>({
    id: '',
    companyName: '',   
    id: '',
    taxpayerNum: '',   
    id: '',
    companyMobile: '',   
    id: '',
    companyAddr: '',   
    id: '',
    registerTime: '',   
    id: '',
    registerAddr: '',   
    id: '',
    attribute: '',   
    id: '',
    principalName: '',   
    id: '',
    principalMobile: '',   
    id: '',
    sellSubject: '',   
    id: '',
    taxationScale: '',   
    id: '',
    bankAccount: '',   
    id: '',
    marketGoods: '',   
    id: '',
    taxationCreditLevel: '',   
    id: '',
    storageBringMan: '',   
    id: '',
    siteState: '',   
    id: '',
    evaluateState: '',   
    id: '',
    ortherInfo: '',   
    id: '',
    document: '',   
  });
  const { createMessage } = useMessage();
  const labelCol = ref<any>({ xs: { span: 24 }, sm: { span: 5 } });
  const wrapperCol = ref<any>({ xs: { span: 24 }, sm: { span: 16 } });
  const confirmLoading = ref<boolean>(false);
  //表单验证
  const validatorRules = {
    companyName: [{ required: true, message: '请输入单位名称!'},],
    taxpayerNum: [{ required: true, message: '请输入纳税人识别号!'},],
    registerTime: [{ required: true, message: '请输入注册时间!'},],
    principalName: [{ required: true, message: '请输入负责人姓名!'},],
    principalMobile: [{ required: true, message: '请输入负责人电话!'},],
    taxationScale: [{ required: true, message: '请输入税务规模!'},],
    bankAccount: [{ required: true, message: '请输入开户行及账号  json数组!'},],
    marketGoods: [{ required: true, message: '请输入主要销售货物!'},],
    taxationCreditLevel: [{ required: true, message: '请输入税务诚信等级
            分年度!'},],
    storageBringMan: [{ required: true, message: '请输入入库引进人!'},],
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
