<!--
setup 함수 안의 내용 (반응형 변수, 반응형 변수에 변화를 주는 함수, 라이프사이클 훅 등)
을 작성하여 view model의 개념을 작성하는 영역
-->
<script setup>

import MyComponent from "@/components/00_components/MyComponent.vue";
import PropsParent from "@/components/01_props/PropsParent.vue";
import DrillingParent from "@/components/02_props-drilling/DrillingParent.vue";
import SlotParent from "@/components/03_slot/SlotParent.vue";
import ScopeSlotParent from "@/components/04_scoped-slot/ScopeSlotParent.vue";
</script>
<!--
 사용자 화면에 보여지는 부분을 내보낼 때 작성하며 다른 엘리먼트 요소를 감싸주는 역할을 수행한다.
 화면에 렌더링 될 때는 제거되며 컴포넌트 단위의 html이 이 위치에 작성 된다.
-->
<template>
<header>
  <h3>00.component</h3>
  <MyComponent/>
</header>
  <main>
    <h3>01. Props</h3>
    <PropsParent/>
    <h3>02. Props Drilling</h3>
    <DrillingParent/>
    <h3>03. Slot</h3>
    <SlotParent/>
    <h3>04. Scoped Slot</h3>
    <ScopeSlotParent/>
  </main>
</template>
<!--
현재 컴포넌트에서만 적용 되는 스타일을 작성한다. 각 컴포넌트별 data-v-고유값에 적용된다.
공통적인 css는 src/asserts/css/ 디렉토리 하위에 파일로 작성하고 main.js에서 import해서
전역적으로 사용한다.
-->
<style scoped>
/* 만약 해당 스타일을 하위 컴포넌트에서 적용하고 싶을 경우
:deep(선택자) {} 의 형태로 작성한다. */
:deep(.container) {
  display: flex;
  flex-direction: column;
  align-items: center;
  border: 1px solid lightgray;
  margin : 30px;
  padding: 30px;
}
</style>
