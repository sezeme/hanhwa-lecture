
var dog = {
    name : '뽀삐',
    eat : function (food) {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요~`);
    }
};

// 1. 마침표 표기법(dot notation)
console.log(dog.name);
dog.eat('고구마');

// 2. 대괄호 표기법(square bracket notation)
console.log(dog['name']);
dog['eat']('닭가슴살');
// dog[eat]('닭가슴살'); -> 프로퍼티 키는 반드시 따옴표로 감싼 문자열을 사용

// 프로퍼티 키가 식별자 규칙을 준수하지 않을 경우 대괄호 표기법을 써야 한다.
var obj = {
    'dash-key' : 'dash-value',
    0 : 1
};

// console.log(obj.dash-key);
// console.log(obj.'dash-key');
// console.log(obj[dash-key]);
console.log(obj['dash-key']);

// console.log(obj.0);
// console.log(obj.'0');
console.log(obj[0]);
console.log(obj['0']);


