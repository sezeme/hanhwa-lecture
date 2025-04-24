// 함수 매개변수 : 함수의 매개변수가 많거나 기본 값이 필요한 경우 활용한다.
function displayProduct(
    producer = "아무개", width = 0, height = 0, items = []
){

}
// 인수의 순서가 고정 되어 있기 때문에 순서가 바뀌면 안된다.
// 또 기본 값을 활용하더라도 undefined를 맞추어서 인수 자리에 넘겨주어야 한다.
displayProduct('신사임당', undefined, undefined, ["Coffee", "Donut"]);

function displayProduct2(
    { producer = "아무개", width = 0, height = 0, items = [] }
){

}
// 인수의 순서도 상관이 없고 값을 넘기지 않아도 기본 값이 적용 된다.
const example = { producer : '홍길동', items: ["doll", "robot"]};
displayProduct2(example);