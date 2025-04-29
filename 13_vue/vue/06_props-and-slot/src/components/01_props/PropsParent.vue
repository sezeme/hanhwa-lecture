<script setup>

import PropsChild from "@/components/01_props/PropsChild.vue";
import {ref} from "vue";
import DarkMode from "@/components/01_props/DarkMode.vue";
import ReadOnlyProps from "@/components/01_props/ReadOnlyProps.vue";
const message = ref('hello');
const darkState = ref(false);
const readValue = ref('읽기 전용 값');
const toggleDarkMode = () => darkState.value = !darkState.value;
</script>

<template>
  <div :class="{ container : true, dark : darkState }">
    props 입력 : <input type="text" v-model="message">
    <!-- Child 컴포넌트에 message를 props로 전달한다. (:message 가 props명)
    다른 이름으로 전달하는 것도 가능하지만 일반적으로 같은 이름을 사용한다. -->
    <PropsChild :message="message"/>
    <!--
    DarkMode 컴포넌트가 toggle 이벤트를 emit하면 toggleDarkMode 함수가 실행된다.
    -->
    <DarkMode @toggle="toggleDarkMode"/>
    <!--
    자식 컴포넌트에서 props는 read-only이기 때문에 변경해도 변경 되지 않으며
    warning이 발생한다.
    -->
    부모의 value : <input type="text" v-model="readValue">
    <ReadOnlyProps :readValue="readValue"/>
  </div>
</template>

<style scoped>
  .dark {
    background-color: black;
    color : white;
  }
</style>