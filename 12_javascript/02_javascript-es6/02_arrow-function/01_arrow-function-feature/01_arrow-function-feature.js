// 화살표 함수 특징
// 화살표 함수는 기존의 함수보다 표현이 간략한 것 뿐만 아니라 내부 동작 또한 간략화 되어 있다.

// 1. 화살표 함수는 this 를 가지지 않는다.
const theater =  {
    store : '건대점',
    titles : ['어벤저스', '겨울왕국', '스파이더맨'],
    showMovieList() {
        // 화살표 함수
        this.titles.forEach(title => console.log(`${this.store} : ${title}`));
        // 일반 함수
        this.titles.forEach(function(title) {
            // console.log(this); -> 일반 함수의 this는 전역 객체를 가리킨다.
            console.log(`${this.store} : ${title}`);
        });
    }
};
theater.showMovieList();

// 2. 화살표 함수는 new와 함께 호출할 수 없다.
const arrowFunc = () => {};
// new arrowFunc(); -> TypeError: arrowFunc is not a constructor
// 화살표 함수는 인스턴스를 생성할 수 없으므로 prototype 프로퍼티가 없다.
console.log(arrowFunc.hasOwnProperty("prototype"));

// 3. 화살표 함수는 super를 가지지 않는다.
class Animal {
    constructor(name, weight) {
        this.name = name;
        this.weight = weight;
    }

    move(lostWeight) {
        if(this.weight > lostWeight) {
            this.weight -= lostWeight;
            console.log(`${this.name}(은)는 움직임으로 인해 ${lostWeight}kg 감량되어 ${this.weight}kg이 되었습니다.`);
        }
    }
}

class Tiger extends Animal {
    move(lostWeight) {
        // 화살표 함수
        setTimeout(() => super.move(lostWeight), 3000);
        // 일반 함수 -> SyntaxError: 'super' keyword unexpected here
        // setTimeout(function(){ super.move(lostWeight) }, 3000);
    }
}

let tiger = new Tiger('백두산 호랭이', 90);
tiger.move(1);

// 4. 화살표 함수는 arguments를 가지지 않는다.
(function(){
    console.log(arguments);

    // 화살표 함수는 본인의 arguments 3, 4가 아닌 상위 스코프의 arguments 1, 2를 참조한다.
    const arrowFunc = () => console.log(arguments);
    arrowFunc(3, 4);

})(1, 2);

// 화살표 함수는 콜백 함수로 자주 사용 되며, 자신의 this/arguments 를 갖지 않고
// 상위 스코프를 그대로 참조하도록 설계 되어 ES5 콜백 함수에서 자주 발생하던
// this 바인딩 문제(전역 객체 or undefined 를 가리킴)를 간편하게 해결할 수 있다.
