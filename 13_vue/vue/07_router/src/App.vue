<script setup>

</script>

<template>
  <header>
    <div class="wrapper">
      <h1>Router Test</h1>
      <hr>
      <h2>Basic Router</h2>
      <!--
      RouterLink : 페이지 간 네비게이션을 위한 컴포넌트로 a 태그로 동작하며
      클릭 시 to 속성의 URL 로 라우팅 된다.
      -->
      <nav>
        <RouterLink to="/" active-class="active" replace>Home</RouterLink>
        <RouterLink to="/pathvariable/1" active-class="active" replace>PathVariable</RouterLink>
        <RouterLink to="/querystring?name=홍길동&age=20" active-class="active" replace>QueryString</RouterLink>
      </nav>
      <h2>Nested Router</h2>
<!--      <nav>
        <RouterLink to="/nested/home">중첩 HOME VIEW</RouterLink>
        <RouterLink to="/nested/other">중첩 OTHER VIEW</RouterLink>
      </nav>-->
    </div>
  </header>
  <main>
    <!--
      RouterView : 현재 활성화 된 라우트에 따라 해당 컴포넌트를 렌더링 하는 역할
    -->
    <RouterView/>
  </main>

</template>

<style scoped>
nav {
  width: 100%;
  text-align: center;
  margin-top: 2rem;
  font-size: 30px;
}

a {
  margin-left: 10px;
}

.active {
  color: red;
}

main {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

header {
  text-align: center;
}
</style>
