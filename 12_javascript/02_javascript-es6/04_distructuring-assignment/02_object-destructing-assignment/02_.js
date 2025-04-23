// 다양한 사용법
const pants = {
    productName : '배기 팬츠',
    color : '검정색',
    price : 30000
};

// 프로퍼티가 많은 복잡한 객체에서 원하는 정보만 뽑아오고 싶을 때 사용한다.
const {productName} = pants;
console.log(productName);