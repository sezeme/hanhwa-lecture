<script setup>
import {provide, readonly, ref} from "vue";
import DrillingChild from "@/components/02_props-drilling/DrillingChild.vue";

/* Props Drilling : 상위 컴포넌트에서 하위 컴포넌트로 전달 하는 과정에서
* 여러 컴포넌트를 거치면 코드가 복잡하지고 유지보수가 어려워 진다.
* provide : 하위 컴포넌트에서 사용할 수 있는 값을 제공한다.
* inject : provide에서 제공 된 값을 꺼내서 사용한다.
* 단, 값 변경 추적이 어려울 수 있으므로 readonly 옵션을 고려한다.
* */
const count = ref(1);
// provide('count', count);
provide('count', readonly(count));

</script>

<template>
  <div class="container">
    <h1>Parent : {{ count }}</h1>
    <DrillingChild/>
  </div>
</template>

<style scoped>

</style>