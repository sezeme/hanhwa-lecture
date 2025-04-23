// 다양한 사용법
const pants = {
    productName : '배기 팬츠',
    color : '검정색',
    price : 30000
};

// 프로퍼티가 많은 복잡한 객체에서 원하는 정보만 뽑아오고 싶을 때 사용한다.
const {productName} = pants;
console.log(productName);

// 객체에 존재하지 않는 프로퍼티에 기본 값을 설정해서 사용할 수 있다.
const shirts = {productName: '베이직 셔츠'};
const { productName : pn, color : co = "어떤 색상", price: pr = 0} = shirts;
console.log(pn);
console.log(co);
console.log(pr);

// rest parameter 를 활용해서 나머지 요소를 한 번에 가져올 수 있다.
const { productName : pn2, ...rest} = pants;
console.log(pn2);
console.log(rest);

// let 키워드 없이 작성 되었을 경우의 문제
let pn3, co3, pr3;
// 구조 분해 할당 묹법이 아니라 코드 블럭으로 {} 중괄호를 해석해서 발생하는 문제
// { productName : pn, color : co = "어떤 색상", price: pr = 0} = pants;
// 소괄호로 전체 영역을 감싸주면 오류 발생하지 않음
({ productName : pn3, color : co3 , price: pr3 } = pants);
console.log(pn3);
console.log(co3);
console.log(pr3);


