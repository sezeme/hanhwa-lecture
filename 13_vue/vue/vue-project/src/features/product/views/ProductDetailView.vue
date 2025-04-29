<script setup>

import ProductDetail from "@/features/product/componenets/ProductDetail.vue";
</script>

<template>
  <div class="container mt-4">
    <div class="d-flex justify-content-end mb-3">
      <button @click="goToEditPage" class="btn btn-warning me-2" :disabled="isLoading">
        상품 수정
      </button>
      <button @click="confirmDelete" class="btn btn-danger" :disabled="isLoading">
        상품 삭제
      </button>
    </div>

    <div v-if="error" class="alert alert-danger">{{ error }}</div>
    <div v-else-if="isLoading">
      <p>Loading...</p>
    </div>
    <ProductDetail v-else :product="product" />

    <div v-if="confirmVisible" class="modal-backdrop">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">삭제 확인</h5>
          </div>
          <div class="modal-body">
            이 상품을 정말 삭제하시겠습니까?
          </div>
          <div class="modal-footer">
            <button @click="cancelDelete" class="btn btn-secondary">취소</button>
            <button @click="handleDelete" class="btn btn-danger">삭제</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>

.modal-backdrop {
  position: fixed;
  top: 0; left: 0;
  width: 100vw; height: 100vh;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1050;
}

.modal-dialog {
  max-width: 400px;
  width: 90%;
  margin: 0 1rem;
}

.modal-content {
  background: #fff;
  border-radius: 0.5rem;
  overflow: hidden;
  box-shadow: 0 0.5rem 1rem rgba(0, 0, 0, 0.15);
}

.modal-header,
.modal-body,
.modal-footer {
  padding: 1rem;
}

.modal-header {
  border-bottom: 1px solid #dee2e6;
}
.modal-footer {
  border-top: 1px solid #dee2e6;
  display: flex;
  justify-content: flex-end;
  gap: 0.5rem;
}
</style>