<template>
  <div class="area">
    <div class="north">
      <slot name="north"></slot>
    </div>
    <div class="west">
      <slot name="west"></slot>
    </div>
    <div class="east">
      <slot name="east"></slot>
    </div>
    <div class="south">
      <slot name="south"></slot>
    </div>
  </div>
</template>

<style scoped>
.area {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  gap: 10px;
}

.north {
  grid-column: 1 / span 2;
  height: 200px;
  background-color: #ff9999;
}

.south {
  grid-column: 1 / span 2;
  height: 200px;
  background-color: #99ccff;
}

.east {
  width: 200px;
  height: 200px;
  background-color: #99ff99;
}

.west {
  width: 200px;
  height: 200px;
  background-color: #ffcc66;
}
</style>